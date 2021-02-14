package q1;

public class Program {

	public static void main(String[] args) {
		Dish d1 = new Dish("salad");
		d1.addIngerdient("cucuber", 30, 110);
		d1.addIngerdient("tomato", 40, 80);
		d1.addIngerdient("onion", 20, 20);
		d1.addIngerdient("cucuber", 30, 50); // more cucumbers!

		Dish d2 = new Dish("shnitzel");
		d2.addIngerdient("shnitzel", 400, 120);

		Dish d3 = new Dish("chocolate balls");
		d3.addIngerdient("peti ber", 380, 50);
		d3.addIngerdient("chocolate", 520, 100);
		d3.addIngerdient("milk", 130, 40);

		Meal m1 = new Meal(d1, d2, d3);

		System.out.println(m1);
	}
}
