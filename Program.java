package q1;

public class Program {

	public static void main(String[] args) {
		ObstacleCourse theCourse = new ObstacleCourse();

		theCourse.addObstacle("Step Slider", Obstacle.eLevel.Easy);
		theCourse.addObstacle("Hazard Swing", Obstacle.eLevel.Medium);
		theCourse.addObstacle("Rolling Escargot", Obstacle.eLevel.Easy);
		theCourse.addObstacle("Giant Swingr", Obstacle.eLevel.Hard);
		theCourse.addObstacle("Spinning Bridge", Obstacle.eLevel.Hard);
		theCourse.addObstacle("The Wall", Obstacle.eLevel.Medium);

		Competitor[] allCompetitors = new Competitor[5];
		allCompetitors[0] = new Competitor("Yuval Shamla", theCourse);
		allCompetitors[1] = new Competitor("Gil Marentz", theCourse);
		allCompetitors[2] = new Competitor("Yosi Ben-Yosef", theCourse);
		allCompetitors[3] = new Competitor("Alex Hazanov", theCourse);
		allCompetitors[4] = new Competitor("Tal Klepfer", theCourse);

		for (int i = 0; i < allCompetitors.length; i++)
			allCompetitors[i].startCourse();

		System.out.println();
		System.out.println(theCourse);

		Competitor best = bestCompetitor(allCompetitors);
		System.out.println("The best competitor is " + best.getName() + ", completed " + best.getNumOfSucceedObstacles()
				+ " obstacles!");
	}

	public static Competitor bestCompetitor(Competitor[] allCompetitors) {
		int indexOfCurrentBest = 0;
		for (int index = 0; index < allCompetitors.length; index++) {
			if (allCompetitors[indexOfCurrentBest].getNumOfSucceedObstacles() < allCompetitors[index].getNumOfSucceedObstacles()) {
				indexOfCurrentBest = index;

			}

		}
		return allCompetitors[indexOfCurrentBest];

	}
}
