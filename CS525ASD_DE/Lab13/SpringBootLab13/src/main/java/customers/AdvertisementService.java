package customers;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementService {
    @Async
    @EventListener
    public void writeCustomerInformation(NewCustomerEvent newCustomerEvent) {
        System.out.println("AdvertisementService received event :" + newCustomerEvent.toString());;
    }
}
