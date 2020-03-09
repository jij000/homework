package shop.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.domain.Order;
import shop.domain.ShoppingCart;
import shop.repository.OrderRepository;
import shop.repository.ShoppingCartRepository;

@Service
public class OrderService {
	@Autowired
	ProductCatalogService productCatalogService;
	@Autowired
    ShoppingCartRepository shoppingCartRepository;
	@Autowired
    OrderRepository orderRepository;

    public void createOrder(String orderId, ShoppingCart shoppingCart) {
		Order order = new Order(orderId, LocalDate.now(), "OK", shoppingCart.getCartlineList());
		orderRepository.save(order);
    }

    public void createOrder(ShoppingCart shoppingCart) {
        String orderId = UUID.randomUUID().toString();
		this.createOrder(orderId, shoppingCart);
    }

    public Order getOrder(String orderId) {
		return orderRepository.findById(orderId).get();
	}
}