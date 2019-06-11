package lesson7.labs.prob3;

public class RedheadDuck implements Duck, FlyWithWings, Quack {

	@Override
	public void fly() {
		FlyWithWings.super.fly();
	}

	@Override
	public void quack() {
		Quack.super.quack();
	}

}
