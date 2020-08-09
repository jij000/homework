package counter.chainhandler;

import counter.Counter;

public abstract class Handler {
    protected Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public Handler getNextHandler() {
        return nextHandler;
    }
    public abstract void handle(Counter counter);
}
