package IceCreamFlavors;

public class VanillaBean extends IceCream
{	
	/**
	 * Sets the ice cream's flavor to vanilla bean
	 */
	public VanillaBean()
	{
		description = "VanillaBean";
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
		return "VanillaBean";
	}
}

