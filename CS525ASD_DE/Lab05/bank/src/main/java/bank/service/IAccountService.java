package bank.service;

import java.util.Collection;

import bank.dao.IAccountDAO;
import bank.domain.Account;

public interface IAccountService {
    Account createAccount(long accountNumber, String customerName);
    Account getAccount(long accountNumber);
    Collection<Account> getAllAccounts();
//    void deposit (long accountNumber, double amount);
//    void withdraw (long accountNumber, double amount);
//    void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
    IAccountDAO getAccountDAO();
    void setAccountDAO(IAccountDAO accountDAO);
}
