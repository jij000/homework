package lesson7.labs.prob3;

public class DecoyDuck implements Duck, MuteQuack, CannotFly {

	@Override
	public void fly() {
		CannotFly.super.fly();
	}

	@Override
	public void quack() {
		MuteQuack.super.quack();
	}
	
}
