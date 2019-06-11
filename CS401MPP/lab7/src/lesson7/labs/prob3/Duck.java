package lesson7.labs.prob3;

public interface Duck {

	public default void swim() {
		System.out.println("  swimming");
	}

	public default void display() {
		System.out.println("  displaying");
	}

	public void fly();

	public void quack();
}
