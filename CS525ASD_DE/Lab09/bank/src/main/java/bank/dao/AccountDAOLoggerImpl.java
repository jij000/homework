package bank.dao;

import bank.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDAOLoggerImpl extends AccountDAOImpl {
	public AccountDAOLoggerImpl() {
		super();
	}
	public void saveAccount(Account account) {
		System.out.println("AccountDAOLoggerImpl: saveAccount -> " + account.toString());
		super.saveAccount(account); // add the new
	}

	public void updateAccount(Account account) {
		System.out.println("AccountDAOLoggerImpl: updateAccount -> " + account.toString());
		super.updateAccount(account);

	}

	public Account loadAccount(long accountnumber) {
		System.out.println("AccountDAOLoggerImpl: loadAccount -> " + accountnumber);
		return super.loadAccount(accountnumber);
	}

	public Collection<Account> getAccounts() {
		System.out.println("AccountDAOLoggerImpl: getAccounts");
		return super.getAccounts();
	}

}
