package Sodas;

public class OrangeCrush extends SodaBottle
{
	/**
	 * Sets the soda bottle's type to Orange Crush
	 */
	public OrangeCrush()
	{
		description = "OrangeCrush";
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
		return "OrangeCrush";
	}
}

