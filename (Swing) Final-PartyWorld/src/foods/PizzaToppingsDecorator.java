package foods;

/**
 * Decorator in Decorator Design Pattern
 * @author GiovanniSalas
 */
abstract class PizzaToppingsDecorator extends Pizza
{
	/**
	 * The only method in the decorator abstract class
	 * One method that returns the topping of the pizza
	 */
	public abstract String getDescription();
	
}
