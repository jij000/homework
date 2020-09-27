package customers;

public class NewCustomerEvent {
    private Customer customer;
    public NewCustomerEvent(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "NewCustomerEvent{" +
            "customer=" + customer.toString() +
            '}';
    }
}
