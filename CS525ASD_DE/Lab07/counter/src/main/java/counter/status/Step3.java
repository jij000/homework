package counter.status;

import counter.Counter;

public class Step3 extends StepStatus {

    public Step3(Counter counter) {
        super(counter);
    }

    @Override
    public int increment(int count) {
//        if (count+3 >= 100) {
//            counter.setStepStatus(new Step3(counter));
//        }
        return count+3;
    }

    @Override
    public int decrement(int count) {
        if (count-3 < 100) {
            counter.setStepStatus(new Step2(counter));
        }
        return count-3;
    }
}
