package Lab02.b;

public class AccountService {
    AccountDAO accountDAO = new AccountDAO();
    public void createAccount() {

    }
    public void deposit(Account account) {
        account.deposit();
    }
    public void withdraw() {

    }
    public void transferFunds() {

    }
    public void getAccount() {

    }
    public void getAllAccounts() {

    }
    public void addInterest(long accountNumber) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.addInterest();
    }
}
