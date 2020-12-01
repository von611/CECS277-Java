package IceCreamFlavors;
import foods.Food;
/**
 * Superclass that models an ice cream
 * @author GiovanniSalas
 */
public abstract class IceCream extends Food
{
	/**
	 * One instance variable for its description
	 */
	String description = "Unknown Ice Cream";
	public IceCream() {
		super("IceCream");
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * gets the description(flavor) of the ice cream
	 * @return the description as a String
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * gets the cost of the specific ice cream flavor, to be overriden in subclasses
	 * @return the cost as a double
	 */
	public abstract double getCost();
}

