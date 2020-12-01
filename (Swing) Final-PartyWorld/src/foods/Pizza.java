package foods;
/**
 * Component in Decorator Design Pattern
 * @author GiovanniSalas
 */
public abstract class Pizza extends Food
{
	String description = "Unknown Pizza";
	public Pizza() {
		super("GourmetPizza");
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param description
	 */
	/*public void setDescription(String description) {
		super.setDescription(description);
	}*/
	
	/**
	 * gets the description(topping) of the pizza
	 * @return the description as a String
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * gets the cost of the specific pizza topping, to be overriden in subclasses
	 * @return the cost as a double
	 */
	public abstract double getCost();
	
}

