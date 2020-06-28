package edu.miu.CS525DE.Lab01.c.DAO;

import edu.miu.CS525DE.Lab01.c.Domain.Address;
import edu.miu.CS525DE.Lab01.c.Domain.Order;
import edu.miu.CS525DE.Lab01.c.Domain.ShoppingCart;

public class OrderDAO {

    public Order newOrder(ShoppingCart shoppingCart, Address shippingAddress) {
        return new Order();
    }
}
