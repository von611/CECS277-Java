package Sodas;
import foods.Food;
/**
 * Superclass that models a soda bottle
 * @author GiovanniSalas
 */
public abstract class SodaBottle extends Food
{
	/**
	 * One instance variable for its description
	 */
	String description = "Unknown soda";
	public SodaBottle() {
		super("Soda Bottle");
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * gets the description(flavor) of the soda bottle
	 * @return the description as a String
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * gets the cost of the specific soda bottle, to be overriden in subclasses
	 * @return the cost as a double
	 */
	public abstract double getCost();
}

