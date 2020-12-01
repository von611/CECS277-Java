package Rooms;


public class Date implements Comparable{
	private int month, day, year;
	public Date() {
		this.month = 0;
		this.day = 0;
		this.year = 0;
	}
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getYear() {
		return this.year;
	}
	public int getDayOfYear() {
		return this.month + this.day + this.year;
	}
	@Override
	public String toString() {
		return this.month + " " + this.day + ", " + this.year;
	}
	public int compareTo(Object obj) {
		Date date = (Date) obj;
		if(getMonth() > date.getMonth()) {
			return 1;
		}
		if(getMonth() < date.getMonth()) {
			return -1;
		}
		if(getMonth() == date.getMonth()) {
			if(getDay() > date.getDay()) {
				return 1;
			}
			if(getDay() < date.getDay()) {
				return -1;
			}
			if(getDay() == date.getDay()) {
				return 0;
			}
		}
		// TODO Auto-generated method stub
		return 0;
	}
}

