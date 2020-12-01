package MealPlans;
import java.util.List;
import foods.*;

public class PlatinumMealPlan extends MealPlan{
	public PlatinumMealPlan() {
		super("PlatinumMealPlan");
		setDescription("Included in meal:"
				+ "\n     4 XL 4 Topping Gourmet Pizzas"
				+ "\n     5 2L Soda Bottles"
				+ "\n     Salad"
				+ "\n     Bread-sticks"
				+ "\n     Choice of 2 chicken wing flavors. Pick bone-in or boneless."
				+ "\n     2 flavors of ice cream"
				+ "\nCost: $150");
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
		return 150;
	}
}
