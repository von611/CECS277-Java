package Wings;

public class Diablo extends Wings
{
	/**
	 * Sets the wing's flavor to Diablo
	 */
	public Diablo()
	{
		description = "Diablo";
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
		return "Diablo";
	}
}

