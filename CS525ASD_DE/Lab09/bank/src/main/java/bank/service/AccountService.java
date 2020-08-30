package bank.service;

import java.util.Collection;

import bank.dao.AccountDAOImpl;
import bank.dao.EmailSenderDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.factory.DaoFactory;
import bank.factory.MyFactory;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private EmailSenderDAO emailSenderDAO;

	
	public AccountService(){
		DaoFactory mainfactory = new DaoFactory();
		MyFactory factory = mainfactory.getFactoryInstance();
		accountDAO = factory.getAccountDAO();
		emailSenderDAO = factory.getEmailSenderDAO();
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		emailSenderDAO.sendEmail(account.getCustomer());
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		emailSenderDAO.sendEmail(account.getCustomer());
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		emailSenderDAO.sendEmail(account.getCustomer());
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		emailSenderDAO.sendEmail(fromAccount.getCustomer());
		emailSenderDAO.sendEmail(toAccount.getCustomer());
	}
}
