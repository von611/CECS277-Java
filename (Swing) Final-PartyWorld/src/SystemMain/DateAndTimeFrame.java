package SystemMain;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import Rooms.Room;

public class DateAndTimeFrame extends JFrame{
	private JPanel panel;
	private JLabel SELECTED;
	private JComboBox rooms, type;
	private JButton cont;
	ArrayList<Room> listOfRooms;
	ArrayList<Guest> checkIn;
	ArrayList<Guest> checkOut;

	public DateAndTimeFrame(ArrayList<Room> types, ArrayList<Guest> checkIn, ArrayList<Guest> checkOut) {
		this.listOfRooms = types;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.setTitle("Date and Time Frame");
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		createComponents();
		this.setVisible(true);
	}
	public void createComponents() {
		this.panel = new JPanel();
		this.panel.setLayout(null);
		SELECTED = new JLabel("SELECT ROOM:");
		SELECTED.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		Dimension size = SELECTED.getPreferredSize();
		SELECTED.setBounds(10, 10, size.width, size.height);
	 	panel.add(SELECTED);
	 	
	 	String[] type = {"Aqua World", "Small Party Rooms", "Medium Party Rooms", "Adult Billiards Lounge", "Karaoke Lounge"};
	 	this.rooms = new JComboBox<String>(type);
	 	this.rooms.setBounds(10, 30, 150, 20);
	 	this.rooms.addActionListener(new RoomListener());
	 	panel.add(this.rooms);
	 	
	 	String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	 	JLabel INFOLABEL = new JLabel("MONTH:");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		size = INFOLABEL.getPreferredSize();
	 	INFOLABEL.setBounds(200, 10, size.width, size.height);
	 	panel.add(INFOLABEL);
	 	SpinnerListModel monthModel = new SpinnerListModel(month);
	 	JSpinner spinner = new JSpinner(monthModel);
	 	spinner.setBounds(200, 30, 150, 20);
	 	panel.add(spinner);
	 	
		INFOLABEL = new JLabel("DAY:");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		size = INFOLABEL.getPreferredSize();
	 	INFOLABEL.setBounds(200, 50, size.width, size.height);
	 	panel.add(INFOLABEL);
	 	SpinnerModel dayModel = new SpinnerNumberModel(1, 1, 31, 1);
	 	spinner = new JSpinner(dayModel);
	 	spinner.setBounds(200, 70, 150, 20);
	 	panel.add(spinner);
	 	
	 	INFOLABEL = new JLabel("TIME:");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		size = INFOLABEL.getPreferredSize();
	 	INFOLABEL.setBounds(10, 50, size.width, size.height);
	 	panel.add(INFOLABEL);
	 	SpinnerModel timeModel = new SpinnerNumberModel(9, 1, 12, 1);
	 	spinner = new JSpinner(timeModel);
	 	spinner.setBounds(10, 70, 50, 20);
	 	panel.add(spinner);
	 	SpinnerModel timeModel2 = new SpinnerNumberModel(12, 1, 12, 1);
	 	spinner = new JSpinner(timeModel2);
	 	spinner.setBounds(60, 70, 50, 20);
	 	panel.add(spinner);
	 	
	 	this.cont = new JButton("Continue");
	 	this.cont.addActionListener(new ContinueButtonListener());
		size = this.cont.getPreferredSize();
	 	this.cont.setBounds(140, 100, size.width, size.height);
	 	panel.add(this.cont);
	 	
	 	this.add(panel);
	}
	void updateData(String roomName) {
		panel.remove(this.rooms);
		SELECTED.setText(roomName);
		Dimension size = SELECTED.getPreferredSize();
		SELECTED.setBounds(10, 10, size.width, size.height);
		panel.revalidate();
		panel.repaint();
		this.setVisible(true);
	}
	class ContinueButtonListener implements ActionListener {
		/**
		 * @param click continues to ReservationFrame
		 */
		@Override
		public void actionPerformed(ActionEvent click) {
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			ReservationFrame reservation = new ReservationFrame(listOfRooms, checkIn, checkOut);
			reservation.setVisible(true);
			frame.setVisible(false);
		}
	}
	class RoomListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Component select = (Component) e.getSource();
			String selectedItem = (String)rooms.getSelectedItem();
			String[] list = new String[listOfRooms.size()];
			panel.remove(type);
			int counter = 0;
			if(selectedItem.equals("Small Party Rooms")) {
				System.out.println("Small Party Rooms");
				for(int i = 0; i < listOfRooms.size(); i++) {
					if(listOfRooms.get(i).getType().equals("Small Party Room")) {
						list[counter] = listOfRooms.get(i).toString();
						counter++;
					}
				}
			}
			if(selectedItem.equals("Medium Party Rooms")) {
				for(int i = 0; i < listOfRooms.size(); i++) {
					if(listOfRooms.get(i).getType().equals("Medium Party Room")) {
						//list += room.getRoom() + "\n";	
						list[counter] = listOfRooms.get(i).toString();
						counter++;
					}
				}
			}
			if(selectedItem.equals("Karaoke Lounge")) {
				for(int i = 0; i < listOfRooms.size(); i++) {
					if(listOfRooms.get(i).getType().equals("Karaoke Lounge")) {
						//list += room.getRoom() + "\n";	
						list[counter] = listOfRooms.get(i).toString();
						counter++;
					}
				}
			}
			if(selectedItem.equals("Adult Billiards Lounge")) {
				for(int i = 0; i < listOfRooms.size(); i++) {
					if(listOfRooms.get(i).getType().equals("Adult Billiards Lounge")) {
						//list += room.getRoom() + "\n";	
						list[counter] = listOfRooms.get(i).toString();
						counter++;
					}
				}
			}
			if(selectedItem.equals("Aqua World")) {
				for(int i = 0; i < listOfRooms.size(); i++) {
					if(listOfRooms.get(i).getType().equals("Aqua World")) {
						//list += room.getRoom() + "\n";	
						list[counter] = listOfRooms.get(i).toString();
						counter++;
					}
				}
			}
		 	type = new JComboBox<String>(list);
		 	type.setBounds(580, 290, 300, 20);
		 	panel.add(type);
			panel.revalidate();
			panel.repaint();
		}
		
	}
	//public static void main(String[] args) {
		//ArrayList<Room> rooms = new ArrayList<Room>();
		//DateAndTimeFrame date = new DateAndTimeFrame(rooms, checkIn, checkOut);
		//date.setVisible(true);
	//}
}

