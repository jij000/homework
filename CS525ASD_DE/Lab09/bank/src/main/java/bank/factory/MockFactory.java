package bank.factory;

import bank.dao.*;

public class MockFactory implements MyFactory{
    public IAccountDAO getAccountDAO() {
        return new MockAccountDAOLoggerImpl();
    }
    public EmailSenderDAO getEmailSenderDAO() {
        return MockEmailSenderDAOImpl.getEmailSender();
    }
}
