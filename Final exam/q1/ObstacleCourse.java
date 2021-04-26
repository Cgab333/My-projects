package q1;

import q1.Obstacle.eLevel;

public class ObstacleCourse {
	public enum eAddObstacleStatus {
		Succeed, FailedCourseIsDone, FailedObstacleAlreadyInCourse
	};

	public static final int MAX_OBSTACLES = 7;

	private Obstacle[] allObstacles;
	private int numOfObstacles;

	public ObstacleCourse() {
		allObstacles = new Obstacle[MAX_OBSTACLES];
		numOfObstacles = 0;
	}

	public int getNumofObstacles() {
		return numOfObstacles;
	}

	public Obstacle getObsatcle(int index) {
		if (index < 0 || index >= numOfObstacles)
			return null;

		return allObstacles[index];
	}

	public Obstacle.eLevel calcCourseLevel() {
		int sum = 0;
		for (int i = 0; i < numOfObstacles; i++)
			sum += allObstacles[i].getLevel().ordinal();

		int averageObstaclesLevel = (int) Math.round((double) sum / numOfObstacles);
		return Obstacle.eLevel.values()[averageObstaclesLevel];
	}

	public eAddObstacleStatus addObstacle(String obstacleName, eLevel rateOfHardness) {
		if (numOfObstacles == MAX_OBSTACLES)
			return eAddObstacleStatus.FailedCourseIsDone;
		for (int index = 0; index < MAX_OBSTACLES; index++) {
			if (allObstacles[index] != null && allObstacles[index].getName().equals(obstacleName)) {
				return eAddObstacleStatus.FailedObstacleAlreadyInCourse;

			}
		}
		allObstacles[numOfObstacles] = new Obstacle(obstacleName, rateOfHardness);
		numOfObstacles++;
		return eAddObstacleStatus.Succeed;
	}

	public String toString() {
		StringBuffer str = new StringBuffer("The Course had " + numOfObstacles + " obstacles:\n");
		for (int index = 0; index < numOfObstacles; index++) {
			str.append(allObstacles[index].toString() + "\n");
		}

		return str.toString();
	}
}