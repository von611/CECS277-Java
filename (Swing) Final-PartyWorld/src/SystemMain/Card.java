package SystemMain;

public class Card {
	private String company, ccNumber, securityCode, expDate;
	public Card() {
		this.company = "NA";
		this.ccNumber = "NA";
		this.securityCode = "NA";
		this.expDate = "NA";
	}
	public Card(String company, String ccNumber, String securityCode, String expDate) {
		this.company = company;
		this.ccNumber = ccNumber;
		this.securityCode = securityCode;
		this.expDate = expDate;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public void setCCNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	public String getCompany() {
		return this.company;
	}
	
	public String getCCNumber() {
		return this.ccNumber;
	}
	public String getSecurityCode() {
		return this.securityCode;
	}
	public String expDate() {
		return this.expDate;
	}
	public String toString() {
		String info = "Company: " + getCompany();
		info += "\nCC Number: " + getCCNumber();
		info += "\n Security Code: " + getSecurityCode();
		info += "\n EXP Date: " + expDate();
		return info;
	}
}
