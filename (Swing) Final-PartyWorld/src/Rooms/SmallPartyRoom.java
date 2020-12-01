package Rooms;
import java.util.ArrayList;
import java.util.List;

import MealPlans.*;
import SystemMain.Reservation;
public class SmallPartyRoom extends Room{
	//private Date date;
	private int numberPartyFavorBags = 0;
	private double projectorHours = 0;
	private boolean partyDecorations;
	private String partyDecorationsTheme;
	@Override
	public Room makeRoomType() {
		// TODO Auto-generated method stub
		setRoomType("Small Party Room");
		setNewMealPlan(new BasicMealPlan());
		Room room = null;
		try {
			
			room = (Room)super.clone();
			
		} catch (CloneNotSupportedException e) {

			e.printStackTrace();
		}
		return room;
	}
	
	/*public void setDate(Date date) {
		this.date = date;
	}*/
	
	public void setNumberPartyFavorBags(int bags) {
		
		this.numberPartyFavorBags = bags;
	}
	public int getNumberPartyFavorBags() {
		
		return this.numberPartyFavorBags;
	}
	public void setProjectorHours(double hours) {
		
		this.projectorHours = hours;
	}
	public double getProjectorHours() {
		
		return this.projectorHours;
	}
	public void setPartyDecorations(boolean decorations) {
		
		this.partyDecorations = decorations;
	}
	public boolean getPartyDecorations() {
		
		return this.partyDecorations;
	}
	public void setPartyDecorationsTheme(String theme) {
		
		this.partyDecorationsTheme = theme;
	}
	public String getPartyDecorationsTheme() {
		
		return this.partyDecorationsTheme;
	}
	public String DESCRIPTION() {
		String room = "Number of Rooms: " + getNumberRooms();
		room += "\nDescription: " + getDescription();
		room += "\nCapacity: " + getCapacity();
		room += "\nCost: $150/hr";
		room += "\nIncluded in cost: " + getAmmenities();
		room += "\nUpgrades available: ";
		room += "\nupgrade meal plan for an additional cost 0f $(new meal plan cost - basic meal plan cost";
		room += "\nparty favor bag ($5 per bag)";
		room += "\nprojector ($10/hour)";
		room += "\nparty decorations & set-up (+$100)- choose Hawaiian, Sea Life, Jungle, Space, or Modern Theme";
		return room;
	}
	@Override
	public String getRoom() {
		// TODO Auto-generated method stub
		String room = "\nType: " + super.getType();
		room += "\nDescription: " + getDescription();
		room += "\nCapacity: " + getCapacity();
		room += "\nCost: $150/hr: " + 150*super.getHours();
		room += "\nIncluded in cost: " + getAmmenities();
		room += "\nUpgrades available: " + getUpgrades();
		room += "\nTotal cost: " + getCost();
		return room;
	}
	
	/*@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return this.date;
	}*/
	
	@Override
	public int getNumberRooms() {
		// TODO Auto-generated method stub
		return 10;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Room with party tables and chairs, adjacent to arcade";
	}
	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return 30;
	}
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 150 * super.getHours() + getUpgradeCost();
	}
	@Override
	public String getAmmenities() {
		// TODO Auto-generated method stub
		return "Table & chair set-up, Basic Meal Plan";
	}
	@Override
	public String getUpgrades() {
		// TODO Auto-generated method stub
		String upgrades = "\nParty favor bag: " + getNumberPartyFavorBags();
		upgrades += "\nProjector Hours" + getProjectorHours();
		upgrades += "\nParty decoration: " + getPartyDecorationsTheme();
		return upgrades;
	}
	@Override
	public double getUpgradeCost() {
		// TODO Auto-generated method stub
		double upgradesCost = getUpgradeMealPlan().getCost() - 65;
		upgradesCost += numberPartyFavorBags * 5;
		upgradesCost += projectorHours * 10;
		
		if (partyDecorations == true) {
			
			upgradesCost += 100;
		}
		return upgradesCost;
	}
	@Override
	public String getRestrictions() {
		// TODO Auto-generated method stub
		return "none";
	}
}