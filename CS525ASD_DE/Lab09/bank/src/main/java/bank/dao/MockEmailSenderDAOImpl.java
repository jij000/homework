package bank.dao;

import bank.dao.EmailSenderDAO;
import bank.domain.Customer;

public class MockEmailSenderDAOImpl implements EmailSenderDAO {
    public void sendEmail(Customer customer) {
        System.out.println("MockEmailSenderDAOImpl Send email to: " + customer.toString());
    }
}
