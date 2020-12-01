package foods;

/**Concrete Decorator in Decorator Design Pattern
 * @author GiovanniSalas
 */
public class Sausage extends PizzaToppingsDecorator
{
	Pizza pizza;
	
	/**
	 * wraps a pizza with a topping
	 * @param p - the pizza to be wrapped
	 */
	public Sausage(Pizza p)
	{
		pizza = p;
		//super.setDescription(p.getDescription());
	}
	
	/**
	 * gets the cost of the newly wrapped pizza
	 * @return the cost as a double
	 */
	public double getCost()
	{
		return pizza.getCost() + 0.50;
	}
	@Override
	public String getFlavor() {
		return "Sausage";
	}

	/**
	 * gets the description of the newly wrapped pizza
	 * @return the description as a String
	 */
	public String getDescription()
	{
		return pizza.getDescription() + "Sausage";
	}
	
}

