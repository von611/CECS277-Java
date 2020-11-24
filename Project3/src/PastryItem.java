
public class PastryItem extends Item{
	private String flavor;
	private boolean isHeated;
	private double HEATED_PRICE;
	/**
	 * 
	 * @param name goes into Item super class
	 * @param flavor set to this Pastry item flavor
	 * @param isHeated set to this Pastry item isHeated boolean value
	 */
	public PastryItem(String name, String flavor, boolean isHeated) {
		super.setName(name);
		this.flavor = flavor;
		this.isHeated = isHeated;
	}
	/**
	 * @return name, heat state, cost, and flavor of pastry item
	 */
	@Override
	public String toString() {
		String heat = "";
		if(isHeated) {
			heat += "(heated)";
		}
		return "	--" + super.getName() + heat + "		$" + calculateCost() + "\n		" + this.flavor;
	}
	/**
	 * @return cost base on name and flavor
	 */
	@Override
	public double calculateCost() {
		double cost = 0.00;
		if(isHeated) {
			cost += 0.25;
		}
		if(super.name.equalsIgnoreCase("Muffin")) {
			cost += 2.00;
		}
		if(super.name.equalsIgnoreCase("Cookie")) {
			cost += 1.50;
		}
		if(super.name.equalsIgnoreCase("Cheesecake Slice")) {
			if(this.flavor.equalsIgnoreCase("Regular")) {
				cost += 4.00;
			} else {
				cost += 4.50;
			}
		}
		if(super.name.equalsIgnoreCase("Danish")) {
			cost += 2.50;
		}
		return cost;
	}
}
