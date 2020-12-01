package Sodas;

public class DietCoke extends SodaBottle
{
	/**
	 * Sets the soda bottle's type to Diet Coke
	 */
	public DietCoke()
	{
		description = "DietCoke";
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
		return "DietCoke";
	}
}



