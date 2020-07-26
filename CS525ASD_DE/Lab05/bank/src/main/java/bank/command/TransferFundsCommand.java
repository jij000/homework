package bank.command;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;

public class TransferFundsCommand implements Command {
    private IAccountDAO accountDAO;
    private long fromAccountNumber;
    private long toAccountNumber;
    private double amount;
    private String description;

    public TransferFundsCommand(IAccountDAO accountDAO, long fromAccountNumber, long toAccountNumber, double amount, String description){
        this.accountDAO = accountDAO;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public void execute() {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
    }

    @Override
    public void unExecute() {
        Account fromAccount = accountDAO.loadAccount(toAccountNumber);
        Account toAccount = accountDAO.loadAccount(fromAccountNumber);
        fromAccount.transferFunds(toAccount, amount, "UNDO: " + description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
    }
}
