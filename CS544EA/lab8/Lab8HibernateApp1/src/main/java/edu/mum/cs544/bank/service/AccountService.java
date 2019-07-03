package edu.mum.cs544.bank.service;

import edu.mum.cs544.bank.EntityManagerHelper;
import edu.mum.cs544.bank.dao.IAccountDAO;
import edu.mum.cs544.bank.dao.JPAAccountDAO;
import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.domain.Customer;
import edu.mum.cs544.bank.logging.ILogger;
import edu.mum.cs544.bank.logging.Logger;

import java.util.Collection;


public class AccountService implements IAccountService {
    private IAccountDAO accountDAO;
    private ICurrencyConverter currencyConverter;
    private ILogger logger;

    public AccountService() {
//        accountDAO = new AccountDAO();
        accountDAO = new JPAAccountDAO();
        currencyConverter = new CurrencyConverter();
        logger = new Logger();
    }

    public Account createAccount(long accountNumber, String customerName) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        EntityManagerHelper.getCurrent().getTransaction().begin();
        accountDAO.saveAccount(account);
        logger.log("createAccount with parameters accountNumber= " + accountNumber + " , customerName= " + customerName);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
        return account;
    }

    public void deposit(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        EntityManagerHelper.getCurrent().getTransaction().begin();
        accountDAO.updateAccount(account);
        logger.log("deposit with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
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
        EntityManagerHelper.getCurrent().getTransaction().begin();
        accountDAO.updateAccount(account);
        logger.log("withdraw with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
    }

    public void depositEuros(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.deposit(amountDollars);
        EntityManagerHelper.getCurrent().getTransaction().begin();
        accountDAO.updateAccount(account);
        logger.log("depositEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
    }

    public void withdrawEuros(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.withdraw(amountDollars);
        EntityManagerHelper.getCurrent().getTransaction().begin();
        accountDAO.updateAccount(account);
        logger.log("withdrawEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
    }

    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        EntityManagerHelper.getCurrent().getTransaction().begin();
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
        logger.log("transferFunds with parameters fromAccountNumber= " + fromAccountNumber + " , toAccountNumber= " + toAccountNumber + " , amount= " + amount + " , description= " + description);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
    }
}
