package prob8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
		transactions.stream()
			.filter(x->x.getYear()>=2011)
			.sorted(Comparator.comparing(x->x.getValue()))
			.forEach(System.out::println);
        
        // Query 2: What are all the unique cities where the traders work?
		transactions.stream()
			.map(x -> x.getTrader().getCity())
			.distinct()
			.forEach(System.out::println);

        // Query 3: Find all traders from Cambridge and sort them by name.
		transactions.stream()
			.filter(x -> x.getTrader().getCity().equals("Cambridge"))
			.sorted(Comparator.comparing(x -> x.getTrader().getName()))
			.forEach(System.out::println);
        
        // Query 4: Return a string of all traders names sorted alphabetically.
		String traderNames = transactions.stream()
			.map(x -> x.getTrader().getName())
			.sorted()
			.distinct()
			.collect(Collectors.joining(", "));
		System.out.println(traderNames);

        // Query 5: Are there any trader based in Milan?
		transactions.stream()
			.filter(x -> x.getTrader().getCity().equals("Milan"))
			.map(x -> x.getTrader())
			.distinct()
			.forEach(System.out::println);
   
		// Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
		transactions.stream()
			.filter(x -> x.getTrader().getCity().equals("Milan"))
			.forEach(x -> x.getTrader().setCity("Cambridge"));
		System.out.println(transactions);
        
        // Query 7: What's the highest value in all the transactions?
		Transaction t = transactions.stream()
			.max(Comparator.comparing(x->x.getValue())).get();
		System.out.println(t.getValue());
			
    }
}
