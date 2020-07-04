package Lab02.b;

import java.util.List;

public class Account {
    String AccountNumber;
    Customer customer;
    List<AccountEntry> accountEntryList;
    AccountType accountType;
    InterestStrategy interestStrategy;

    public void deposit() {

    }
    public void withdraw() {

    }
    public void getBalance() {

    }
    public void transferFunds() {

    }
    public void addInterest() {
        switch (accountType) {
            case CHECKING:
                interestStrategy = new InterestStrategyChecking();
                break;
            case SAVING:
                interestStrategy = new InterestStrategySaving();
                break;
            default:
                break;
        }
        interestStrategy.calculateInterest();
    }
}
