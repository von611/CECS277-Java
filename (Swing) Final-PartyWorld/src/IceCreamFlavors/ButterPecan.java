package IceCreamFlavors;

public class ButterPecan extends IceCream
{	
	/**
	 * Sets the ice cream's flavor to buter pecan
	 */
	public ButterPecan()
	{
		description = "ButterPecan";
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
		return "ButterPecan";
	}
}

