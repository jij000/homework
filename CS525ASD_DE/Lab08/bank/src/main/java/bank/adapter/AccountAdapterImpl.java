package bank.adapter;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AccountAdapterImpl implements AccountAdapter {
    private IAccountDAO accountDAO = new AccountDAO();
    @Override
    public AccountDTO getAccount(long accountNumber) {
        Account account = accountDAO.loadAccount(accountNumber);
        return new AccountDTO(account.getAccountnumber(),account.getCustomer().getName());
    }

    @Override
    public Collection<AccountDTO> getAccounts() {
        Collection<Account> accountList =  accountDAO.getAccounts();
        List<AccountDTO> accountDTOList = new ArrayList<>();
        for (Account account : accountList) {
            accountDTOList.add(new AccountDTO(account.getAccountnumber(),account.getCustomer().getName()));
        }
        return accountDTOList;
    }
}
