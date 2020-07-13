package bank.observer;

import bank.domain.Account;

import java.util.Observable;
import java.util.Observer;

public class EmailSender implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Account account = (Account) arg;
        System.out.println("EmailSender: a new Account is created ==>> " + arg.toString());
    }
}
