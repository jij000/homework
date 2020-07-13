package bank.observer;

import bank.domain.AccountEntry;

import java.util.Observable;
import java.util.Observer;

public class Logger implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        AccountEntry accountEntry = (AccountEntry) arg;
        System.out.println("Logger: account changed ==>> " + accountEntry.toString());
    }
}
