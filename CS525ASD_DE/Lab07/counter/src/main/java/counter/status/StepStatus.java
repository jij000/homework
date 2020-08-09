package counter.status;

import counter.Counter;

public abstract class StepStatus {
    protected final Counter counter;
    public StepStatus(Counter counter) {
        this.counter=counter;
    }
    public abstract int increment(int count);
    public abstract int decrement(int count);
}
