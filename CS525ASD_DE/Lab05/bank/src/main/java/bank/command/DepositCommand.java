package bank.command;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;

public class DepositCommand implements Command {
    private IAccountDAO accountDAO;
    private long accountNumber;
    private double amount;

    public DepositCommand(IAccountDAO accountDAO, long accountNumber, double amount) {
        this.accountDAO = accountDAO;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
    }

    @Override
    public void unExecute() {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
    }
}
