package Wings;

public class LemonPepper extends Wings
{
	/**
	 * Sets the wing's flavor to Lemon pepper
	 */
	public LemonPepper()
	{
		description = "LemonPepper";
	}
	
	/**
	 * returns the cost of this wing as a double
	 */
	public double getCost()
	{
		return 0.50;
	}
	@Override
	public String getFlavor() {
		// TODO Auto-generated method stub
		return "LemonPepper";
	}
}

