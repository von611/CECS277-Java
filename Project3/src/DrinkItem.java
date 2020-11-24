import java.util.ArrayList;
import java.util.List;

public abstract class DrinkItem extends Item {
	private String size, flavor, sweetness, milk;
	/**
	 * 
	 * @param name goes into super class
	 * @param size sets DrinkItem's size
	 * @param flavor sets DrinkItem's flavor
	 * @param sweetness sets DrinkItem's sweetness
	 * @param milk sets DrinkItem's milk
	 */
	public DrinkItem(String name, String size, String flavor, String sweetness, String milk) {
		super.setName(name);
		this.size = size;
		this.flavor = flavor;
		this.sweetness = sweetness;
		this.milk = milk;
	}
	/**
	 * @param flavor sets DrinkItem's flavor
	 **/
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	
	/**
	 * 
	 * @param milk sets DrinkItem's milk
	 */
	public void setMilk(String milk) {
		this.milk = milk;
	}

	/**
	 * @param size sets DrinkItem's size
	 **/
	public void setSize(String size) {
		this.size = size;
	}
	
	/**
	 * @param sweetness sets DrinkItem's sweetness
	 **/
	public void setSweetness(String sweetness) {
		this.sweetness = sweetness;
	}
	
	/**
	 * @return DrinkItem's flavor
	 **/
	public String getFlavor() {
		return this.flavor;
	}
	
	/**
	 * @return DrinkItem's milk
	 */
	public String getMilk() {
		return this.milk;
	}
	
	/**
	 * @return DrinkItem's size
	 */
	public String getSize() {
		return this.size;
	}
	
	/**
	 * 
	 * @return DrinkItem's sweetness
	 */
	public String getSweetness() {
		return this.sweetness;
	}

	/**
	 * @return super class's name and DrinkItem's flavor, sweetness
	 */
	@Override
	public String toString() {
		return "	--" + this.flavor + "(" + this.size + "):		$";
	}
	@Override
	public double calculateCost() {
		// TODO Auto-generated method stub
		return 0;
	}
}
