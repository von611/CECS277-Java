package SystemMain;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import Rooms.*;
import MealPlans.*;
public class MainFrame extends JFrame {
	JMenuBar menuBar;
	JScrollPane scrollPane;
	JPanel centerPanel;
	ArrayList<Room> listOfRooms;
	ArrayList<Guest> checkInGuests;
	ArrayList<Guest> checkOutGuests;
	
	//border settings used in the method addARoomDescription()
 	Border raisedbevel = BorderFactory.createRaisedBevelBorder(); 
 	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	
	public MainFrame(ArrayList<Guest> checkIn, ArrayList<Guest> checkOut){
		this.listOfRooms = new ArrayList<Room>();
		checkInGuests = checkIn;
		checkOutGuests = checkOut;
		this.setTitle("Reservation System");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //makes window screen size
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.createMenuBar();
		this.createDefaultPanel();
		//Room spr =  new SmallPartyRoom();
		//SmallPartyRoom room = (SmallPartyRoom)spr.makeRoomType();
		//this.listOfRooms.add(room);
		
		createRooms(10, new SmallPartyRoom());
		createRooms(2, new MediumPartyRoom());
		createRooms(10, new KaraokeLounge());
		createRooms(5, new AdultBilliardsLounge());
		createRooms(1, new AquaWorldRoom());
		this.setVisible(true);
		
	}
	


