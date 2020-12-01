package MealPlans;
import java.util.List;
import foods.*;

public class GoldMealPlan extends MealPlan{
	public GoldMealPlan() {
		super("GoldMealPlan");
		setDescription("Included in meal:"
				+ "\n     3 XL 3 Topping Gourmet Pizzas"
				+ "\n     5 2L Soda Bottles"
				+ "\n     Salad"
				+ "\n     Bread-sticks"
				+ "\n     Choice of 2 chicken wing flavors. Pick bone-in or boneless."
				+ "\nCost: $120");
	}
	@Override
	public String getMealPlan() {
		String meal = "";
		/*meal += "\nPizza 1: " + this.pizza1;
		meal += "\nPizza 2: " + this.pizza2;
		meal += "Pizza 3: " + this.pizza3;*/
		return meal;
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 120;
	}
}
