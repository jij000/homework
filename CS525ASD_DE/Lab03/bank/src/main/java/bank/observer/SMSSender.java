package bank.observer;

import bank.domain.AccountEntry;

import java.util.Observable;
import java.util.Observer;

public class SMSSender implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        AccountEntry accountEntry = (AccountEntry) arg;
        System.out.println("SMSSender: account changed ==>> " + accountEntry.toString());
    }
}
