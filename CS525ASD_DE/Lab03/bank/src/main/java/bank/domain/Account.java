package bank.domain;

import bank.observer.EmailSender;
import bank.observer.Logger;
import bank.observer.SMSSender;

import java.util.*;


public class Account extends Observable {
	long accountnumber;
	Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	Customer customer;
	
	public Account (long accountnr){
		this.accountnumber = accountnr;
		Logger logger = new Logger();
		SMSSender smsSender = new SMSSender();
		this.addObserver(logger);
		this.addObserver(smsSender);
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public double getBalance() {
		double balance=0;
		for (AccountEntry entry : entryList) {
			balance+=entry.getAmount();
		}
		return balance;
	}
	public void deposit(double amount){
		AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
		setChanged();
		notifyObservers(entry);
		entryList.add(entry);
	}
	public void withdraw(double amount){
		AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
		setChanged();
		notifyObservers(entry);
		entryList.add(entry);	
	}

	private void addEntry(AccountEntry entry){
		setChanged();
		notifyObservers(entry);
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		setChanged();
		notifyObservers(fromEntry);
		entryList.add(fromEntry);
		toAccount.addEntry(toEntry);

	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	@Override
	public String toString() {
		return "Account{" +
			"accountnumber=" + accountnumber +
			", entryList=" + entryList +
			", customer=" + customer +
			'}';
	}
}
