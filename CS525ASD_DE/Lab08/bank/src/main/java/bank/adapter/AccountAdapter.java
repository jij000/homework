package bank.adapter;

import bank.domain.Account;

import java.util.Collection;

public interface AccountAdapter {
    AccountDTO getAccount(long accountNumber);
    Collection<AccountDTO> getAccounts();
}
