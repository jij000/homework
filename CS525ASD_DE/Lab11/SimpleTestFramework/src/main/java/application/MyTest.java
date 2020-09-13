package application;

import framework.Before;
import framework.Test;
import framework.TestClass;

@TestClass
public class MyTest {
	@Before
	public void beforeTestMethod() {
		System.out.println("perform initialization");
	}

	@Test
	public void testMethod1() {
		System.out.println("perform test method 1");
	}

	@Test
	public void testMethod2() {
		System.out.println("perform test method 2");
	}

}
