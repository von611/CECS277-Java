package Wings;

public class BBQ extends Wings
{
	/**
	 * Sets the wing's flavor to BBQ
	 */
	public BBQ()
	{
		description = "BBQ";
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
		return "BBQ";
	}
}
