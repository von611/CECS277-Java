package IceCreamFlavors;

public class StrawberryShortcake extends IceCream
{	
	/**
	 * Sets the ice cream's flavor to strawberry shortcake
	 */
	public StrawberryShortcake()
	{
		description = "StrawberryShortcake";
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
		return "StrawberryShortcake";
	}
}

