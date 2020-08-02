package game;

public class Application {

	public static void main(String[] args) {
		Game game = new Game();
		LevelStatus levelStatus = new Level1(game);
		game.setLevelStatus(levelStatus);
		game.play();
		game.play();
		game.play();
		game.play();
		game.play();

	}

}
