package bank.domain;

import java.util.Date;

public class InterestStrategySaving implements InterestStrategy {
    public double calculateInterest(double balance) {
        if (balance < 1000) {
            return balance * 0.01;
        } else if (balance >= 1000 && balance < 5000) {
            return balance * 0.02;
        } else {
            return balance * 0.04;
        }
    }
}
