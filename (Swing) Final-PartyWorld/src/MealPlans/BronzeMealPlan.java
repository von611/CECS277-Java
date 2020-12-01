package MealPlans;
import java.util.List;

import Sodas.SodaBottle;
import foods.*;

public class BronzeMealPlan extends MealPlan{
	private Food side;
	private Pizza pizza1, pizza2, pizza3;
	private SodaBottle soda1, soda2, soda3, soda4, soda5;
	public BronzeMealPlan() {
		super("BronzeMealPlan");
		this.pizza1 = new GourmetPizza();
		this.pizza2 = new GourmetPizza();
		this.pizza3 = new GourmetPizza();
		setDescription("Included in meal:"
				+ "\n     3 XL 2 Topping Gourmet Pizzas"
				+ "\n     5 2L Soda Bottles"
				+ "\n     Salad or bread-sticks"
				+ "\nCost: $75");
	}
	public void setSide(Food food) {
		this.side = food;
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
	public void setSoda4(SodaBottle soda) {
		this.soda4 = soda;
	}
	public void setSoda5(SodaBottle soda) {
		this.soda5 = soda;
	}
	/*public Pizza getPizza(int n, Pizza p) {
		if(n == 1) {
			return new Cheese(p);
		}
		if(n == 2) {
			return new Pepperoni(p);
		}
		if(n == 3) {
			return new Ham(p);
		}
		if(n == 4) {
			return new Jalapeno(p);
		}
		if(n == 5) {
			return new Sausage(p);
		}
		if(n == 6) {
			return new Mushroom(p);
		}
		if(n == 7) {
			return new Pineapple(p);
		}
		if(n == 8) {
			return new BellPepper(p);
		}
		if(n == 9) {
			return new Onion(p);
		}
		if(n == 10) {
			return new GarlicChicken(p);
		}
		return null;
	}*/
	public Pizza getPizza1() {
		return this.pizza1;
	}
	public Pizza getPizza2() {
		return this.pizza2;
	}
	public Pizza getPizza3() {
		return this.pizza3;
	}
	public Food getSide() {
		return this.side;
	}
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
		return 75;
	}
}
