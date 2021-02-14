package afeka_Project3;

/*
 * Name:Shay Gabison ID:207726563 HomeWorkNumber:3
 *This class containing objects named Lecturer.
 *The objects properties in this class are: 
 *name= lecturer name.
 *numOfTimesPenFalls= The number of times the teacher drops the pen from the hand on average in class.
 *favoriteIceCream=The name of his favorite ice cream.
 *idOfLecturer=lecturer serial number.
 */
public class Lecturer {
	private String name;
	private int numOfTimesPenFalls;
	private String favoriteIceCream;
	public static int idOfLecturer = 1000;
	int id;

	public Lecturer(String name, String favoriteIceCream, int numOfTimesPenFalls) {
		setName(name);
		setFavoriteIceCream(favoriteIceCream);
		setNumOfTimesPenFalls(numOfTimesPenFalls);
		id = idOfLecturer++;
	}

	public String getName() {
		return name;
	}

	public String getFavoriteIceCream() {
		return favoriteIceCream;
	}

	public int getNumOfTimesPenFalls() {
		return numOfTimesPenFalls;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFavoriteIceCream(String favoriteIceCream) {
		this.favoriteIceCream = favoriteIceCream;
	}

	public void setNumOfTimesPenFalls(int numOfTimesPenFalls) {
		this.numOfTimesPenFalls = numOfTimesPenFalls;
	}

	public String toString() {
		return "Lecturer name: " + name + "\nFavorite ice cream: " + favoriteIceCream
				+ "\nNumber of times the pen falls: " + numOfTimesPenFalls + "\nLecturer's working ID: " + id + ".";
	}
}
