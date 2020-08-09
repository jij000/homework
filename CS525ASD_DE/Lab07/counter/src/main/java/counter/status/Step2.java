package counter.status;

import counter.Counter;

public class Step2 extends StepStatus {

    public Step2(Counter counter) {
        super(counter);
    }

    @Override
    public int increment(int count) {
        if (count+2 >= 100) {
            counter.setStepStatus(new Step3(counter));
        }
        return count+2;
    }

    @Override
    public int decrement(int count) {
        if (count-2 < 10) {
            counter.setStepStatus(new Step1(counter));
        }
        return count-2;
    }
}
