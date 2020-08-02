package game;

public class Level1 extends LevelStatus {
    public Level1(Game game) {
        super(game);
        description = "Level1";
    }
    @Override
    public int addPoints(int newPoints) {
        totalPoints = this.game.getTotalPoints() + newPoints;
        if (totalPoints > 10) { // move to level 2
            this.game.setLevelStatus(new Level2(this.game));
            totalPoints = totalPoints + 1;//add 1 bonus point
        }
        return totalPoints;
    }
}
