package SystemMain;
import Rooms.*;
public class Guest {
	private String name, phone, email, address;
	private Card card;
	private String contact = "";
	private Room room;
	public Guest() {
		this.name = "NA";
		this.phone = "NA";
		this.email = "NA";
		this.address = "NA";
		this.card = null;
	}
	public Guest(String name, String phone, String email, String address, Card card) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.card = card;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCard(Card card) {
		this.card = card;
	}
	public void contact(String roomAvailabiltity) {
		contact = roomAvailabiltity;
	}
	public Room getRoom() {
		return this.room;
	}
	public String getContact() {
		return this.contact;
	}
	public String getName() {
		return this.name;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getAddress() {
		return this.address;
	}
	public String getEmail() {
		return this.email;
	}
	public Card getCard() {
		return this.card;
	}
	public String toString() {
		String info = "\nName: " + getName();
		info += "\nPhone Number: " + getPhone();
		info += "\nEmail: " + getEmail();
		info += "\nAddress: " + getAddress();
		info += "\nCard: " + getCard().toString();
		
		return info;
	}
}
