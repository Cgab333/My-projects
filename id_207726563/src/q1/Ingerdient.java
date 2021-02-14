package q1;

public class Ingerdient {
	private String name;
	private int caloriesFor100;

	public Ingerdient(String name, int caloriesFor100) {
		this.name = name;
		this.caloriesFor100 = caloriesFor100;
	}

	public String getName() {
		return name;
	}

	public int getCaloriesFor100() {
		return caloriesFor100;
	}

	@Override
	public String toString() {
		return name + " has " + caloriesFor100 + " calories in 100gr";
	}

}
