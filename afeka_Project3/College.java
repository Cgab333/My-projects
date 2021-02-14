package afeka_Project3;

/*
 * Name:Shay Gabison ID:207726563 HomeWorkNumber:3
 *This class containing objects named College.
 *The objects properties in this class are: 
 *name= College name.
 *numOfLecturers= The number of lecturers at the time in the college.
 *maxNumOfLecturers=The maximum lecturers the college can contain.
 *allLecturers=Lecturer type array contain all lecturers details.
 */
public class College {
	private String name;
	private int numOfLecturers, maxNumOfLecturers;
	public Lecturer[] allLecturers;

	public College(String name, int maxNumOfLecturers) {
		this.name = name;
		this.maxNumOfLecturers = maxNumOfLecturers;
		this.allLecturers = new Lecturer[maxNumOfLecturers];
	}

	public String getName() {
		return name;
	}

	public int getNumOfLecturers() {
		return numOfLecturers;
	}

	public int getLecturerArrayLenght() {
		return allLecturers.length;
	}

	public int getMaxNumOfLecturers() {
		return maxNumOfLecturers;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumOfLecturers(int numOfLecturers) {
		this.numOfLecturers = numOfLecturers;
	}

	public String toString() {
		return "College name: " + name + " " + "Number of lecturers: " + numOfLecturers;
	}

	public boolean addLecturer(String name, String favoriteIceCream, int numOfTimesPenFalls) {
		if (numOfLecturers < maxNumOfLecturers) {
			allLecturers[numOfLecturers] = new Lecturer(name, favoriteIceCream, numOfTimesPenFalls);
			numOfLecturers++;
			return true;
		} else
			return false;
	}// Boolean method checking if there is enough space for more lecturer.
}
