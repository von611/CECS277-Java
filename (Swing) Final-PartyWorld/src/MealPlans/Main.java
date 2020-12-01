package MealPlans;
import java.util.Scanner;
import foods.*;
import Sodas.*;
import Wings.*;
public class Main {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		MealPlan meal = null;
		
		Food food1 = new Sausage(new GourmetPizza());
		System.out.println(food1.getDescription());
		Pizza pizza1 = new GourmetPizza();
		Pizza pizza2 = new Cheese(pizza1);
		System.out.println(pizza2.getDescription());
		SodaBottle sodas = new CanadaDry();
		System.out.println(sodas.getDescription());
		while(true) {
			System.out.println("Add a meal");
			System.out.println("1.BasicMealPlan");
			System.out.println("2.BronzeMealPlan");
			System.out.println("3.SilverMealPlan");
			System.out.println("4.GoldMealPlan");
			System.out.println("5.PlatinumMealPlan");
			System.out.println("6.Show meal plan");
			String key = "";
			key = reader.nextLine();
			if(key.equalsIgnoreCase("1")) {
				System.out.println("BasicMealPlan");
				System.out.println("Included in meal: ");
				System.out.println("3 XL 1 Topping Gourmet Pizzas");
				System.out.println("3 2L Soda Bottles");
				meal = new BasicMealPlan();
				System.out.println("Choose a topping for your pizzas");
				//Show list of pizza toppings
				for(int i = 0; i < 3; i++) {
					System.out.println((i + 1) + ". pizza");
					//Food food = new Pizza();
					Food food = getPizza(1);
					meal.addMeals(food);
				}
				System.out.println("Choose your soda flavors");
				//Show list of sodas
				for(int i = 0; i < 3; i++) {
					Food food = null;
					System.out.println((i + 1) + ". soda");
					System.out.println("1.Coca-Cola");
					System.out.println("2.Diet Coke");
					System.out.println("3.Canada Dry");
					String soda = "";
					soda = reader.nextLine();
					if(soda.equalsIgnoreCase("1")) {
						food = new CocaCola();
					}
					if(soda.equalsIgnoreCase("2")) {
						food = new DietCoke();
					}
					if(soda.equalsIgnoreCase("3")) {
						food = new CanadaDry();
					}
					meal.addMeals(food);
				}
			}
			if(key.equalsIgnoreCase("2")) {
				System.out.println("BronzeMealPlan");
				System.out.println("Included in meal: ");
				System.out.println("3 XL 2 Topping Gourmet Pizza");
				System.out.println("5 2L Soda Bottles");
				System.out.println("Salad or bread-sticks");
				meal = new BronzeMealPlan();
				System.out.println("Choose a topping for your pizzas");
				//Show list of pizza toppings
				for(int i = 0; i < 3; i++) {
					System.out.println((i + 1) + ". pizza");
					//Food food = new Pizza();
					Food food = getPizza(2);
					meal.addMeals(food);
				}
				System.out.println("Choose you sodas");
				//Show list of sodas
				for(int i = 0; i < 5; i++) {
					System.out.println((i + 1) + ". soda");
					String soda = "";
					soda = reader.nextLine();
					//Food food = new Soda();
					Food food = getSoda(soda);
					meal.addMeals(food);
				}
				System.out.println("Choose: Salad or bread-sticks");
				String side = "";
				side = reader.nextLine();
				Food food = getSide(side);
				meal.addMeals(food);
			}
			if(key.equalsIgnoreCase("3")) {
				System.out.println("SilverMealPlan");
				System.out.println("Included in meal: ");
				System.out.println("3 XL 3 Topping Gourmet Pizzas");
				System.out.println("5 2L Soda Bottles");
				System.out.println("Salad");
				System.out.println("Bread-sticks");
				meal = new SilverMealPlan();
				System.out.println("Choose a topping for your pizzas");
				//Show list of pizza toppings
				for(int i = 0; i < 3; i++) {
					System.out.println((i + 1) + ". pizza");
					String topping = "";
					topping = reader.nextLine();
					//Food food = new Pizza();
					Food food = getPizza(3);
					meal.addMeals(food);
				}
				System.out.println("Choose you sodas");
				//Show list of sodas
				for(int i = 0; i < 5; i++) {
					System.out.println((i + 1) + ". soda");
					String soda = "";
					soda = reader.nextLine();
					//Food food = new Soda();
					Food food = getSoda(soda);
					meal.addMeals(food);
				}
				//meal.addMeals(new Salad());
				//meal.addMeals(new Bread-stick());
				
			}
			if(key.equalsIgnoreCase("4")) {
				System.out.println("GoldMealPlan");
				System.out.println("Included in meal: ");
				System.out.println("3 XL 3 Topping Gourmet Pizzas");
				System.out.println("5 2L Soda Bottles");
				System.out.println("Salad");
				System.out.println("Bread-sticks");
				System.out.println("Choice of 2 chicken wing ﬂavors (Spicy mild, Lemon-pepper, BBQ, Sesame, or Diablo). Pick bone-in or boneless.");
				meal = new GoldMealPlan();
				System.out.println("Choose a topping for your pizzas");
				//Show list of pizza toppings
				for(int i = 0; i < 3; i++) {
					System.out.println((i + 1) + ". pizza");
					String topping = "";
					topping = reader.nextLine();
					//Food food = new Pizza();
					Food food = getPizza(3);
					meal.addMeals(food);
				}
				System.out.println("Choose you sodas");
				//Show list of sodas
				for(int i = 0; i < 5; i++) {
					System.out.println((i + 1) + ". soda");
					String soda = "";
					soda = reader.nextLine();
					//Food food = new Soda();
					Food food = getSoda(soda);
					meal.addMeals(food);
				}
				//meal.addMeals(new Salad());
				//meal.addMeals(new Bread-stick());
				System.out.println("Choose your wing flavors");
				//Show list of wings
				for(int i = 0; i < 2; i++) {
					System.out.println((i + 1) + ". wing");
					String wing = "";
					wing = reader.nextLine();
					//Food food = new Soda();
					Food food = getWing(wing);
					meal.addMeals(food);
				}
			}
			if(key.equalsIgnoreCase("5")) {
				System.out.println("PlatinumMealPlan");
				System.out.println("Included in meal: ");
				System.out.println("4 XL 4 Topping Gourmet Pizzass");
				System.out.println("5 2L Soda Bottles");
				System.out.println("Salad");
				System.out.println("Bread-sticks");
				System.out.println("Choice of 2 chicken wing ﬂavors (Spicy mild, Lemon-pepper, BBQ, Sesame, or Diablo). Pick bone-in or boneless.");
				System.out.println("2 Flavors of Ice cream (Chocolate, Vanilla, Strawberry)");
				meal = new PlatinumMealPlan();
				System.out.println("Choose a topping for your pizzas");
				//Show list of pizza toppings
				for(int i = 0; i < 4; i++) {
					System.out.println((i + 1) + ". pizza");
					String topping = "";
					topping = reader.nextLine();
					//Food food = new Pizza();
					Food food = getPizza(4);
					meal.addMeals(food);
				}
				System.out.println("Choose you sodas");
				//Show list of sodas
				for(int i = 0; i < 5; i++) {
					System.out.println((i + 1) + ". soda");
					String soda = "";
					soda = reader.nextLine();
					//Food food = new Soda();
					Food food = getSoda(soda);
					meal.addMeals(food);
				}
				//meal.addMeals(new Salad());
				//meal.addMeals(new Bread-stick());
				System.out.println("Choose your wing flavors");
				//Show list of wings
				for(int i = 0; i < 2; i++) {
					System.out.println((i + 1) + ". wing");
					String wing = "";
					wing = reader.nextLine();
					//Food food = new Soda();
					Food food = getWing(wing);
					meal.addMeals(food);
				}
				System.out.println("Choose your ice cream flavors");
				for(int i = 0; i < 2; i++) {
					System.out.println((i + 1) + ". ice cream");
					String ic = "";
					ic = reader.nextLine();
					//Food food = new Soda();
					Food food = getIceCream(ic);
					meal.addMeals(food);
				}
			}
			if(key.equalsIgnoreCase("6")) {
				System.out.println(meal);
				for(Food food : meal.getFoods()) {
					System.out.println(food.getDescription());
				}
				System.out.println("Cost: $" + meal.getCost());
			}
		}
	}
	public static Food getPizza(int amount) {
		Pizza pizza = new GourmetPizza();
		Scanner reader = new Scanner(System.in);
		System.out.println("Pick Toppings");
		System.out.println("1.Cheese");
		System.out.println("2.BellPepper");
		System.out.println("3.Sausage");
		for(int i = 0; i < amount; i++) {
			System.out.println("Topping number: " + (i+1));
			String key = "";
			key = reader.nextLine();
			if(key.equalsIgnoreCase("1")) {
				pizza = new Cheese(pizza);
			}
			if(key.equalsIgnoreCase("2")) {
				pizza = new BellPepper(pizza);
			}
			if(key.equalsIgnoreCase("3")) {
				pizza = new Sausage(pizza);
			}
		}
		System.out.println("Pizza: " + pizza.getDescription());
		Food food = pizza;
		System.out.println("Food: " + food.getDescription());
		return food;
	}
	public static Food getWing(String key) {
		Food food = null;
		return food;
	}
	public static Food getIceCream(String key) {
		Food food = null;
		return food;
	}
	public static Food getSoda(String key) {
		Food food = null;
		Scanner reader = new Scanner(System.in);
		System.out.println("Pick a sodaflavor");
		return food;
	}
	public static Food getSide(String key) {
		Food food = null;
		return food;
	}
}
