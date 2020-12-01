package foods;

abstract public class Food {
	private String type;
	private String description;
	public Food(String type) {
		this.type = type;
		this.description = "";
	}
	public void setDescription(String description) {
		this.description += description;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}
	public String toString() {
		return this.type + ": " + this.description;
	}
	public abstract String getDescription();
	public abstract double getCost();
	public abstract String getFlavor();
}
