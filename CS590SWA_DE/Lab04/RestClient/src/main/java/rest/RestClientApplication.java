package rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import rest.domain.Order;
import rest.domain.ShoppingCart;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;


	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		// Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting", Greeting.class);
		// System.out.println("Receiving message:" + greeting.getContent());
		// 1. Add product1
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("productnumber", "1");
		vars.put("description", "111");
		vars.put("price", "10");
		restTemplate.exchange("http://localhost:8080/product/{productnumber}/{description}/{price}",
			HttpMethod.POST, null, Void.class, vars );
		// // 2. Add product2
		vars.put("productnumber", "2");
		vars.put("description", "222");
		vars.put("price", "20");
		restTemplate.exchange("http://localhost:8080/product/{productnumber}/{description}/{price}",
			HttpMethod.POST, null, Void.class, vars );
		// 3. Add product1 to the shoppingcart (with cartId=1) with quantity 3
		vars.put("cartId", "1");
		vars.put("productnumber", "1");
		vars.put("quantity", "3");
		ResponseEntity<ShoppingCart> res1 = restTemplate.exchange("http://localhost:8080/cart/{cartId}/{productnumber}/{quantity}",
			HttpMethod.POST, null, ShoppingCart.class, vars );
			System.out.println("Receiving message:" + res1.toString());
		// 4. Add product2 to the shoppingcart (with cartId=1) with quantity 2
		vars.put("cartId", "1");
		vars.put("productnumber", "2");
		vars.put("quantity", "2");
		ResponseEntity<ShoppingCart> res2 = restTemplate.exchange("http://localhost:8080/cart/{cartId}/{productnumber}/{quantity}",
			HttpMethod.POST, null, ShoppingCart.class, vars );
		System.out.println("Receiving message:" + res2.toString());
		// 5. Checkout the shoppingcart to create an order with orderId=1
		vars.put("cartId", "1");
		ResponseEntity<ShoppingCart> res3 = restTemplate.exchange("http://localhost:8080/cart/checkout/{cartId}",
			HttpMethod.POST, null, ShoppingCart.class, vars );
			System.out.println("Receiving message:" + res3.toString());
		// 6. Retrieve the order with orderId=1 and print it to the console.
		vars.put("orderNumber", "54e54c9d-1a75-4001-b0cb-23999e3b7564");
		Order order =  restTemplate.getForObject("http://localhost:8080/order/{orderNumber}", Order.class, vars );
		System.out.println("Receiving message:" + order.toString());
	}

}
