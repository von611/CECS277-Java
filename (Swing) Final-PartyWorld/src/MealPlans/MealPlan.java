package MealPlans;
import java.util.ArrayList;
import java.util.List;
import foods.*;
import Sodas.*;
import Wings.*;
import IceCreamFlavors.*;
abstract public class MealPlan {
	private String type, description;
	private List<Food> foods;
	private List<Pizza> pizzas;
	private List<SodaBottle> sodas;
	private List<Wings> wings;
	private List<IceCream> iceCreams;
	public MealPlan(String type) {
		this.foods = new ArrayList<Food>();
		pizzas = new ArrayList<Pizza>();
		sodas = new ArrayList<SodaBottle>();
		wings = new ArrayList<Wings>();
		iceCreams = new ArrayList<IceCream>();
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	public void addMeals(Food food) {
		this.foods.add(food);
	}
	public List<Food> getFoods() {
		return this.foods;
	}
	public String toString() {
		return this.type;
	}
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	abstract public int getCost();

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void addPizzas(Pizza pizza) {
		this.pizzas.add(pizza);
	}

	public List<SodaBottle> getSodas() {
		return sodas;
	}

	public void addSodas(SodaBottle sodas) {
		this.sodas.add(sodas);
	}

	public List<Wings> getWings() {
		return wings;
	}

	public void addWings(Wings wings) {
		this.wings.add(wings);
	}

	public List<IceCream> getIceCreams() {
		return iceCreams;
	}

	public void addIceCreams(IceCream iceCreams) {
		this.iceCreams.add(iceCreams);
	}
	public Pizza getPizza(String flavor, Pizza p) {
		if(flavor.equalsIgnoreCase("Cheese")) {
			return new Cheese(p);
		}
		if(flavor.equalsIgnoreCase("Pepperoni")) {
			return new Pepperoni(p);
		}
		if(flavor.equalsIgnoreCase("Ham")) {
			return new Ham(p);
		}
		if(flavor.equalsIgnoreCase("Jalapeno")) {
			return new Jalapeno(p);
		}
		if(flavor.equalsIgnoreCase("Sausage")) {
			return new Sausage(p);
		}
		if(flavor.equalsIgnoreCase("Mushroom")) {
			return new Mushroom(p);
		}
		if(flavor.equalsIgnoreCase("Pineapple")) {
			return new Pineapple(p);
		}
		if(flavor.equalsIgnoreCase("BellPepper")) {
			return new BellPepper(p);
		}
		if(flavor.equalsIgnoreCase("Onion")) {
			return new Onion(p);
		}
		if(flavor.equalsIgnoreCase("GarlicChicken")) {
			return new GarlicChicken(p);
		}
		return null;
	}
	/*public String getMealPlan() {
		String meal = "";
		if(!this.pizzas.isEmpty()) {
			for(Pizza p : this.pizzas) {
				meal += "\n" + p;
			}
		}
		if(!this.sodas.isEmpty()) {
			for(SodaBottle s : this.sodas) {
				meal += "\n" + s;
			}
		}
		if(!this.wings.isEmpty()) {
			for(Wings w : this.wings) {
				meal += "\n" + w;
			}
		}
		if(!this.iceCreams.isEmpty()) {
			for(IceCream i : this.iceCreams) {
				meal += "\n" + i;
			}
		}
		if(!this.foods.isEmpty()) {
			for(Food f : this.foods) {
				meal += "\n" + f;
			}
		}
		return meal;
	}*/
	public abstract String getMealPlan();
}
