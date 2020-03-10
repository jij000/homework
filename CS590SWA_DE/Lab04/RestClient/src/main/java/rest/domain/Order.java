package rest.domain;

import java.time.LocalDate;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Order {

    String orderNumber;
    LocalDate date;
    String status;
    ArrayList<CartLine> cartlineList = new ArrayList<CartLine>();
}
