package IceCreamFlavors;

public class ChocolateFudge extends IceCream
{	
	/**
	 * Sets the ice cream's flavor to chocolate fudge
	 */
	public ChocolateFudge()
	{
		description = "ChocolateFudge";
	}
	
	/**
	 * returns the cost of this flavor as a double
	 */
	public double getCost()
	{
		return 0.50;
	}
	@Override
	public String getFlavor() {
		// TODO Auto-generated method stub
		return "ChocolateFudge";
	}
}
