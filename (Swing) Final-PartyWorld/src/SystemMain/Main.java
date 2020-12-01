package SystemMain;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import Rooms.*;
import foods.*;
public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to The Party World!");
		Scanner reader = new Scanner(System.in);
		List<Reservation> reservations = new ArrayList<Reservation>();
		List<Room> rooms = new ArrayList<Room>();
		Room spr = new SmallPartyRoom(); 
		for(int i = 0; i < 6; i++) {
			Random random = new Random();
			int m = random.nextInt(1) + 5;
			int d = random.nextInt(9) + 7;
			Date date = new Date(m, d, 2019);
			SmallPartyRoom room = (SmallPartyRoom)spr.makeRoomType();
			rooms.add(room);
		}
		while(true) {
			System.out.println("Choose how to view available rooms");
			System.out.println("1) View by type");
			System.out.println("2) View by date");
			String key = "";
			key = reader.nextLine();
			if(key.equalsIgnoreCase("1")) {
				reservations.add(viewByType(rooms));
			}
			if(key.equalsIgnoreCase("2")) {
				//viewByDate(rooms);
			}
		}
		
	}
	public static Reservation viewByType(List<Room> rooms) {
		Scanner reader = new Scanner(System.in);
		List<Room> tempRooms = new ArrayList<Room>();
		System.out.println("Choose which type of rooms to view");
		System.out.println("1.Aqua World");
		System.out.println("2.SmallPartyRoom");
		System.out.println("3.Medium Party Room");
		System.out.println("4.Karaoke Lounge");
		System.out.println("5.Adult Billiards Room");
		System.out.println("2.SmallPartyRoom");
		String key = "";
		key = reader.nextLine();
		String type = "";
		if(key == "2") {
			type = "SmallPartyRoom";
		}
		int counter = 0;
		for(Room room : rooms) {
			if(room.getType().contains(type)) {
				System.out.println((counter++) + ". "+ room.getRoom());
				tempRooms.add(room);
			}
		}
		System.out.println("Pick a room");
		int roomNumber = 0;
		roomNumber -= Integer.parseInt(reader.nextLine());
		Room room = tempRooms.get(roomNumber);
		if(room.getAvailability()) {
			System.out.println("Available");
			
		} else {
			System.out.println("Not available");
			System.out.println("Would you like to be added to the waitlist (y/n)");
			key = reader.nextLine();
			Reservation r = null;
			if(key.equalsIgnoreCase("y")) {
				r = new Reservation(room, new Guest(), new Date());
			}
			return r;
		}
		return null;
		
	}
	/*public static void viewByDate(List<Room> rooms) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Choose the date which type of rooms to view");
		System.out.println("5 7, 2019 - 5 19, 2019");
		System.out.println("Enter the month");
		int month = Integer.parseInt(reader.nextLine());
		System.out.println("Enter the day");
		int day = Integer.parseInt(reader.nextLine());
		System.out.println("Enter the year");
		int year = Integer.parseInt(reader.nextLine());
		int date = month + day + year;
		Room temp = null;
		for(int i = 0; i < rooms.size() - 1; i++) {
			if(rooms.get(i).getDate().compareTo(rooms.get(i + 1).getDate()) == 1) {
			
			}
		}
	}*/
	public static Reservation getReservation(Room room) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter name");
		String name = reader.nextLine();
		System.out.println("Enter phone number");
		String phoneNumber = reader.nextLine();
		return null;
	}
}
