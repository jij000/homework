package counter.status;

import counter.Counter;

public class Step1 extends StepStatus {

    public Step1(Counter counter) {
        super(counter);
    }

    @Override
    public int increment(int count) {
        if (count+1 >= 10) {
            counter.setStepStatus(new Step2(counter));
        }
        return count+1;
    }

    @Override
    public int decrement(int count) {
//        if (count-1 < 10) {
//            counter.setStepStatus(new Step2(counter));
//        }
        return count-1;
    }
}
