package SystemMain;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Rooms.Room;
import SystemMain.CheckInFrame.CancelButtonListener;
import SystemMain.CheckInFrame.CheckInButtonListener;

public class CheckOutFrame extends JFrame{
	
	private JButton cancelButton = new JButton("Cancel");
	private JButton checkOutButton = new JButton("Check-Out");
	private JPanel panel;
	private JList<String> guests;
	private JLabel instructions;
	private JTextField damageDescriptionBox;
	private JTextField damageChargeBox;
	private JTextArea invoice;
	
	private static final int FRAMEWIDTH = 750;
	private static final int FRAMEHEIGHT = 400;
	private static final int FIELDWIDTH = 50;
	private static final int AREAROWS = 30;
	private static final int AREACOLUMNS = 60;
	private static final int NEWFRAMEHEIGHT = 600;
	private static final int NEWFRAMEWIDTH = 700;
	
	private ArrayList<Guest> checkOut;
	
	public CheckOutFrame(ArrayList<Guest> checkOut) {
		
		this.checkOut = checkOut;
		this.createComponents();
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		this.setTitle("Check-Out");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	private void createComponents() {
		
		instructions = new JLabel("Check-Out Guest:");
		
		damageDescriptionBox = new JTextField(FIELDWIDTH);
		damageChargeBox = new JTextField(FIELDWIDTH);
		
		String checkOutGuest[] = new String[checkOut.size()];
		
		for (int i = 0; i < checkOut.size(); i++) {
			
			checkOutGuest[i] = checkOut.get(i).getName();
		}
		
		guests = new JList<String>(checkOutGuest);
		
		ActionListener cancelListener = new CancelButtonListener();
		cancelButton.addActionListener(cancelListener);
		
		ActionListener checkOutListener = new CheckOutButtonListener();
	    checkOutButton.addActionListener(checkOutListener);
		
		panel = new JPanel();
		panel.add(new JLabel("Damage Description: "));
		panel.add(damageDescriptionBox);
		panel.add(new JLabel("Damage Cost: "));
		panel.add(damageChargeBox);
		panel.add(instructions);
		panel.add(guests);
		panel.add(checkOutButton);
		panel.add(cancelButton);
		
		this.add(panel);
	}
	private void updateComponents(Guest guest) {
		
		Guest thisGuest = guest;
		Room guestRoom = guest.getRoom();
		Card guestCard = guest.getCard();
		
		panel.removeAll();
		
		this.setSize(NEWFRAMEWIDTH, NEWFRAMEHEIGHT);
		invoice = new JTextArea(AREAROWS, AREACOLUMNS);
		
		invoice.setText("------------------------------------------------------------------------- Invoice -------------------------------------------------------------------------\n\n");
		invoice.append("Guest Information: " + thisGuest.getName());
		invoice.append("\t\t" + thisGuest.getAddress());
		invoice.append("\t\t" + thisGuest.getPhone());
		invoice.append("\t\t" + thisGuest.getEmail());
		
		invoice.append("\n\nCredit Card Information: " + guestCard.getCompany());
		invoice.append("\t\t" + guestCard.getCCNumber());
		invoice.append("\t\t" + guestCard.expDate());
		
		invoice.append("\n\nTotal :" + String.format("$%.2f", guestRoom.getCost()));
		invoice.append("\t" + damageDescriptionBox.getText());
		invoice.append("\t" + damageChargeBox.getText());
		String damageCharge = damageChargeBox.getText();
		double damages = Double.parseDouble(damageCharge);
		double grandTotal = damages + guestRoom.getCost();
		invoice.append("Grand Total: " + String.format("$%.2f", grandTotal));
		
		
		JScrollPane scrollPane = new JScrollPane(invoice);
		panel.add(scrollPane);
		
		add(panel);
		panel.revalidate();
		panel.repaint();
	}
	 /**
		 * a class that implements action listener on the cancel button listener
		 * **/
	    class CancelButtonListener implements ActionListener {
			
	    	/**
			 *checks to see if the cancel button was clicked on the GUI
			 *@param click- an action event that checks if the button was clicked
			 * **/
			public void actionPerformed(ActionEvent click) {
				
				setVisible(false);
				
			}
		}
	    class CheckOutButtonListener implements ActionListener {
	    	
	    	public void actionPerformed(ActionEvent click) {
	    		
	    		
	    		int index = guests.getSelectedIndex();
	    		Guest thisGuest = checkOut.get(index);
	    		checkOut.remove(index);
	    		updateComponents(thisGuest);
	    		
	    	}
	    }

}