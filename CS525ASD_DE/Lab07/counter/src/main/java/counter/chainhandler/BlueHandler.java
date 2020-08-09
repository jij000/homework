package counter.chainhandler;

import counter.Counter;

public class BlueHandler extends Handler {
    public BlueHandler(Handler nextHandler) {
        super(nextHandler);
    }
    @Override
    public void handle(Counter counter) {
        if (counter.getCount() % 2 == 1 && (counter.getCount() < 15 || counter.getCount() == 17 || counter.getCount() == 19)) {
            System.out.println("Blue");
        }
        if (nextHandler != null) {
            nextHandler.handle(counter);
        }
    }
}
