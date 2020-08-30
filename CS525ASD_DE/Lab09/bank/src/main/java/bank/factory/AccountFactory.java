package bank.factory;

import bank.dao.*;

public class AccountFactory implements MyFactory{
    public IAccountDAO getAccountDAO() {
        return new AccountDAOImpl();
    }
    public EmailSenderDAO getEmailSenderDAO() {
        return new EmailSenderDAOImpl();
    }
}