package game;

public abstract class LevelStatus {
    protected String description;
    protected int totalPoints = 0;
    protected Game game;

    public LevelStatus(Game game) {
        this.game=game;
    }

    public abstract int addPoints(int newPoints);
}
