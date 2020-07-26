package bank.service;

import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;

	public void setAccountDAO(IAccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public AccountService(){
		accountDAO=new AccountDAO();
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		return account;
	}

	public IAccountDAO getAccountDAO() {
		return accountDAO;
	}
//	public void deposit(long accountNumber, double amount) {
//	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

//	public void withdraw(long accountNumber, double amount) {
//	}
//
//	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
//	}
}
