package SystemMain;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import Rooms.*;
import MealPlans.*;
import foods.*;
import Sodas.*;

public class ReservationFrame extends JFrame{
	JTextField name, phone, address, DOB, email, companyName, cc, securityCode, expDate;
	JPanel panel;
	JComboBox<String> rooms, upgradeMeal, addMeal;
	ArrayList<Room> listOfRooms;
	ArrayList<Food> foods;
	ArrayList<Pizza> pizzas;
	ArrayList<SodaBottle> sodaBottles;
	JComboBox[] pizzaList, sodaList;
	ArrayList<JComboBox> pp, ss;
	ArrayList<JLabel> toppingLabels, sodaLabels;
	JTextArea area;
	JTextArea desc, descMeal;
	JLabel mealType, newMeal;
	MealPlan meal;
	ArrayList<Reservation> reservations;
	ArrayList<Guest> checkInGuests;
	ArrayList<Guest> checkOutGuests;
	Reservation reserve;
	Room room;
	JSpinner spinnerMonth, spinnerDay, spinnerYear, time1, time2;
	BasicMealPlan basic;
	int pizzaCounter = 0;
	int sodaCounter = 0;
	String[] toppings = {"Cheese", "Pepperoni", "Ham", "Jalapeno", "Sausage", "Mushroom", "Pineapple", "BellPepper", "Onion", "GarlicChicken"};
	String[] sodaFlavors = {"Coca-Cola", "DietCoke", "CanadaDry", "OrangeCrush", "Squirt", "RootBeer"};
	public ReservationFrame(ArrayList<Room> types, ArrayList<Guest> guests, ArrayList<Guest> guests2) {
		this.listOfRooms = types;
		checkInGuests = guests;
		checkOutGuests = guests2;
		this.toppingLabels = new ArrayList<JLabel>();
		this.sodaLabels = new ArrayList<JLabel>();
		this.pp = new ArrayList<JComboBox>();
		this.ss = new ArrayList<JComboBox>();
		this.foods = new ArrayList<Food>();
		this.pizzas = new ArrayList<Pizza>();
		this.sodaBottles = new ArrayList<SodaBottle>();
		this.name = new JTextField(20);
		this.phone = new JTextField(20);
		this.address = new JTextField(20);
		this.DOB = new JTextField(20);
		this.email = new JTextField(20);
		this.companyName = new JTextField(20);
		this.cc = new JTextField(20);
		this.securityCode = new JTextField(20);
		this.expDate = new JTextField(20);
		
		this.reservations = new ArrayList<Reservation>();
		AquaWorldRoom aqua = new AquaWorldRoom();
		this.room = (AquaWorldRoom)aqua.makeRoomType();
		reserve = new Reservation(this.room, new Guest(), new Date());
		this.setTitle("New Reservation");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //makes window screen size
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		createComponents();
		this.setVisible(true);
	}
	
