package bank.domain;

import java.util.*;

public class Account {
	long accountnumber;
	Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	Customer customer;
	AccountType accountType;
	InterestStrategy interestStrategy;
	
	public Account (long accountnr){
		this.accountnumber = accountnr;
	}
	public Account (long accountnr, AccountType accountType){
		this.accountnumber = accountnr;
		this.accountType = accountType;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
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
		entryList.add(entry);
	}
	public void withdraw(double amount){
		AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
		entryList.add(entry);	
	}

	private void addEntry(AccountEntry entry){
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
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
		double amount = interestStrategy.calculateInterest(getBalance());
		AccountEntry entry = new AccountEntry(new Date(), amount, "interest", "", "");
		entryList.add(entry);
	}
}
