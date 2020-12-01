package Wings;

public class MildSpicy extends Wings
{
	/**
	 * Sets the wing's flavor to Mild spicy
	 */
	public MildSpicy()
	{
		description = "MildSpicy";
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
		return "MildSpicy";
	}
}

