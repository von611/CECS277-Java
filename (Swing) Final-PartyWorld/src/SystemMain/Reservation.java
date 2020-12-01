package SystemMain;
import Rooms.*;
public class Reservation {
	private Room room;
	private Guest guest;
	private Date date;
	private String confNum;
	public Reservation(Room room, Guest guest, Date date) {
		this.room = room;
		this.guest = guest;
		this.date = date;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setConfNum(String confNum) {
		this.confNum = confNum;
	}
	public Room getRoom() {
		return this.room;
	}
	
	public Guest getGuest() {
		return this.guest;
	}
	public Date getDate() {
		return this.date;
	}
	public String getConfNum() {
		return this.confNum;
	}
	public String toString() {
		String reserve = "Guest Info: " + this.guest.toString();
		reserve += "\nDate Info: " + this.date.toString();
		reserve += "\nRoom Info " + this.room.getRoom();
		reserve += "\nMeal Plan Info: " + this.room.getNewMealPlan().getMealPlan();
		return reserve;
	}
}
