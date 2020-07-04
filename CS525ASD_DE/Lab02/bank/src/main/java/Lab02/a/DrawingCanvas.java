package Lab02.a;

public class DrawingCanvas {
    private DrawStrategy drawStrategy;
    public void draw() {
        drawStrategy.draw();
    }

    public DrawStrategy getDrawStrategy() {
            return drawStrategy;
    }

    public void setDrawStrategy(DrawStrategy drawStrategy) {
            this.drawStrategy = drawStrategy;
    }
}
