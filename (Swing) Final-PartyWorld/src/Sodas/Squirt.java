package Sodas;

public class Squirt extends SodaBottle
{
	/**
	 * Sets the soda bottle's type to Squirt
	 */
	public Squirt()
	{
		description = "Squirt";
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
		return "Squirt";
	}
}



