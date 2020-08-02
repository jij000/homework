package game;

public class Level3 extends LevelStatus {
    public Level3(Game game) {
        super(game);
        description = "Level3";
    }
    @Override
    public int addPoints(int newPoints) {
        totalPoints = this.game.getTotalPoints() + 3 * newPoints;
        return totalPoints;
    }
}
