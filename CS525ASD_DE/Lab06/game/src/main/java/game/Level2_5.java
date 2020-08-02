package game;

public class Level2_5 extends LevelStatus {
    public Level2_5(Game game) {
        super(game);
        description = "Level2_5";
    }
    @Override
    public int addPoints(int newPoints) {
        totalPoints = this.game.getTotalPoints() + 1 * newPoints;
        if (totalPoints >= 20) { // move to level 3
            this.game.setLevelStatus(new Level3(this.game));
            totalPoints = totalPoints + 1; //add 1 bonus points
        }
        return totalPoints;
    }
}
