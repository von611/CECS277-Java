package MealPlans;
import java.util.List;
import foods.*;
import Sodas.*;
public class BasicMealPlan extends MealPlan{
	private Pizza pizza1, pizza2, pizza3;
	private SodaBottle soda1, soda2, soda3;
	private Food side;
	public BasicMealPlan() {
		super("BasicMealPlan");
		this.pizza1 = new GourmetPizza();
		this.pizza2 = new GourmetPizza();
		this.pizza3 = new GourmetPizza();
		setDescription("Included in meal:"
				+ "\n     3 XL 1 Topping Gourmet Pizzas"
				+ "\n     3 2L Soda Bottles"
				+ "\nCost: $65");
	
	}
	public void addPizza1(Food food) {
		this.pizza1 = getPizza(food.getFlavor(), this.pizza1);
	}
	public void addPizza2(Food food) {
		this.pizza2 = getPizza(food.getFlavor(), this.pizza2);
	}
	public void addPizza3(Food food) {
		this.pizza3 = getPizza(food.getFlavor(), this.pizza3);
	}
	public void setSoda1(SodaBottle soda) {
		this.soda1 = soda;
	}
	public void setSoda2(SodaBottle soda) {
		this.soda2 = soda;
	}
	public void setSoda3(SodaBottle soda) {
		this.soda3 = soda;
	}
	public Pizza getPizza1() {
		return this.pizza1;
	}
	public Pizza getPizza2() {
		return this.pizza2;
	}
	public Pizza getPizza3() {
		return this.pizza3;
	}
	public SodaBottle getSodaBottle1() {
		return this.soda1;
	}
	public SodaBottle getSodaBottle2() {
		return this.soda2;
	}
	public SodaBottle getSodaBottle3() {
		return this.soda3;
	}
	/*public Pizza getPizza(String flavor, Pizza p) {
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
	}*/
	@Override
	public String getMealPlan() {
		String meal = "";
		meal += "\nPizza 1: " + this.pizza1.getDescription();
		meal += "\nPizza 2: " + this.pizza2.getDescription();
		meal += "\nPizza 3: " + this.pizza3.getDescription();
		meal += "\nSoda 1: " + this.soda1.getDescription();
		meal += "\nSoda 2: " + this.soda2.getDescription();
		meal += "\nSoda 3: " + this.soda3.getDescription();
		return meal;
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 65;
	}
	
	
}
