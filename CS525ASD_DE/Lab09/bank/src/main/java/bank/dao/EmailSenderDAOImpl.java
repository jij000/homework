package bank.dao;

import bank.dao.EmailSenderDAO;
import bank.domain.Customer;

public class EmailSenderDAOImpl implements EmailSenderDAO {
    public void sendEmail(Customer customer) {
        System.out.println("EmailSenderDAOImpl Send email to: " + customer.toString());
    }
}
