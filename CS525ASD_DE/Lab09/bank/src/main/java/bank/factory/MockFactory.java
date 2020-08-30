package bank.factory;

import bank.dao.EmailSenderDAO;
import bank.dao.IAccountDAO;
import bank.dao.MockAccountDAOImpl;
import bank.dao.MockEmailSenderDAOImpl;

public class MockFactory implements MyFactory{
    public IAccountDAO getAccountDAO() {
        return new MockAccountDAOImpl();
    }
    public EmailSenderDAO getEmailSenderDAO() {
        return new MockEmailSenderDAOImpl();
    }
}
