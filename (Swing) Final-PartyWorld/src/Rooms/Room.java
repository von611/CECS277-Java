package Rooms;

import java.util.ArrayList;
import java.util.List;

import SystemMain.Guest;
import SystemMain.Reservation;
import MealPlans.*;
public abstract class Room implements Cloneable{
	private double hoursRented;
	private String type;
	private MealPlan meal;
	private MealPlan upgradedMeal;
	private ArrayList<Reservation> waitList = new ArrayList<Reservation>();
	private boolean availability = true;	
	//private Date date;
	/*public Room(String type) {
		this.waitList = new ArrayList<Reservation>();
		this.type = type;
		this.availability = true;
		//this.date = date;
	}*/
	public void setUpgradedMeal(MealPlan meal) {
		this.upgradedMeal = meal;
	}
	public void setNewMealPlan(MealPlan meal) {
		this.meal = meal;
	}
	public void setRoomType(String type) {
		this.type = type;
	}
	public void setHours(double hoursRented) {
		
		this.hoursRented = hoursRented;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public void addToWaitList(Reservation guest) {
		this.waitList.add(guest);
	}
	
	public void removeToWaitList(Reservation guest) {
		this.waitList.remove(guest);
	}
	public void contactGuest(Guest guest) {
		if(getAvailability() && !this.waitList.isEmpty()) {
			this.waitList.get(0).getGuest().contact("Room is Available");
		}
	}
	public String getType() {
		return this.type;
	}
	
	public MealPlan getNewMealPlan() {
		return this.meal;
	}
	public MealPlan getUpgradeMealPlan() {
		return this.meal;
	}
	public double getHours() {
		
		return this.hoursRented;
	}
	public boolean getAvailability() {
		return this.availability;
	}
	/*public Date getDate() {
		return this.date;
	}*/
	/*public String toString() { 
		return "Type: " + this.type + "-Date: " + this.date;
	}*/
	public abstract String getRoom();
	//public abstract Date getDate();
	public abstract Room makeRoomType();
	public abstract int getNumberRooms();
	public abstract String getDescription();
	public abstract int getCapacity();
	public abstract double getCost();
	public abstract String getAmmenities();
	public abstract String getUpgrades();
	public abstract double getUpgradeCost();
	public abstract String getRestrictions();
}

