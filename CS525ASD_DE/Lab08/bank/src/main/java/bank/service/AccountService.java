package bank.service;

import java.lang.reflect.Proxy;
import java.util.Collection;

import bank.adapter.AccountAdapter;
import bank.adapter.AccountAdapterImpl;
import bank.adapter.AccountDTO;
import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.proxy.LoggingProxy;
import bank.proxy.TimingProxy;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private AccountAdapter accountAdapter = new AccountAdapterImpl();
	
	public AccountService(){
		IAccountDAO accountDAOImpl = new AccountDAO();
		ClassLoader classLoader = AccountDAO.class.getClassLoader();
		IAccountDAO loggingProxy =
			(IAccountDAO) Proxy.newProxyInstance(classLoader,
				new Class[] { IAccountDAO.class },
				new LoggingProxy(accountDAOImpl));
		accountDAO =
			(IAccountDAO) Proxy.newProxyInstance(classLoader,
				new Class[] { IAccountDAO.class },
				new TimingProxy(loggingProxy));
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
	}

	public AccountDTO getAccount(long accountNumber) {
		return accountAdapter.getAccount(accountNumber);
	}

	public Collection<AccountDTO> getAccounts() {
		return accountAdapter.getAccounts();
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}
}
