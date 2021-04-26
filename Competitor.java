package q1;

import java.util.Random;

public class Competitor {
	private String name;
	private ObstacleCourse theCourse;
	private int numOfSucceedObstacles;

	public Competitor(String name, ObstacleCourse theCourse) {
		this.name = name;
		this.theCourse = theCourse;
		numOfSucceedObstacles = 0;
	}

	public int getNumOfSucceedObstacles() {
		return numOfSucceedObstacles;
	}

	public String getName() {
		return name;
	}

	public void startCourse() {
		System.out.println(this.getName() + "starts the course!");
		for (int index = 0; index < theCourse.getNumofObstacles(); index++) {
			Random r = new Random();
			boolean res = r.nextBoolean();
			if (res) {
				theCourse.getObsatcle(index).addCompetitor(res);
				System.out.println("\t" + theCourse.getObsatcle(index).getName() + "  --> succeed! ");
				numOfSucceedObstacles++;
			} else {
				theCourse.getObsatcle(index).addCompetitor(res);
				System.out.println("\t" + theCourse.getObsatcle(index).getName() + "  --> failed! ");
				break;
			}

		}

	}

}
