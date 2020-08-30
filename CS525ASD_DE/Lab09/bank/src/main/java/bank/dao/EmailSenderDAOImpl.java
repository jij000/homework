package bank.dao;

import bank.dao.EmailSenderDAO;
import bank.domain.Customer;

public class EmailSenderDAOImpl implements EmailSenderDAO {
    private static EmailSenderDAOImpl emailSender;

    private EmailSenderDAOImpl() {
    // Prevent form the reflection api.
        if (emailSender != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static EmailSenderDAOImpl getEmailSender() {
    // Double check locking pattern
        if (emailSender == null) { // Check for the first time
            synchronized (EmailSenderDAOImpl.class) { // Check for the second time.
                if (emailSender == null) emailSender = new EmailSenderDAOImpl();
            }
        }
        return emailSender;
    }

    public void sendEmail(Customer customer) {
        System.out.println("EmailSenderDAOImpl Send email to: " + customer.toString());
    }
}
