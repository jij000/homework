package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import shop.domain.Order;
import shop.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;

	@GetMapping("/order/{orderNumber}")
	public ResponseEntity<?> getContact(@PathVariable String orderNumber) {
		Order order = orderService.getOrder(orderNumber);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

}
