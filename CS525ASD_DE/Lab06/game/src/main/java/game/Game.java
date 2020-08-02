package game;

import java.util.Random;

public class Game {
	private int totalPoints = 0;
	private LevelStatus levelStatus;

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public LevelStatus getLevelStatus() {
		return levelStatus;
	}

	public void setLevelStatus(LevelStatus levelStatus) {
		this.levelStatus = levelStatus;
	}

	public void play() {
		Random random = new Random();
		totalPoints = addPoints(random.nextInt(7));
		System.out.println("points="+totalPoints+" level="+levelStatus.description);
	}

	public int addPoints(int newPoints) {
		totalPoints = levelStatus.addPoints(newPoints);
		return totalPoints;
	}

}
