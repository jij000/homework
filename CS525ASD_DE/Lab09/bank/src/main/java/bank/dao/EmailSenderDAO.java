package bank.dao;

import bank.domain.Customer;

public interface EmailSenderDAO {
    public void sendEmail(Customer customer);
}
