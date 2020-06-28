package edu.miu.CS525DE.Lab01.c.DAO;

import edu.miu.CS525DE.Lab01.c.Domain.BookItem;
import edu.miu.CS525DE.Lab01.c.Domain.ShoppingCart;
import edu.miu.CS525DE.Lab01.c.Domain.UserInfo;

import java.util.List;

public class ShoppingCartDAO {

    public ShoppingCart get(String id) {
        return new ShoppingCart();
    }
    public boolean addItem(BookItem bookItem) {
        return false;
    }
    public boolean deleteItem(BookItem bookItem) {
        return false;
    }
}
