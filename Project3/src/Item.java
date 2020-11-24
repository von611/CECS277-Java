
public abstract class Item {
	protected String name;
	protected double cost;
	/**
	 * Constructs item class, sets name to Item and cost to 0.00
	 */
	public Item() {
		this.name = "Item";
		this.cost = 0.00;
	}
	/**
	 * @param name sets Item's name
	 * @param cost sets Item's cost
	 */
	public Item(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
	/**
	 * 
	 * @param name sets Item's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @param cost sets Item's cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * 
	 * @return Item's name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * 
	 * @return Item's cost
	 */
	public double getCost() {
		return this.cost;
	}
	/**
	 * 
	 * @return cost of Item
	 */
	public abstract double calculateCost();
}
