package product;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class CustomerDAOMock implements ICustomerDAO {
    private ILogger logger = new Logger();

    public void save(Customer customer) {
        // simple sleep
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Test **** CustomerDAO: saving customer "+customer.getName());
        logger.log("Test **** Customer is saved in the DB: "+ customer.getName() );
    }

}
