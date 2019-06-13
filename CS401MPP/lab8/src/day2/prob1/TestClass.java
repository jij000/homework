package day2.prob1;

public class TestClass {

	public static void main(String[] args) {
		MyClass c1 = new MyClass(2, "aaa");
		MyClass c2 = new MyClass(3, "aaa");
		MyClass c3 = new MyClass(2, "bbb");
		MyClass c4 = new MyClass(2, "aaa");

		System.out.println(c1.myMethod(c2));
		System.out.println(c1.myMethod(c3));
		System.out.println(c1.myMethod(c4));
	}

}