	private void createComponents() {
		this.panel = new JPanel();
		this.panel.setLayout(null);
		JLabel INFOLABEL = new JLabel("~GUEST INFORMATION~");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 25));
		Dimension size = INFOLABEL.getPreferredSize();
		INFOLABEL.setBounds(10, 10, size.width, size.height);
		this.panel.add(INFOLABEL);
		this.name = addInfo("NAME:", 10, 50, name);
		this.panel.add(this.name);
		this.phone = addInfo("PHONE #:", 10, 90, phone);
		this.panel.add(this.phone);
		this.address = addInfo("ADDRESS:", 10, 130, address);
		this.panel.add(this.address);
		this.DOB = addInfo("DOB:", 10, 170, DOB);
		this.panel.add(this.DOB);
		this.email = addInfo("EMAIL:", 10, 210, email);
		this.panel.add(this.email);
		
		INFOLABEL = new JLabel("~CREDIT CARD INFORMATION~");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 25));
		size = INFOLABEL.getPreferredSize();
	 	INFOLABEL.setBounds(1200, 10, size.width, size.height);
		panel.add(INFOLABEL);
		this.companyName = addInfo("COMPANY NAME:", 1200, 50, companyName);
		this.panel.add(this.companyName);
		this.cc = addInfo("CC #:", 1200, 90, cc);
		this.panel.add(this.cc);
		this.securityCode = addInfo("SECURITY CODE:", 1200, 130, securityCode);
		this.panel.add(this.securityCode);
		this.expDate = addInfo("EXP DATE:", 1200, 170, expDate);
		this.panel.add(this.expDate);
		
		INFOLABEL = new JLabel("~ROOM INFORMATION~");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 25));
		size = INFOLABEL.getPreferredSize();
	 	INFOLABEL.setBounds(10, 250, size.width, size.height);
		panel.add(INFOLABEL);
		
		INFOLABEL = new JLabel("SELECT ROOM:");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		size = INFOLABEL.getPreferredSize();
	 	INFOLABEL.setBounds(10, 290, size.width, size.height);
	 	panel.add(INFOLABEL);
	 	
	 	String[] type = {"Aqua World", "Small Party Rooms", "Medium Party Rooms", "Adult Billiards Lounge", "Karaoke Lounge"};
	 	this.rooms = new JComboBox<String>(type);
	 	this.rooms.setBounds(150, 290, 200, 20);
	 	this.rooms.addActionListener(new RoomListener());
	 	panel.add(this.rooms);
	 	
	 	
		INFOLABEL = new JLabel("MONTH:");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		size = INFOLABEL.getPreferredSize();
	 	INFOLABEL.setBounds(10, 330, size.width, size.height);
	 	panel.add(INFOLABEL);
	 	//SpinnerListModel monthModel = new SpinnerListModel(month);
	 	SpinnerModel monthModel = new SpinnerNumberModel(1, 1, 12, 1);
	 	spinnerMonth = new JSpinner(monthModel);
	 	spinnerMonth.setBounds(150, 330, 150, 20);
	 	panel.add(spinnerMonth);
	 	
		INFOLABEL = new JLabel("DAY:");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		size = INFOLABEL.getPreferredSize();
	 	INFOLABEL.setBounds(10, 370, size.width, size.height);
	 	panel.add(INFOLABEL);
	 	SpinnerModel dayModel = new SpinnerNumberModel(1, 1, 31, 1);
	 	spinnerDay = new JSpinner(dayModel);
	 	spinnerDay.setBounds(150, 370, 150, 20);
	 	panel.add(spinnerDay);
	 	
	 	INFOLABEL = new JLabel("YEAR:");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		size = INFOLABEL.getPreferredSize();
	 	INFOLABEL.setBounds(10, 410, size.width, size.height);
	 	panel.add(INFOLABEL);
	 	SpinnerModel yearModel = new SpinnerNumberModel(2019, 2019, 2022, 1);
	 	spinnerYear = new JSpinner(yearModel);
	 	spinnerYear.setBounds(150, 410, 150, 20);
	 	panel.add(spinnerYear);
	 	
	 	INFOLABEL = new JLabel("TIME:");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		size = INFOLABEL.getPreferredSize();
	 	INFOLABEL.setBounds(10, 450, size.width, size.height);
	 	panel.add(INFOLABEL);
	 	SpinnerModel timeModel = new SpinnerNumberModel(9, 1, 12, 1);
	 	time1 = new JSpinner(timeModel);
	 	time1.setBounds(10, 470, 50, 20);
	 	panel.add(time1);
	 	
	 	SpinnerModel timeModel2 = new SpinnerNumberModel(12, 1, 12, 1);
	 	time2 = new JSpinner(timeModel2);
	 	time2.setBounds(70, 470, 50, 20);
	 	panel.add(time2);
	 	
	 	INFOLABEL = new JLabel("~MEAL PLAN INFORMATION~");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 25));
		size = INFOLABEL.getPreferredSize();
	 	INFOLABEL.setBounds(1200, 250, size.width, size.height);
		panel.add(INFOLABEL);
	 	this.descMeal = new JTextArea(5, 10);
	 	panel.add(descMeal);
	 	mealType = new JLabel();
	 	panel.add(mealType);
	 	
		meal = new BasicMealPlan();
		displayMeal(meal.getType(), meal.getDescription());

	 	panel.add(INFOLABEL);
	 	addFood(1200, 500, toppings, "TOPPING:", 3, 1);
	 	
		//INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		//size = INFOLABEL.getPreferredSize();
		int y = 500 + 3 * 25;
	 	//INFOLABEL.setBounds(1200, y, size.width, size.height);
	 	//panel.add(INFOLABEL);
	 	addFood(1200, y, sodaFlavors, "SODA:", 3, 1);
	 	/*for(int i = 0; i < 3; i++) {
	 		addTopping(1340, y, sodaFlavors);
	 		y += 25;
	 	}*/
	 	for(JLabel t : this.toppingLabels) {
	 		panel.add(t);
	 	}
	 	for(JLabel s : this.sodaLabels) {
	 		panel.add(s);
	 	}
	 	for(JComboBox c : this.pp) {
	 		panel.add(c);
	 	}
	 	for(JComboBox s : this.ss) {
	 		panel.add(s);
	 	}
	 	INFOLABEL = new JLabel("~UPRGRADE MEAL PLAN~");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		size = INFOLABEL.getPreferredSize();
	 	INFOLABEL.setBounds(1600, 250, size.width, size.height);
		panel.add(INFOLABEL);
		
	 	String[] meals = {"None", "BasicMealPlan", "BronzeMealPlan", "SilverMealPlan", "GoldMealPlan", "PlatinumMealPlan"};
	 	this.upgradeMeal = new JComboBox<String>(meals);
	 	this.upgradeMeal.setBounds(1600, 300, 200, 20);
	 	this.upgradeMeal.addActionListener(new MealPlanListener());
	 	panel.add(this.upgradeMeal);
	 	
		desc = new JTextArea(5, 10);
		panel.add(desc);
	 	JButton save = new JButton("Save");
		size = save.getPreferredSize();
	 	save.setBounds(10, 500, size.width, size.height);
	 	save.addActionListener(new SaveListener());
	 	panel.add(save);
	 	
		newMeal = new JLabel();
	 	panel.add(newMeal);
	 	this.addMeal = new JComboBox<String>(meals);
	 	panel.add(addMeal);
	 	
		this.add(panel);
	}
	private void addFood(int position_X, int position_Y, String[] foodType, String type, int foodAmount, int flavorAmount) {
		int y = position_Y;
		for(int i = 0; i < foodAmount; i++) {
			/*if(type.equalsIgnoreCase("PIZZA")) {
				Food food = new GourmetPizza();
				meal.addMeals(food);
			}*/
			int x = position_X;
			JLabel INFOLABEL = new JLabel(type);
			INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 15));
			Dimension size = INFOLABEL.getPreferredSize();
		 	INFOLABEL.setBounds(x, y, size.width, size.height); //1200, 500
		 	if(type.equalsIgnoreCase("TOPPING:")) {
			 	this.toppingLabels.add(INFOLABEL);
		 	}
		 	if(type.equalsIgnoreCase("SODA:")) {
			 	this.sodaLabels.add(INFOLABEL);
		 	}
		 	//panel.add(INFOLABEL);
		 	x += 140;
		 	for(int j = 0; j < flavorAmount; j++) {
		 		JComboBox food = new JComboBox<String>(foodType);
			 	food.setBounds(x, y, 200, 20);
			 	y += 25;
			 	if(type.equalsIgnoreCase("TOPPING:")) {
				 	food.addActionListener(new PizzaListener());
				 	this.pp.add(food);
			 	}
			 	if(type.equalsIgnoreCase("SODA:")) {
				 	food.addActionListener(new SodaListener());
				 	this.ss.add(food);
			 	}
			 	//food.addActionListener(new FoodListener());
			 	//panel.add(food);
		 	}
		}
		/*JLabel INFOLABEL = new JLabel("SELECT TOPPING:");
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		Dimension size = INFOLABEL.getPreferredSize();
	 	INFOLABEL.setBounds(1200, 500, size.width, size.height);
	 	
	 	food = new JComboBox<String>(foodType);
	 	food.setBounds(position_X, position_Y, 200, 20);
	 	food.addActionListener(new FoodListener());
	 	panel.add(food);*/
	}
	private void displayMeal(String type, String mealPlan)
	 {
		 descMeal = new JTextArea(5, 10);
		 mealType = new JLabel(type);

		 descMeal.append(mealPlan);
		 descMeal.setEditable(false);
		 descMeal.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		 Dimension size = descMeal.getPreferredSize();
		 descMeal.setBounds(1200, 340, size.width, size.height);
			 
		 mealType.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		 size = mealType.getPreferredSize();
		 mealType.setBounds(1200, 300, size.width, size.height);
		 panel.add(mealType);
		 panel.add(descMeal);
	 }
	private JTextField addInfo(String label, int position_X, int position_Y, JTextField text) {
		
		JLabel INFOLABEL = new JLabel(label);
		INFOLABEL.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		Dimension size = INFOLABEL.getPreferredSize();
		INFOLABEL.setBounds(position_X, position_Y, size.width, size.height);
		this.panel.add(INFOLABEL);
		
		text = new JTextField(20);
		text.setBounds(position_X + 140, position_Y, 200, 20);
		return text;
	}
	class MealPlanListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Component select = (Component) e.getSource();
			String selectedItem = (String)upgradeMeal.getSelectedItem();
			MealPlan temp = null;
			panel.remove(desc);
			if(selectedItem.equalsIgnoreCase("BasicMealPlan"))  {
				temp = new BasicMealPlan();
				room.setUpgradedMeal(temp);
			}
			if(selectedItem.equalsIgnoreCase("BronzeMealPlan"))  {
				temp = new BronzeMealPlan();
				room.setUpgradedMeal(temp);
			}
			if(selectedItem.equalsIgnoreCase("SilverMealPlan"))  {
				temp = new SilverMealPlan();
				room.setUpgradedMeal(temp);
			}
			if(selectedItem.equalsIgnoreCase("GoldMealPlan"))  {
				temp = new GoldMealPlan();
				room.setUpgradedMeal(temp);
			}
			if(selectedItem.equalsIgnoreCase("PlatinumMealPlan"))  {
				temp = new PlatinumMealPlan();
				room.setUpgradedMeal(temp);
			}
			desc = new JTextArea(5, 10);
			desc.append(temp.getDescription());
			desc.setEditable(false);
			desc.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
			Dimension size = desc.getPreferredSize();
			desc.setBounds(1600, 340, size.width, size.height);
			panel.add(desc);
			panel.revalidate();
			panel.repaint();
		}
		
	}
	class AddMealListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Component select = (Component) e.getSource();
			String selectedItem = (String)addMeal.getSelectedItem();
			panel.remove(descMeal);
			panel.remove(mealType);
			for(JLabel t : toppingLabels) {
		 		panel.remove(t);
		 	}
		 	for(JLabel s : sodaLabels) {
		 		panel.remove(s);
		 	}
		 	for(JComboBox c : pp) {
		 		panel.remove(c);
		 	}
		 	for(JComboBox s : ss) {
		 		panel.remove(s);
		 	}
			toppingLabels.clear();
		 	sodaLabels.clear();
		 	pp.clear();
		 	ss.clear();
			if(selectedItem.equalsIgnoreCase("BasicMealPlan"))  {
				meal = new BasicMealPlan();
				displayMeal(meal.getType(), meal.getDescription());
			}
			if(selectedItem.equalsIgnoreCase("BronzeMealPlan"))  {
				int y = 500 + 6 * 25;
				meal = new BronzeMealPlan();
				displayMeal(meal.getType(), meal.getDescription());
			 	addFood(1200, 500, toppings, "TOPPING:", 3, 2);
			 	addFood(1200, y, sodaFlavors, "SODA:", 5, 1);
			}
			if(selectedItem.equalsIgnoreCase("SilverMealPlan"))  {
				int y = 500 + 9 * 25;
				meal = new SilverMealPlan();
				displayMeal(meal.getType(), meal.getDescription());
				addFood(1200, 500, toppings, "TOPPING:", 3, 3);
			 	addFood(1200, y, sodaFlavors, "SODA:", 5, 1);
			}
			if(selectedItem.equalsIgnoreCase("GoldMealPlan"))  {
				int y = 500 + 9 * 25;
				meal = new GoldMealPlan();
				displayMeal(meal.getType(), meal.getDescription());
				addFood(1200, 500, toppings, "TOPPING:", 3, 3);
			 	addFood(1200, y, sodaFlavors, "SODA:", 5, 1);
			}
			if(selectedItem.equalsIgnoreCase("PlatinumMealPlan"))  {
				int y = 500 + 16 * 25;
				meal = new PlatinumMealPlan();
				displayMeal(meal.getType(), meal.getDescription());
				addFood(1200, 500, toppings, "TOPPING:", 4, 4);
			 	addFood(1200, y, sodaFlavors, "SODA:", 5, 1);
			}
			for(JLabel t : toppingLabels) {
		 		panel.add(t);
		 	}
		 	for(JLabel s : sodaLabels) {
		 		panel.add(s);
		 	}
		 	for(JComboBox c : pp) {
		 		panel.add(c);
		 	}
		 	for(JComboBox s : ss) {
		 		panel.add(s);
		 	}
			panel.revalidate();
			panel.repaint();
		}
		
	}
	
	class RoomListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Component select = (Component) e.getSource();
			String selectedItem = (String)rooms.getSelectedItem();
			String[] list = new String[listOfRooms.size()];
			panel.remove(addMeal);
			panel.remove(newMeal);
			panel.remove(desc);
			panel.remove(descMeal);
			panel.remove(mealType);
			panel.remove(upgradeMeal);
			int counter = 0;
			String[] meals = {"None", "BasicMealPlan", "BronzeMealPlan", "SilverMealPlan", "GoldMealPlan", "PlatinumMealPlan"};
			for(JLabel t : toppingLabels) {
		 		panel.remove(t);
		 	}
		 	for(JLabel s : sodaLabels) {
		 		panel.remove(s);
		 	}
		 	for(JComboBox c : pp) {
		 		panel.remove(c);
		 	}
		 	for(JComboBox s : ss) {
		 		panel.remove(s);
		 	}
			if(selectedItem.equals("Small Party Rooms")) {
				int y = 500 + 3 * 25;
				basic = new BasicMealPlan();
				displayMeal(basic.getType(), basic.getDescription());
				SmallPartyRoom spr = new SmallPartyRoom();
				room = (SmallPartyRoom)spr.makeRoomType();
				upgradeMeal = new JComboBox<String>(meals);
			 	upgradeMeal.setBounds(1600, 300, 200, 20);
			 	upgradeMeal.addActionListener(new MealPlanListener());
			 	for(JLabel t : toppingLabels) {
			 		panel.add(t);
			 	}
			 	for(JLabel s : sodaLabels) {
			 		panel.add(s);
			 	}
			 	for(JComboBox c : pp) {
			 		panel.add(c);
			 	}
			 	for(JComboBox s : ss) {
			 		panel.add(s);
			 	}
			 	panel.add(upgradeMeal);
			}
			if(selectedItem.equals("Medium Party Rooms")) {
				int y = 500 + 3 * 25;
				basic = new BasicMealPlan();
				displayMeal(basic.getType(), basic.getDescription());
				MediumPartyRoom mpr = new MediumPartyRoom();
				room = (MediumPartyRoom)mpr.makeRoomType();
				upgradeMeal = new JComboBox<String>(meals);
			 	upgradeMeal.setBounds(1600, 300, 200, 20);
			 	upgradeMeal.addActionListener(new MealPlanListener());
			 	for(JLabel t : toppingLabels) {
			 		panel.add(t);
			 	}
			 	for(JLabel s : sodaLabels) {
			 		panel.add(s);
			 	}
			 	for(JComboBox c : pp) {
			 		panel.add(c);
			 	}
			 	for(JComboBox s : ss) {
			 		panel.add(s);
			 	}
			 	panel.add(upgradeMeal);
			}
			if(selectedItem.equals("Karaoke Lounge")) {
				KaraokeLounge karaoke = new KaraokeLounge();
				room = (KaraokeLounge)karaoke.makeRoomType();
				newMeal = new JLabel("ADD MEAL PLAN");
				Dimension size = newMeal.getPreferredSize();
				newMeal.setBounds(360, 290, size.width, size.height);
				
			 	addMeal = new JComboBox<String>(meals);
			 	size = addMeal.getPreferredSize();
			 	addMeal.setBounds(470, 290, size.width, size.height);
			 	addMeal.addActionListener(new AddMealListener());
			 	for(JComboBox p : pp) {
			 		panel.remove(p);
			 	}
			 	for(JComboBox s : ss) {
			 		panel.remove(s);
			 	}
			 	toppingLabels.clear();
			 	sodaLabels.clear();
			 	pp.clear();
			 	ss.clear();
			 	panel.add(addMeal);
				panel.add(newMeal);
			}
			if(selectedItem.equals("Adult Billiards Lounge")) {
				AdultBilliardsLounge adl = new AdultBilliardsLounge();
				room = (AdultBilliardsLounge)adl.makeRoomType();
				
				newMeal = new JLabel("ADD MEAL PLAN");
				Dimension size = newMeal.getPreferredSize();
				newMeal.setBounds(360, 290, size.width, size.height);
			 	addMeal = new JComboBox<String>(meals);
			 	
			 	size = addMeal.getPreferredSize();
			 	addMeal.setBounds(470, 290, size.width, size.height);
			 	addMeal.addActionListener(new AddMealListener());
			 	for(JComboBox p : pp) {
			 		panel.remove(p);
			 	}
			 	for(JComboBox s : ss) {
			 		panel.remove(s);
			 	}
			 	toppingLabels.clear();
			 	sodaLabels.clear();
			 	pp.clear();
			 	ss.clear();
			 	panel.add(addMeal);
				panel.add(newMeal);
			}
			if(selectedItem.equals("Aqua World")) {
				int y = 500 + 3 * 25;
				basic = new BasicMealPlan();
				displayMeal(basic.getType(), basic.getDescription());
				AquaWorldRoom aqua = new AquaWorldRoom();
				room = (AquaWorldRoom)aqua.makeRoomType();
				upgradeMeal = new JComboBox<String>(meals);
			 	upgradeMeal.setBounds(1600, 300, 200, 20);
			 	upgradeMeal.addActionListener(new MealPlanListener());
			 	for(JLabel t : toppingLabels) {
			 		panel.add(t);
			 	}
			 	for(JLabel s : sodaLabels) {
			 		panel.add(s);
			 	}
			 	for(JComboBox c : pp) {
			 		panel.add(c);
			 	}
			 	for(JComboBox s : ss) {
			 		panel.add(s);
			 	}
			 	panel.add(upgradeMeal);
				
			}
			panel.revalidate();
			panel.repaint();
		}
	}
	class PizzaListener implements ActionListener {
		private Pizza p;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JComboBox select = (JComboBox) e.getSource();
			String selectedItem = (String)select.getSelectedItem();
			if(selectedItem.equalsIgnoreCase("Cheese")) {
				Pizza pizza = new GourmetPizza();
				pizza = new Cheese(pizza);
				pizzas.remove(p);
				pizzas.add(pizza);
				this.p = pizza;
				//foods.remove(this.holder);
				//foods.add(food);
				//this.holder = food;
				//meal.addPizzas(pizza);
			}
			if(selectedItem.equalsIgnoreCase("Pepperoni")) {
				Pizza pizza = new GourmetPizza();
				pizza = new Pepperoni(pizza);
				pizzas.remove(p);
				pizzas.add(pizza);
				this.p = pizza;
				//foods.remove(this.holder);
				//foods.add(food);
				//this.holder = food;
				//meal.addPizzas(pizza);
			}
			if(selectedItem.equalsIgnoreCase("Ham")) {
				Pizza pizza = new GourmetPizza();
				pizza = new Ham(pizza);
				pizzas.remove(p);
				pizzas.add(pizza);
				this.p = pizza;
				//foods.remove(this.holder);
				//foods.add(food);
				//this.holder = food;
				//meal.addPizzas(pizza);
			}
			if(selectedItem.equalsIgnoreCase("Jalapeno")) {
				Pizza pizza = new GourmetPizza();
				pizza = new Jalapeno(pizza);
				pizzas.remove(p);
				pizzas.add(pizza);
				this.p = pizza;
				//foods.remove(this.holder);
				//foods.add(food);
				//this.holder = food;
				//meal.addPizzas(pizza);
			}
			if(selectedItem.equalsIgnoreCase("Sausage")) {
				Pizza pizza = new GourmetPizza();
				pizza = new Sausage(pizza);
				pizzas.remove(p);
				pizzas.add(pizza);
				this.p = pizza;
				//foods.remove(this.holder);
				//foods.add(food);
				//this.holder = food;
				//meal.addPizzas(pizza);
			}
			if(selectedItem.equalsIgnoreCase("Mushroom")) {
				Pizza pizza = new GourmetPizza();
				pizza = new Mushroom(pizza);
				pizzas.remove(p);
				pizzas.add(pizza);
				this.p = pizza;
				//foods.remove(this.holder);
				//foods.add(food);
				//this.holder = food;
				//meal.addPizzas(pizza);
			}
			if(selectedItem.equalsIgnoreCase("Pineapple")) {
				Pizza pizza = new GourmetPizza();
				pizza = new Pineapple(pizza);
				pizzas.remove(p);
				pizzas.add(pizza);
				this.p = pizza;
				//foods.remove(this.holder);
				//foods.add(food);
				//this.holder = food;
				//meal.addPizzas(pizza);
			}
			if(selectedItem.equalsIgnoreCase("BellPepper")) {
				Pizza pizza = new GourmetPizza();
				pizza = new BellPepper(pizza);
				pizzas.remove(p);
				pizzas.add(pizza);
				this.p = pizza;
				//foods.remove(this.holder);
				//foods.add(food);
				//this.holder = food;
				//meal.addPizzas(pizza);
			}
			if(selectedItem.equalsIgnoreCase("Onion")) {
				Pizza pizza = new GourmetPizza();
				pizza = new Onion(pizza);
				pizzas.remove(p);
				pizzas.add(pizza);
				this.p = pizza;
				//foods.remove(this.holder);
				//foods.add(food);
				//this.holder = food;
				//meal.addPizzas(pizza);
			}
			if(selectedItem.equalsIgnoreCase("GarlicChicken")) {
				Pizza pizza = new GourmetPizza();
				pizza = new GarlicChicken(pizza);
				pizzas.remove(p);
				pizzas.add(pizza);
				this.p = pizza;
				//foods.remove(this.holder);
				//foods.add(food);
				//this.holder = food;
				//meal.addPizzas(pizza);
			}
			System.out.println(selectedItem);
		}
	}
	class SodaListener implements ActionListener {
		private SodaBottle soda = null;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JComboBox select = (JComboBox) e.getSource();
			String selectedItem = (String)select.getSelectedItem();
			if(selectedItem.equalsIgnoreCase("Coca-Cola")) {
				SodaBottle sodas = new CocaCola();
				//sodaBottles.remove(soda);
				sodaBottles.add(sodas);
				this.soda = sodas;
				//meal.addSodas(sodas);
			}
			if(selectedItem.equalsIgnoreCase("DietCoke")) {
				SodaBottle sodas = new DietCoke();
				sodaBottles.remove(soda);
				sodaBottles.add(sodas);
				this.soda = sodas;
				//meal.addSodas(sodas);
			}
			if(selectedItem.equalsIgnoreCase("CanadaDry")) {
				SodaBottle sodas = new CanadaDry();
				//sodaBottles.remove(soda);
				sodaBottles.add(sodas);
				this.soda = sodas;
				//meal.addSodas(sodas);
			}
			if(selectedItem.equalsIgnoreCase("OrangeCrush")) {
				SodaBottle sodas = new OrangeCrush();
				//sodaBottles.remove(soda);
				sodaBottles.add(sodas);
				this.soda = sodas;
				//meal.addSodas(sodas);
			}
			if(selectedItem.equalsIgnoreCase("Squirt")) {
				SodaBottle sodas = new Squirt();
				//sodaBottles.remove(soda);
				sodaBottles.add(sodas);
				this.soda = sodas;
				//meal.addSodas(sodas);
			}
			if(selectedItem.equalsIgnoreCase("RootBeer")) {
				SodaBottle sodas = new RootBeer();
				//sodaBottles.remove(soda);
				sodaBottles.add(sodas);
				this.soda = sodas;
				//meal.addSodas(sodas);
			}
			System.out.println(selectedItem);
		}
	}
	class SaveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent click) {
			// TODO Auto-generated method stub
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			Guest guest = new Guest();
			guest.setName(name.getText().toString());
			guest.setAddress(address.getText().toString());
			guest.setEmail(email.getText().toString());
			guest.setPhone(phone.getText().toString());
			Card card = new Card(companyName.getText().toString(), cc.getText().toString(), securityCode.getText().toString(), expDate.getText().toString());
			guest.setCard(card);
			checkInGuests.add(guest);
			int m = (Integer)spinnerMonth.getValue();
			int d = (Integer)spinnerDay.getValue();
			int y = (Integer)spinnerYear.getValue();
			Date date = new Date(m, d, y);
			int start = (Integer)time1.getValue();
			int end = (Integer)time2.getValue();
			int time = 1;
			int i = start;
			while(true) {
				i++;
				if(i > 12) {
					i = 1;
				}
				if(i == end) {
					break;
				}
				time += 1;
			}
			MealPlan temp = new BasicMealPlan();
			for(Food food : foods) {
				System.out.println(food.getFlavor());
			}
			if(meal.getType().equalsIgnoreCase("BasicMealPlan")) {
				BasicMealPlan basic = new BasicMealPlan();
				basic.addPizza1(pizzas.get(0));
				basic.addPizza2(pizzas.get(1));
				basic.addPizza3(pizzas.get(2));
				basic.setSoda1(sodaBottles.get(0));
				basic.setSoda2(sodaBottles.get(1));
				basic.setSoda3(sodaBottles.get(2));
				room.setNewMealPlan(basic);
				//temp = basic;
				System.out.println("RAN");
				//System.out.println(temp.getMealPlan());
			}
			if(meal.getType().equalsIgnoreCase("BronzeMealPlan")) {
				BronzeMealPlan bronze = new BronzeMealPlan();
				bronze.addPizza1(pizzas.get(0));
				bronze.addPizza1(pizzas.get(1));
				bronze.addPizza2(pizzas.get(1));
				bronze.addPizza2(pizzas.get(2));
				bronze.addPizza2(pizzas.get(3));
				bronze.addPizza2(pizzas.get(4));
				bronze.setSoda1(sodaBottles.get(0));
				bronze.setSoda2(sodaBottles.get(1));
				bronze.setSoda3(sodaBottles.get(2));
				room.setNewMealPlan(bronze);
				System.out.println("RAN");
				//System.out.println(temp.getMealPlan());
			}
			/*if(meal.getType().equalsIgnoreCase("BronzeMealPlan")) {
				BasicMealPlan basic = new BasicMealPlan();
				basic.addPizza1(1);
				basic.addPizza2(1);
				basic.addPizza3(3);
			}*/
			//room.setNewMealPlan(temp);
			room.setHours(time);
			Reservation reserve = new Reservation(room, guest, date);
			reservations.add(reserve);
			FinalFrame finalize = new FinalFrame(reserve);
			setVisible(false);
			MainFrame f = new MainFrame(checkInGuests, checkOutGuests);
			f.setVisible(true);
		
		}
		
	}
}
