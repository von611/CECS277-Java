package Sodas;

public class RootBeer extends SodaBottle
{
	/**
	 * Sets the soda bottle's type to Root Beer
	 */
	public RootBeer()
	{
		description = "RootBeer";
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
		return "RootBeer";
	}
}


