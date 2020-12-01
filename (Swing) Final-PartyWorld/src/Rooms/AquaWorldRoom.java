package Rooms;

import java.util.ArrayList;

import MealPlans.BasicMealPlan;
import MealPlans.MealPlan;
import SystemMain.Reservation;

public class AquaWorldRoom extends Room{
	//private Date date;
	private boolean availability;
	private int numberTowels;
	private int numberPartyFavorBags = 0;
	private double projectorHours = 0;
	private boolean partyDecorations;
	private String partyDecorationsTheme;
	private ArrayList<Reservation> waitList = new ArrayList<Reservation>();
	public Room makeRoomType()  {
		setRoomType("Aqua World");
		setNewMealPlan(new BasicMealPlan());
		Room room = null;
		try {
			room = (Room) super.clone();
			
		} catch (CloneNotSupportedException e) {

			e.printStackTrace();
		}
		return room;
	}

	public void setNumberTowels(int towels) {
		numberTowels = towels;
	}
	public int getNumberTowels() {
		
		return numberTowels;
	}
	public void setNumberPartyFavorBags(int bags) {
		
		numberPartyFavorBags = bags;
	}
	public int getNumberPartyFavorBags() {
		
		return numberPartyFavorBags;
	}
	public void setProjectorHours(double hours) {
		
		projectorHours = hours;
	}
	public double getProjectorHours() {
		
		return projectorHours;
	}
	public void setPartyDecorations(boolean decorations) {
		
		partyDecorations = decorations;
	}
	public boolean getPartyDecorations() {
		
		return partyDecorations;
	}
	public void setPartyDecorationsTheme(String theme) {
		
		partyDecorationsTheme = theme;
	}
	public String getPartyDecorationsTheme() {
		
		return partyDecorationsTheme;
	}
	public int getNumberRooms() {
		
		return 1;
	}
	public String getDescription() {
		
		return "Olympic-sized pool with water slide, kiddie pool, and large jacuzzi";
	}
	public int getCapacity() {
		
		return 75;
	}
	public double getCost() {
		
		return 700 * getHours() + getUpgradeCost();
	}
	public String getAmmenities() {
		
		return "access to shower/lockers, life gurards on duty, DJ, table & chair set-up, Basic Meal Plan";
	}
	public String getRestrictions() {
		
		return "To access water facilities, bathing suits must be worn at all times to access water facilities";
	}
	public String getUpgrades() {
		
		String upgrades = "upgrade meal plan for an additional cost 0f $5 X (new meal plan cost - basic meal plan cost";
		upgrades += "\ntowel rentals ($2 each)";
		upgrades += "\nparty favor bag ($5 per bag)";
		upgrades += "\nprojector ($10/hour)";
		upgrades += "\nparty decorations & set-up (+$100)- choose Hawaiian, Sea Life, Jungle, Space, or Modern Theme";
		return upgrades;
	}
	public double getUpgradeCost() {
		
		double upgradesCost = 5 * (getNewMealPlan().getCost() - 65);
		upgradesCost += numberPartyFavorBags * 5;
		upgradesCost += numberTowels * 2;
		upgradesCost += projectorHours * 10;
		
		if (partyDecorations == true) {
			
			upgradesCost += 100;
		}
		return upgradesCost;
	}
	public String DESCRIPTION() {
		String room = "Number of Rooms: " + getNumberRooms();
		room += "\nDescription: " + getDescription();
		room += "\nCapacity: " + getCapacity();
		room += "\nCost: $700/hr";
		room += "\nIncluded in cost: " + getAmmenities();
		room += "\nUpgrades available: " + getUpgrades();
		room += "\nRestrictions: " + getRestrictions();
		return room;
	}
	@Override
	public String getRoom() {
		// TODO Auto-generated method stub
		String room = "\nType: " + super.getType();
		room += "\n " + DESCRIPTION();
		return room;
	}
	/*@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return this.date;
	}*/
	@Override
	public boolean getAvailability() {
		// TODO Auto-generated method stub
		return this.availability;
	}
	@Override
	public void addToWaitList(Reservation guest) {
		// TODO Auto-generated method stub
		this.waitList.add(guest);
	}
	/*@Override
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.date = date;
	}*/
	@Override
	public void setAvailability(boolean availability) {
		// TODO Auto-generated method stub
		this.availability = availability;
		
	}
}
