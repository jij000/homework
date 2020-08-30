package bank.factory;

import bank.dao.EmailSenderDAO;
import bank.dao.IAccountDAO;

public interface MyFactory {
    public IAccountDAO getAccountDAO();
    public EmailSenderDAO getEmailSenderDAO();
}
