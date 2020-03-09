package shop.domain;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class Order {
	@Id
    String orderNumber;
    LocalDate date;
    String status;
    ArrayList<CartLine> cartlineList = new ArrayList<CartLine>();
}
