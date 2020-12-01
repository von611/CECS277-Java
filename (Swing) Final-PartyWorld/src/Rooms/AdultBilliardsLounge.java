package Rooms;

import java.util.ArrayList;

import SystemMain.Reservation;

public class AdultBilliardsLounge extends Room {
	//private Date date;
	private boolean availabilty;
	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	public Room makeRoomType()  {
		setRoomType("Adult Billiards Lounge");
		Room room = null;
		try {
			
			room = (Room) super.clone();
			
		} catch (CloneNotSupportedException e) {

			e.printStackTrace();
		}
		return room;
	}
	public int getNumberRooms() {
		
		return 5;
	}
	public String getDescription() {
		
		return "Enclosed lounge with pool table";
	}
	public int getCapacity() {
		
		return 10;
	}
	public double getCost() {
		
		return 25 * getHours() + getUpgradeCost();
	}
	public String getAmmenities() {
		
		return "access to pool tables and cues";
	}
	public String getRestrictions() {

		return "21+ only";
	}
	public String getUpgrades() {
		
		String upgrades = "add a meal plan";
		return upgrades;
	}
	public double getUpgradeCost() {
		
		double upgradesCost = getNewMealPlan().getCost();
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
		return this.availabilty;
	}
	@Override
	public void addToWaitList(Reservation guest) {
		// TODO Auto-generated method stub
		this.reservations.add(guest);
	}
	/*@Override
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.date = date;
	}*/
	@Override
	public void setAvailability(boolean availability) {
		// TODO Auto-generated method stub
		this.availabilty = availability;
	}

}

