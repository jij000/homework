package bank.dao;

import bank.dao.EmailSenderDAO;
import bank.domain.Customer;

public class MockEmailSenderDAOImpl implements EmailSenderDAO {
    private static MockEmailSenderDAOImpl emailSender;

    private MockEmailSenderDAOImpl() {
        // Prevent form the reflection api.
        if (emailSender != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static MockEmailSenderDAOImpl getEmailSender() {
        // Double check locking pattern
        if (emailSender == null) { // Check for the first time
            synchronized (EmailSenderDAOImpl.class) { // Check for the second time.
                if (emailSender == null) emailSender = new MockEmailSenderDAOImpl();
            }
        }
        return emailSender;
    }

    public void sendEmail(Customer customer) {
        System.out.println("MockEmailSenderDAOImpl Send email to: " + customer.toString());
    }
}
