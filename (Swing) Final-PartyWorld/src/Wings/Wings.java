package Wings;
import foods.Food;
/**
 * Superclass that models a wing
 * @author GiovanniSalas
 */
public abstract class Wings extends Food
{
	String description = "Unknown Wings";
	String boneType = "bone-in";
	public Wings() {
		super("Wings");
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * gets the description(flavor) of the wing
	 * @return the description as a String
	 */
	public String getDescription()
	{
		return description;
	}
	public void setBoneType(String boneType) {
		this.boneType = boneType;
	}
	public String getBoneType() {
		return this.boneType;
	}
	/**
	 * gets the cost of the specific wing flavor, to be overriden in subclasses
	 * @return the cost as a double
	 */
	public abstract double getCost();
}

