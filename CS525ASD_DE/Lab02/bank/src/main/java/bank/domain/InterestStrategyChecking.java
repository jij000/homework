package bank.domain;

import java.util.Date;

public class InterestStrategyChecking implements InterestStrategy {
    public double calculateInterest(double balance) {
        if (balance < 1000) {
            return balance * 0.015;
        } else {
            return balance * 0.025;
        }
    }
}
