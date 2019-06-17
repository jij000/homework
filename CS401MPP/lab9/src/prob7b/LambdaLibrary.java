package prob7b;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
	public static final TriFunction<List<Employee>, Integer , char[], String> GET_FULL_NAMES 
		= (list, minSalary, nameRange) 
		     -> list.stream()
				.filter(x -> x.salary>minSalary)
				.filter(x -> {
					char a = x.lastName.charAt(0);
					return a >= nameRange[0] && a <= nameRange[1] ? true : false;
				})
				.map(x->x.firstName+" "+x.lastName)
				.sorted()
				.collect(Collectors.joining(", "));
}