	/*
	 * initializes the default center panel and adds it to this frame
	 * */
	private void createDefaultPanel() {
		centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		//Title of default view
		JLabel panelTitle = new JLabel("Party World Rooms");
		panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		Room spr =  new SmallPartyRoom();
		Room mpr =  new MediumPartyRoom();
		AquaWorld aqua = new AquaWorld();
		SmallPartyRoom room = (SmallPartyRoom)spr.makeRoomType();
		MediumPartyRoom room2 = (MediumPartyRoom)mpr.makeRoomType();
		
		//room.setDate(date);
		centerPanel.add(panelTitle);
		addARoomDescription(centerPanel, "C:\\Users\\bobbi\\PartyRoomPics\\smallpartyroom.jpg", "Small Party Room" , room.DESCRIPTION());
		addARoomDescription(centerPanel, "C:\\Users\\bobbi\\PartyRoomPics\\mediumpartyroom.jpg","Medium Party Room", room2.DESCRIPTION());
		addARoomDescription(centerPanel, "C:\\Users\\bobbi\\PartyRoomPics\\aquaworld.jpg", "Aqua Room" , aqua.DESCRIPTION());
		
		scrollPane = new JScrollPane(centerPanel);
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
	/* initializes menu bar items and adds them to this window*/
	private void createMenuBar() {
		menuBar = new JMenuBar();
		//-------
				JMenu menu;
				JMenu submenu;
				JMenuItem menuItem;
				
				//-------  DESCRIPTIONS MENU------------------
				menu = new JMenu("Descriptions");

				//Party Room Sub Menu
				submenu = new JMenu("Party Rooms");

				
				menuItem = new JMenuItem("All");
				menuItem.addActionListener(new RoomItemListener());
				submenu.add(menuItem);

				menuItem = new JMenuItem("Small Party Rooms");
				menuItem.addActionListener(new RoomItemListener());
				submenu.add(menuItem);
				
				menuItem = new JMenuItem("Medium Party Rooms");
				menuItem.addActionListener(new RoomItemListener());
				submenu.add(menuItem);
				
				menuItem = new JMenuItem("Aqua Room");
				menuItem.addActionListener(new RoomItemListener());
				submenu.add(menuItem);
				menu.add(submenu);
				
				//Lounges Sub Menu
				submenu = new JMenu("Lounges");
				
				menuItem = new JMenuItem("All");
				menuItem.addActionListener(new LoungeItemListener());
				submenu.add(menuItem);
				
				menuItem = new JMenuItem("Karaoke Lounges");
				menuItem.addActionListener(new LoungeItemListener());
				submenu.add(menuItem);
				
				menuItem = new JMenuItem("Billiards Lounges");
				menuItem.addActionListener(new LoungeItemListener());
				submenu.add(menuItem);
				
				menu.add(submenu);
				menu.addSeparator();
				
				//Meal Plans Sub Menu
				submenu = new JMenu("Meal Plans");

				menuItem = new JMenuItem("All");
				submenu.add(menuItem);
				menuItem.addActionListener(new MealItemListener());
				
				menuItem = new JMenuItem("Basic");
				submenu.add(menuItem);
				menuItem.addActionListener(new MealItemListener());
				
				menuItem = new JMenuItem("Bronze");
				submenu.add(menuItem);
				menuItem.addActionListener(new MealItemListener());
				
				menuItem = new JMenuItem("Silver");
				submenu.add(menuItem);
				menuItem.addActionListener(new MealItemListener());
				
				menuItem = new JMenuItem("Gold");
				submenu.add(menuItem);
				menuItem.addActionListener(new MealItemListener());
				
				menuItem = new JMenuItem("Platinum");
				submenu.add(menuItem);
				menuItem.addActionListener(new MealItemListener());
				
				menu.add(submenu);
			
			
				
				menuBar.add(menu);
				
				
				//-------  RESERVATIONS MENU------------------
				menu = new JMenu("Reservations");
						
						//New reservation item
						menuItem = new JMenuItem("New Reservation...");
						menuItem.addActionListener(new ReservationListener());
						menu.add(menuItem);
						menu.addSeparator();
						
						//Edit reservation item
						menuItem = new JMenuItem("Edit Existing Reservation...");
						menu.add(menuItem);
						menu.addSeparator();
						
						
						//Manage reservation sub menu 
						submenu = new JMenu("Manage Current Reservation");
						submenu.setMnemonic(KeyEvent.VK_S);

						menuItem = new JMenuItem("Check-in");
						menuItem.addActionListener(new checkInListener());
						submenu.add(menuItem);
						
						menuItem = new JMenuItem("Check-out");
						menuItem.addActionListener(new checkOutListener());
						submenu.add(menuItem);
						

						menu.add(submenu);
				
				
				menuBar.add(menu);
				this.add(menuBar, BorderLayout.NORTH);
	}
	
	
	private void createRooms(int amount, Room room) {
		for(int i = 0; i < amount; i++) {
			Room temp = room.makeRoomType();
			this.listOfRooms.add(temp);
		}
	}
	/* 
	 * adds room image and description to a given container
	 * @param container - the container onto which to add the new description
	 * @param imgDir - the directory of the image
	 * @param roomName - the name of the room
	 * @param roomDesc - the description of the room
	 * 
	 * */
	 private void addARoomDescription(Container container, String imgDir, String roomName, String roomDesc) {
		 	JPanel p = new JPanel();
		 	
		 	ImageIcon icon = new ImageIcon(imgDir);
		 	JLabel picture = new JLabel(roomName, icon, JLabel.CENTER);
		 	picture.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		 	
		 	//Set the position of the text, relative to the icon:
		 	picture.setVerticalTextPosition(JLabel.TOP);
		 	picture.setHorizontalTextPosition(JLabel.CENTER);
		 	//Set border around 
		 	picture.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		 	
		 	p.add(picture);
		 	
	
		 	JTextArea description = new JTextArea(5,10);
		 	description.append(roomDesc);
		 	description.setEditable(false);
		 	description.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		 	description.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			p.add(description);
			
	        JButton bookButton = new JButton("Book Now");
	        bookButton.addActionListener(new BookNowButtonListener(roomName));
	        p.add(bookButton);
	        container.add(p);
	    }

	 private void displayMeal(Container container, String mealType, String mealPlan)
	 {
		 JPanel panel = new JPanel();
		 JTextArea desc = new JTextArea(5, 10);
		 JLabel type = new JLabel(mealType);

		 desc.append(mealPlan);
		 desc.setEditable(false);
		 desc.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		 desc.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));

