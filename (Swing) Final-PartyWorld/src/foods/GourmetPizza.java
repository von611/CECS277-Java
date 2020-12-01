package foods;
//Concrete Component in Decorator Design Pattern
public class GourmetPizza extends Pizza
{	
	public GourmetPizza()
	{
		description = "GourmetPizaa-";
	}
	
	public double getCost() 
	{
		return 5.00;
	}
	@Override
	public String getFlavor() {
		// TODO Auto-generated method stub
		return "GourmetPizza";
	}
}

