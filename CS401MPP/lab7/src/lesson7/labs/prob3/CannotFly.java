package lesson7.labs.prob3;

public interface CannotFly {
	public default void fly(){
        System.out.println("  cannot fly");
    }
}
