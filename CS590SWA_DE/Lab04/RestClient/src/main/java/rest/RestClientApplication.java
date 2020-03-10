package rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import rest.domain.Product;

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
			HttpMethod.PUT, null, Void.class, vars );
		// // 2. Add product2
		vars.put("productnumber", "2");
		vars.put("description", "222");
		vars.put("price", "20");
		restTemplate.put("http://localhost:8080/product/{productnumber}/{description}/{price}", Product.class, vars);
		// 3. Add product1 to the shoppingcart (with cartId=1) with quantity 3
		// restTemplate.put("http://localhost:8080/cart/1/1/3", null, Product.class);
		// // 4. Add product2 to the shoppingcart (with cartId=1) with quantity 2
		// restTemplate.put("http://localhost:8080/cart/1/2/2", null, Product.class);
		// // 5. Checkout the shoppingcart to create an order with orderId=1
		// restTemplate.put("http://localhost:8080/cart/checkout/1", null, Product.class);
		// // 6. Retrieve the order with orderId=1 and print it to the console.
		// restTemplate.getForEntity("http://localhost:8080/order/1", null, Order.class);

	}

}
