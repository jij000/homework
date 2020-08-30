package bank.factory;

import bank.dao.*;

public class AccountFactory implements MyFactory{
    public IAccountDAO getAccountDAO() {
        return new AccountDAOLoggerImpl();
    }
    public EmailSenderDAO getEmailSenderDAO() {
        return EmailSenderDAOImpl.getEmailSender();
    }
}