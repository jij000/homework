package edu.miu.CS525DE.Lab01.c.Service;

import edu.miu.CS525DE.Lab01.c.DAO.BookDAO;
import edu.miu.CS525DE.Lab01.c.DAO.OrderDAO;
import edu.miu.CS525DE.Lab01.c.DAO.ShoppingCartDAO;
import edu.miu.CS525DE.Lab01.c.DAO.UserInfoDAO;
import edu.miu.CS525DE.Lab01.c.Domain.*;

import java.util.List;

public class OrderService {
    private Order newOrder(ShoppingCart shoppingCart, Address shippingAddress) {
        OrderDAO orderDAO = new OrderDAO();
        return orderDAO.newOrder(shoppingCart, shippingAddress);
    }
    private ShoppingCart getShoppingCart(String id) {
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        return shoppingCartDAO.get(id);
    }
    private boolean addShoppingCart(BookItem bookItem) {
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        return shoppingCartDAO.addItem(bookItem);
    }
    private boolean deleteShoppingCart(BookItem bookItem) {
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        return shoppingCartDAO.deleteItem(bookItem);
    }
    private List<Book> search(String condition) {
        BookDAO bookDAO = new BookDAO();
        return bookDAO.search(condition);
    }
    private UserInfo getUserInfo(String id) {
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        return userInfoDAO.getUserInfo(id);
    }
}
