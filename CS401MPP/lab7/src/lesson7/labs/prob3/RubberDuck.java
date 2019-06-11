package lesson7.labs.prob3;

public class RubberDuck implements Duck, CannotFly, Squeak {

	@Override
	public void fly() {
		CannotFly.super.fly();
	}

	@Override
	public void quack() {
		Squeak.super.quack();
	}
	
}
