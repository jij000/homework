package counter;

import java.util.Observable;
import java.util.Observer;

public class CounterObserver implements Observer {

    private TextFrame textFrame;
    private RectFrame rectFrame;
    private OvalFrame ovalFrame;

    @Override
    public void update(Observable o, Object count) {
        this.textFrame.setCount((Integer) count);
        this.rectFrame.setCount((Integer) count);
        this.ovalFrame.setCount((Integer) count);
    }

    public void setTextFrame(TextFrame textFrame) {
        this.textFrame = textFrame;
    }

    public void setRectFrame(RectFrame rectFrame) {
        this.rectFrame = rectFrame;
    }

    public void setOvalFrame(OvalFrame ovalFrame) {
        this.ovalFrame = ovalFrame;
    }
}
