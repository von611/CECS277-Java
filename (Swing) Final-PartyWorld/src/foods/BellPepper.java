package foods;

/**Concrete Decorator in Decorator Design Pattern
 * @author GiovanniSalas
 */
public class BellPepper extends PizzaToppingsDecorator
{
	Pizza pizza;
	
	/**
	 * wraps a pizza with a topping
	 * @param p - the pizza to be wrapped
	 */
	public BellPepper(Pizza p)
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

	/**
	 * gets the description of the newly wrapped pizza
	 * @return the description as a String
	 */
	public String getDescription()
	{
		return pizza.getDescription() + " Bellpepper";
	}

	@Override
	public String getFlavor() {
		// TODO Auto-generated method stub
		return "Bellpepper";
	}

}
