package Rooms;
import java.util.ArrayList;

import MealPlans.*;
import SystemMain.Reservation;

public class MediumPartyRoom extends Room{
	//private Date date;
	private int numberPartyFavorBags = 0;
	private double projectorHours = 0;
	private boolean partyDecorations;
	private String partyDecorationsTheme;
	private boolean availability = true;
	private ArrayList<Reservation> waitList = new ArrayList<Reservation>();
	
	public Room makeRoomType()  {
		
		setRoomType("Medium Party Room");
		setNewMealPlan(new BasicMealPlan());
		Room room = null;
		try {
			
			room = (Room) super.clone();
			
		} catch (CloneNotSupportedException e) {

			e.printStackTrace();
		}
		return room;
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
		
		return 2;
	}
	public String getDescription() {
		
		return "Room with party tables and chairs, quick access to arcade";
	}
	public int getCapacity() {
		
		return 45;
	}
	public double getCost() {
		
		return 250 * getHours() + getUpgradeCost();
	}
	public String getAmmenities() {
		
		return "Table & chair set-up, DJ, Basic Meal Plan";
	}
	public String getRestrictions() {

		return "none";
	}
	public String getUpgrades() {
		
		String upgrades = "upgrade meal plan for an additional cost 0f $3 X (new meal plan cost - basic meal plan cost";
		upgrades += "\nparty favor bag ($5 per bag)";
		upgrades += "\nprojector ($10/hour)";
		upgrades += "\nparty decorations & set-up (+$100)- choose Hawaiian, Sea Life, Jungle, Space, or Modern Theme";
		return upgrades;
	}
	public double getUpgradeCost() {
		
		double upgradesCost = 3 * (getNewMealPlan().getCost() - 65);
		upgradesCost += numberPartyFavorBags * 5;
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
		room += "\nCost: $250/hr";
		room += "\nIncluded in cost: " + getAmmenities();
		room += "\nUpgrades available: " + getUpgrades();
		return room;
	}
	@Override
	public String getRoom() {
		// TODO Auto-generated method stub
		String room = "\nType: " + super.getType();
		room += "\n " + DESCRIPTION();
		return room;
	}
	/*public void setDate(Date date) {
		this.date = date;
	}
	@Override
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
	@Override
	public void setAvailability(boolean availability) {
		// TODO Auto-generated method stub
		this.availability = availability;
	}

}
