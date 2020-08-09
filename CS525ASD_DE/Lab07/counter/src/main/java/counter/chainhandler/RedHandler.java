package counter.chainhandler;

import counter.Counter;

public class RedHandler extends Handler {
    public RedHandler(Handler nextHandler) {
        super(nextHandler);
    }
    @Override
    public void handle(Counter counter) {
        if (counter.getCount() % 2 == 0 && (counter.getCount() < 10 || counter.getCount() == 12 || counter.getCount() == 13)) {
            System.out.println("Red");
        }
        if (nextHandler != null) {
            nextHandler.handle(counter);
        }
    }
}
