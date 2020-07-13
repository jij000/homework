package bank.dao;

import java.util.*;
import bank.domain.Account;
import bank.observer.EmailSender;

public class AccountDAO extends Observable implements IAccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();
	EmailSender emailSender = new EmailSender();
	{
		this.addObserver(emailSender);
	}

	public void saveAccount(Account account) {
		accountlist.add(account); // add the new
		setChanged();
		notifyObservers(account);
	}

	public void updateAccount(Account account) {
		Account accountexist = loadAccount(account.getAccountnumber());
		if (accountexist != null) {
			accountlist.remove(accountexist); // remove the old
			accountlist.add(account); // add the new
		}

	}

	public Account loadAccount(long accountnumber) {
		for (Account account : accountlist) {
			if (account.getAccountnumber() == accountnumber) {
				return account;
			}
		}
		return null;
	}

	public Collection<Account> getAccounts() {
		return accountlist;
	}

}
