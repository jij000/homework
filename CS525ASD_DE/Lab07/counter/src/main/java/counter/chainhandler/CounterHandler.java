package counter.chainhandler;

import counter.Counter;

public class CounterHandler {
    private Handler chainOfHandlers;
    public void setChainOfHandlers(Handler chainOfHandlers) {
        this.chainOfHandlers = chainOfHandlers;
    }
    public void handleCounter(Counter counter) {
        chainOfHandlers.handle(counter);
    }
}
