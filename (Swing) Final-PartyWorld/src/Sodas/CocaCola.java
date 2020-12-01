package Sodas;

public class CocaCola extends SodaBottle
{
	/**
	 * Sets the soda bottle's type to Coca-Cola
	 */
	public CocaCola()
	{
		description = "Coca-Cola";
	}
	
	/**
	 * returns the cost of this soda as a double
	 */
	public double getCost()
	{
		return 1.50;
	}
	@Override
	public String getFlavor() {
		return "Coca-Cola";
	}
}

