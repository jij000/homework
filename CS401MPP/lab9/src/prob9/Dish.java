package prob9;
import java.util.*;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                           new Dish("beef", false, 700, Dish.Type.MEAT),
                           new Dish("chicken", false, 400, Dish.Type.MEAT),
                           new Dish("french fries", true, 530, Dish.Type.OTHER),
                           new Dish("rice", true, 350, Dish.Type.OTHER),
                           new Dish("season fruit", true, 120, Dish.Type.OTHER),
                           new Dish("pizza", true, 550, Dish.Type.OTHER),
                           new Dish("prawns", false, 400, Dish.Type.FISH),
                           new Dish("salmon", false, 450, Dish.Type.FISH));
    
	public static void main(String[] args) {
//    	a. Is there any Vegetarian meal available ( return type boolean)
		System.out.println("a:==========================");
		System.out.println(menu.stream().anyMatch(x->x.getType().equals(Dish.Type.OTHER)));
//    	b. Is there any healthy menu have calories less than 1000 ( return type boolean)
		System.out.println("b:==========================");
		System.out.println(menu.stream().anyMatch(x->x.getCalories() < 1000));
//    	c. Is there any unhealthy menu have calories greater than 1000 ( return type boolean)
		System.out.println("c:==========================");
		System.out.println(menu.stream().anyMatch(x->x.getCalories() > 1000));
//    	d. find and return the first item for the type of MEAT( return type Optional<Dish>)
		System.out.println("d:==========================");
		System.out.println(menu.stream()
				.filter(x->x.getType().equals(Dish.Type.MEAT))
				.findFirst().get());
//    	e. calculateTotalCalories() in the menu using reduce. (return int)
		System.out.println("e:==========================");
		System.out.println(menu.stream()
				.map(x->x.getCalories())
				.reduce((x, y) -> x + y).get());
//    	f. calculateTotalCaloriesMethodReference()in the menu using MethodReferences. (return int)
		System.out.println("f:==========================");
		System.out.println(menu.stream()
				.map(x->x.getCalories())
				.reduce(Integer::sum).get());
	}
}