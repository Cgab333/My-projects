package q1;

public class Meal {
	public final static int NUM_OF_DISHES = 3;

	private Dish[] allDishes;

	public Meal(Dish d1, Dish d2, Dish d3) {
		this.allDishes = new Dish[NUM_OF_DISHES];
		this.allDishes[0] = d1;
		this.allDishes[1] = d2;
		this.allDishes[2] = d3;
	}

	public int calcCaloriesForMeal() {
		int sum = 0;
		for (int index = 0; index < NUM_OF_DISHES; index++) {
			sum += (this.allDishes[index].calsCalories());

		}
		return sum;
	}

	public String toString() {
		StringBuffer str = new StringBuffer("The meal has these dishes:\n");
		str.append(allDishes[0].toString() + "\n");
		str.append(allDishes[1].toString() + "\n");
		str.append(allDishes[2].toString() + "\n");
		str.append("The meal has " + calcCaloriesForMeal() + " calories");
		return str.toString();
	}

}
