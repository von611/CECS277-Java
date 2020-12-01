package Wings;

public class Sesame extends Wings
{
	/**
	 * Sets the wing's flavor to Sesame
	 */
	public Sesame()
	{
		description = "Sesame";
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
		return "Sesame";
	}
}

