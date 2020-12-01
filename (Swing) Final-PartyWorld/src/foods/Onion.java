package foods;

/**Concrete Decorator in Decorator Design Pattern
 * @author GiovanniSalas
 */
public class Onion extends PizzaToppingsDecorator
{
	Pizza pizza;
	
	/**
	 * wraps a pizza with a topping
	 * @param p - the pizza to be wrapped
	 */
	public Onion(Pizza p)
	{
		pizza = p;
	}
	
	/**
	 * gets the cost of the newly wrapped pizza
	 * @return the cost as a double
	 */
	public double getCost()
	{
		return pizza.getCost() + 0.50;
	}

	/**
	 * gets the description of the newly wrapped pizza
	 * @return the description as a String
	 */
	public String getDescription()
	{
		return pizza.getDescription() + "Onion";
	}
	@Override
	public String getFlavor() {
		// TODO Auto-generated method stub
		return "Onion";
	}
}


