package IceCreamFlavors;

public class ChocoMint extends IceCream
{	
	/**
	 * Sets the ice cream's flavor to choco mint
	 */
	public ChocoMint()
	{
		description = "ChocoMint";
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
		return "ChocoMint";
	}
}

