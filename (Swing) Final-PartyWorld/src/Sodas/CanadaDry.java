package Sodas;

public class CanadaDry extends SodaBottle
{
	/**
	 * Sets the soda bottle's type to Canada Dry
	 */
	public CanadaDry()
	{
		description = "CanadryDry";
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
		return "CanadaDry";
	}
}