		 type.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		 type.setFont(new Font(Font.SERIF, Font.BOLD, 20));

		 panel.add(type);
		 panel.add(desc);

		 container.add(panel);
	 }
	 class BookNowButtonListener implements ActionListener {
			/**
			 * @param click continues to ReservationFrame
			 */
		 	String roomName;
		 	public BookNowButtonListener(String room) {
		 		this.roomName = room;
		 	}
			@Override
			public void actionPerformed(ActionEvent click) {
				Component button = (Component) click.getSource();
				JFrame frame = (JFrame) SwingUtilities.getRoot(button);
				DateAndTimeFrame date = new DateAndTimeFrame(listOfRooms, checkInGuests, checkOutGuests);
				date.updateData(this.roomName);
			}
		}
	class MealItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent click) {
			JMenuItem menuItem = (JMenuItem) click.getSource();
			String item = menuItem.getText();
			System.out.println(item);
			centerPanel.removeAll();

			MealPlan basic = new BasicMealPlan();
			MealPlan bronze = new BronzeMealPlan();
			MealPlan silver = new SilverMealPlan();
			MealPlan gold = new GoldMealPlan();
			MealPlan platinum = new PlatinumMealPlan();
			if(item.equals("All")) {
				displayMeal(centerPanel, basic.getType(), basic.getDescription());
				displayMeal(centerPanel, bronze.getType(), bronze.getDescription());
				displayMeal(centerPanel, silver.getType(), silver.getDescription());
				displayMeal(centerPanel, gold.getType(), gold.getDescription());
				displayMeal(centerPanel, platinum.getType(), platinum.getDescription());
			}
			else if(item.equals("Basic")) {
				displayMeal(centerPanel, basic.getType(), basic.getDescription());
			}
			else if(item.equals("Bronze")) {
				displayMeal(centerPanel, bronze.getType(), bronze.getDescription());
			}
			else if(item.equals("Silver")) {
				displayMeal(centerPanel, silver.getType(), silver.getDescription());
			}
			else if(item.equals("Gold")) {
				displayMeal(centerPanel, gold.getType(), gold.getDescription());
			}
			else if(item.equals("Platinum")) {
				displayMeal(centerPanel, platinum.getType(), platinum.getDescription());
			}
			//else if(item.equals("Basic")) System.out.println("VIEW BASIC"); //replace 
			//else if(item.equals("Bronze")) System.out.println("VIEW BRONZE");
			centerPanel.revalidate();
			centerPanel.repaint();
			
		}
		
	}
	

	
	
	class RoomItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent select) {
			JMenuItem item = (JMenuItem) select.getSource();
			centerPanel.removeAll();
			Room spr =  new SmallPartyRoom();
			Room mpr =  new MediumPartyRoom();
			Room kl = new KaraokeLounge();
			Room abl = new AdultBilliardsLounge();
			AquaWorld aqua = new AquaWorld();
			SmallPartyRoom room = (SmallPartyRoom)spr.makeRoomType();
			MediumPartyRoom room2 = (MediumPartyRoom)mpr.makeRoomType();
			KaraokeLounge lounge = (KaraokeLounge)kl.makeRoomType();
			AdultBilliardsLounge lounge2 = (AdultBilliardsLounge)abl.makeRoomType();
			if(item.getText().equals("All")) {
				addARoomDescription(centerPanel, "C:\\Users\\bobbi\\PartyRoomPics\\smallpartyroom.jpg", "Small Party Room" , room.DESCRIPTION());
				addARoomDescription(centerPanel, "C:\\Users\\bobbi\\PartyRoomPics\\mediumpartyroom.jpg", "Medium Party Room" , room2.DESCRIPTION());
				addARoomDescription(centerPanel, "C:\\Users\\bobbi\\PartyRoomPics\\aquaworld.jpg", "Aqua Room" , aqua.DESCRIPTION());
			}
			if(item.getText().equals("Small Party Rooms")) {
				addARoomDescription(centerPanel, "C:\\Users\\bobbi\\PartyRoomPics\\smallpartyroom.jpg", "Small Party Room" , room.DESCRIPTION());
			}
			if(item.getText().equals("Medium Party Rooms")) {
				addARoomDescription(centerPanel, "C:\\Users\\bobbi\\PartyRoomPics\\mediumpartyroom.jpg", "Medium Party Room" , room2.DESCRIPTION());
			}
			if(item.getText().equals("Aqua Room")) {
				addARoomDescription(centerPanel, "C:\\Users\\bobbi\\PartyRoomPics\\aquaworld.jpg", "Aqua Room" , aqua.DESCRIPTION());
			}
			centerPanel.revalidate();
			centerPanel.repaint();
			
		}
	}
	class LoungeItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent select) {
			JMenuItem item = (JMenuItem) select.getSource();
			centerPanel.removeAll();
			Room kl = new KaraokeLounge();
			Room abl = new AdultBilliardsLounge();
			KaraokeLounge lounge = (KaraokeLounge)kl.makeRoomType();
			AdultBilliardsLounge lounge2 = (AdultBilliardsLounge)abl.makeRoomType();
			if(item.getText().equals("All")) {
				addARoomDescription(centerPanel, "C:\\Users\\bobbi\\PartyRoomPics\\karaokelounge.jpg", "Karaoke Lounge" , lounge.DESCRIPTION());
				addARoomDescription(centerPanel, "C:\\Users\\bobbi\\PartyRoomPics\\adultbilliardslounge.jpg", "Adult Billiards Lounge" , lounge2.DESCRIPTION());
			}
			if(item.getText().equals("Karaoke Lounges")) {
				addARoomDescription(centerPanel, "C:\\Users\\bobbi\\PartyRoomPics\\karaokelounge.jpg", "Karaoke Lounge" , lounge.DESCRIPTION());
			}
			if(item.getText().equals("Billiards Lounges")) {
				addARoomDescription(centerPanel, "C:\\Users\\bobbi\\PartyRoomPics\\adultbilliardslounge.jpg", "Adult Billiards Lounge" , lounge2.DESCRIPTION());
			}
			centerPanel.revalidate();
			centerPanel.repaint();
			
		}
	}
	class ReservationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent select) {
			// TODO Auto-generated method stub
			JMenuItem item = (JMenuItem) select.getSource();
			if(item.getText().equals("New Reservation...")) {
				System.out.println("New Reservation...");
				ReservationFrame reservation = new ReservationFrame(listOfRooms, checkInGuests, checkOutGuests);
				reservation.setVisible(true);
			}
		}
		
	}
class checkInListener implements ActionListener {
		
		public void actionPerformed(ActionEvent select) {
			
			JMenuItem item = (JMenuItem) select.getSource();
			
			if(item.getText().equals("Check-in")) {
				
				CheckInFrame checkInFrame = new CheckInFrame(checkInGuests, checkOutGuests);
				checkInFrame.setVisible(true);
			}
		}
	}
    class checkOutListener implements ActionListener {
		
		public void actionPerformed(ActionEvent select) {
			
			JMenuItem item = (JMenuItem) select.getSource();
			
			if(item.getText().equals("Check-out")) {
				
				CheckOutFrame checkOutFrame = new CheckOutFrame(checkOutGuests);
				checkOutFrame.setVisible(true);
			}
		}
	}
	public static void main(String[] args) {
		ArrayList<Guest> checkIn = new ArrayList<Guest>();
		ArrayList<Guest> checkOut = new ArrayList<Guest>();
		MainFrame f = new MainFrame(checkIn, checkOut);
	}
}

