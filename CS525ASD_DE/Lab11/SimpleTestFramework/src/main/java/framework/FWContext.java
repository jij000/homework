package framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

public class FWContext {

	private static List<Object> objectMap = new ArrayList<>();

	public FWContext() {
		try {
			// find and instantiate all classes annotated with the @TestClass annotation
			Reflections reflections = new Reflections("");
			Set<Class<?>> types = reflections.getTypesAnnotatedWith(TestClass.class);
			for (Class<?> implementationClass : types) {
				objectMap.add((Object) implementationClass.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() {
		try {
			for (Object theTestClass : objectMap) {
				// find the only one method annotated with the @Before  annotation
				Method methodBefore = null;
				for (Method method : theTestClass.getClass().getDeclaredMethods()) {
					if (method.isAnnotationPresent(Before.class)) {
						methodBefore = method;
					}
				}
				// find all methods annotated with the @Test annotation
				for (Method method : theTestClass.getClass().getDeclaredMethods()) {
					if (method.isAnnotationPresent(Test.class)) {
						methodBefore.invoke(theTestClass);
						method.invoke(theTestClass);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
