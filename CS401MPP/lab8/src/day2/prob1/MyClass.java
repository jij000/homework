package day2.prob1;

import java.util.function.Predicate;

public class MyClass {

	int x;
	String y;
	
	public MyClass(int x, String y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean myMethod(MyClass c1) {
		Predicate<MyClass> p = this::equals;
		return p.test(c1);
	}
	
	@Override
	public boolean equals(Object obj) {
		MyClass c1 = (MyClass) obj;
		if (c1.x == this.x && c1.y.equals(this.y)) {
			return true;
		} else {
			return false;
		}
	}

}
