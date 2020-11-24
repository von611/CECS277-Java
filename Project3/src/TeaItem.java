import java.util.ArrayList;
import java.util.List;

public class TeaItem extends DrinkItem{
	private List<String> toppings;
	/**
	 * Constructs TeaItem and calls super class
	 */
	public TeaItem() {
		super("TeaItem", "M", "RoseTea", "1/2", "half-half");
		this.toppings = new ArrayList<String>();
	}
	/**
	 * 
	 * @param size goes into super class
	 * @param flavor goes into super class
	 * @param sweetness goes into super class
	 * @param milk goes into super class
	 * w/ string "TeaItem" goes into super class
	 */
	public TeaItem(String size, String flavor, String sweetness, String milk) {
		super("TeaItem", size, flavor, sweetness, milk);
		this.toppings = new ArrayList<String>();
	}
	/**
	 * 
	 * @param topping added to toppings list
	 */
	public void addTopping(String topping) {
		this.toppings.add(topping);
	}

	/**
	 * 
	 * @param size determines base price
	 * @return base price of TeaItem
	 */
	public double getBasePrice(String size) {
		
		if(size.equalsIgnoreCase("S")) {
			return 2.50;
		} else if(size.equalsIgnoreCase("M")) {
			return 3.00;
		}
		return 3.50;
	}
	/**
	 * @return toString of super class and all toppings if any
	 */
	@Override
	public String toString() {
		String topping = "";
		if(!this.toppings.isEmpty()) {
			topping += "\n		Toppings: ";
			for(String t : this.toppings) {
				topping += t + "|"; 
			}
		}
		return super.toString() + calculateCost() + "\n		Sweetness: " + super.getSweetness() + "\n		Milk: " + super.getMilk() + topping;
	}
	/**
	 * @return cost of TeaItem including milk and toppings
	 */
	@Override
	public double calculateCost() {
		// TODO Auto-generated method stub
		double cost = 0.00;
		if(!super.getMilk().equalsIgnoreCase("no milk")) {
			cost += 0.25;
		}
		if(!toppings.isEmpty()) {
			for(String topping : this.toppings) {
				cost += 0.25;
			}
		}
		
		return cost + getBasePrice(super.getSize());
	}
}
