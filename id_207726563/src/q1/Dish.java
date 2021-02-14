package q1;

public class Dish {
	public final static int MAX_INGREDIENTS = 10;

	private String name;
	private Ingerdient[] allIngredients;
	private int[] gramsPerIngerdient; //
	private int numOfIngredients;

	public Dish(String name) {
		this.name = name;
		this.allIngredients = new Ingerdient[MAX_INGREDIENTS];
		this.gramsPerIngerdient = new int[MAX_INGREDIENTS];
		this.numOfIngredients = 0;
	}

	public Dish(Dish other) {
		name = other.name;
		allIngredients = other.allIngredients;
		gramsPerIngerdient = other.gramsPerIngerdient;
		numOfIngredients = other.numOfIngredients;
	}

	public String getName() {
		return name;
	}

	public Ingerdient[] getAllIngredients() {
		return allIngredients;
	}

	public int[] getGramsPerIngerdient() {
		return gramsPerIngerdient;
	}

	public int getnumOfIngredients() {
		return numOfIngredients;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAllIngredients(Ingerdient[] AllIngredients) {
		this.allIngredients = allIngredients;
	}

	public void setgramsPerIngerdient(int[] gramsPerIngerdient) {
		this.gramsPerIngerdient = gramsPerIngerdient;
	}

	public void setnumOfIngredients(int numOfIngredients) {
		this.numOfIngredients = numOfIngredients;
	}

	public boolean addIngerdient(String ingerdientName, int caloriesFor100, int gramsPerIngerdient) {
		if (this.numOfIngredients > Dish.MAX_INGREDIENTS) {
			return false;
		} else if (findIngerdient(ingerdientName) != -1) {
			this.gramsPerIngerdient[findIngerdient(ingerdientName)] += gramsPerIngerdient;
			return true;
		} else {
			allIngredients[numOfIngredients] = new Ingerdient(ingerdientName, caloriesFor100);
			this.gramsPerIngerdient[numOfIngredients] = gramsPerIngerdient;
			numOfIngredients++;
			return true;
		}
	}
	/*
	 * A boolean function that gets (String-the ingredient name, int - his calories
	 * per 100 grams, int- how much grams); Than the function check if there is
	 * enough "space" for more ingredient; if not so it returns false; Else it check
	 * if the ingredient is already in the dish by the findIngerdient function; if
	 * returns the index of the ingredient in the dish it update the grams; Else it
	 * collect the new ingredient to the dish and return true;
	 *
	 */

	public int findIngerdient(String ingerdientName) {
		for (int index = 0; index < numOfIngredients; index++) {
			if (allIngredients[index].getName() == ingerdientName)
				return index;
		}

		return -1;
	}

	public int calsCalories() {
		int sum = 0;
		for (int index = 0; index < numOfIngredients; index++) {
			sum += ((gramsPerIngerdient[index]) / 10) * (allIngredients[index].getCaloriesFor100() / 10);
		}
		return sum;
	}

	public String toString() {
		StringBuffer str = new StringBuffer("The dish " + name + " has these ingredients:\n");
		for (int i = 0; i < numOfIngredients; i++) {
			str.append((i + 1) + ") " + allIngredients[i] + ", " + gramsPerIngerdient[i] + "grams\n");
		}
		str.append("The dish has " + calsCalories() + " calories\n");

		return str.toString();
	}
}
