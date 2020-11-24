
public class CoffeeItem extends DrinkItem {
	private String temperature;
	private String specialinstructions;
	/**
	 * calls super class with given variables
	 * sets CoffeeItem's temperature to blended
	 * sets CoffeeItem's specialinstructions to an empty string
	 */
	public CoffeeItem() {
		super("Coffee", "S", "Mocha Coffee", "8", "whole-milk");
		this.temperature = "blended";
		this.specialinstructions = "";
	}
	
	/**
	 * 
	 * @param size goes into DrinkItem super class
	 * @param flavor goes into DrinkItem super class
	 * @param sweetness goes into DrinkItem super class
	 * @param milk goes into DrinkItem super class
	 * @param temperature set to this CoffeItem's temperature
	 * @param specialinstructions set to this CoffeeItem's special instructions
	 */
	public CoffeeItem(String size, String flavor, String sweetness, String milk, String temperature,
			String specialinstructions) {
		super("Coffee", size, flavor, sweetness, milk);
		this.temperature = temperature;
		this.specialinstructions = specialinstructions;
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return toString of DrinkItem, cost, sweetness, milk, temperature, and special instructions
	 */
	@Override
	public String toString() {
		return super.toString() + calculateCost() + "\n		Sweetness: " + super.getSweetness() + "\n		Milk: " + super.getMilk() + "\n		Temp: " + this.temperature + "\n		Special Intructions: "
				+ this.specialinstructions;
	}
	/**
	 * @return cost base on temperature and size
	 */
	@Override
	public double calculateCost() {
		double cost = 0.00;
		if (this.temperature.equalsIgnoreCase("Hot") || this.temperature.equalsIgnoreCase("Iced")) {
			if (super.getSize().equalsIgnoreCase("S")) {
				cost += 1.00;
			}
			if (super.getSize().equalsIgnoreCase("M")) {
				cost += 1.50;
			}
			if (super.getSize().equalsIgnoreCase("L")) {
				cost += 2.00;
			}
		}
		if (this.temperature.equalsIgnoreCase("Blended")){
			if (super.getSize().equalsIgnoreCase("S")) {
				cost += 1.25;
			}
			if (super.getSize().equalsIgnoreCase("M")) {
				cost += 1.75;
			}
			if (super.getSize().equalsIgnoreCase("L")) {
				cost += 2.25;
			}
		}
		if(!super.getMilk().equalsIgnoreCase("no milk")) {
			cost += 0.25;
		}

		return cost;
	}
}
