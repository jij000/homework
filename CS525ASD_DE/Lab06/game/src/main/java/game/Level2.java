package game;

public class Level2 extends LevelStatus {
    public Level2(Game game) {
        super(game);
        description = "Level2";
    }
    @Override
    public int addPoints(int newPoints) {
        totalPoints = this.game.getTotalPoints() + 2 * newPoints;
        if (totalPoints >= 15) { // move to level 2_5
            this.game.setLevelStatus(new Level2_5(this.game));
            totalPoints = totalPoints + 2; //add 2 bonus points
        }
        return totalPoints;
    }
}
