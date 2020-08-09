package counter.chainhandler;

import counter.Counter;

public class LogHandler extends Handler {
    public LogHandler(Handler nextHandler) {
        super(nextHandler);
    }
    @Override
    public void handle(Counter counter) {
        System.out.println("Write to log: counter.getCount():" + counter.getCount());
        if (nextHandler != null) {
            nextHandler.handle(counter);
        }
    }
}
