package config;

import customers.CustomerDAO;
import customers.CustomerService;
import customers.EmailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomerService customerService(){
        CustomerService customerService = new CustomerService();
        customerService.setCustomerDAO(customerDAO());
        customerService.setEmailSender(emailSender());
        return customerService;
    }
    @Bean
    public CustomerDAO customerDAO(){
        return new CustomerDAO();
    }
    @Bean
    public EmailSender emailSender(){
        return new EmailSender();
    }
}
