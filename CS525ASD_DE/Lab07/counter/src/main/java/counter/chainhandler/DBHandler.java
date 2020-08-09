package counter.chainhandler;

import counter.Counter;

public class DBHandler extends Handler {
    public DBHandler(Handler nextHandler) {
        super(nextHandler);
    }
    @Override
    public void handle(Counter counter) {
        System.out.println("Save to DB: counter.getCount():" + counter.getCount());
        if (nextHandler != null) {
            nextHandler.handle(counter);
        }
    }
}
