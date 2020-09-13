package framework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import application.Calculator;
import application.CalculatorImpl;
import org.reflections.Reflections;

public class FWContext {

    private static List<Object> objectMap = new ArrayList<>();
    private static List<Object> serviceObjectMap = new ArrayList<>();

    public FWContext() {
        try {
            // find and instantiate all classes annotated with the @TestClass annotation
            Reflections reflections = new Reflections("");
            Set<Class<?>> types = reflections.getTypesAnnotatedWith(TestClass.class);
            for (Class<?> implementationClass : types) {
                objectMap.add((Object) implementationClass.newInstance());
            }
            Set<Class<?>> serviceTypes = reflections.getTypesAnnotatedWith(Service.class);
            for (Class<?> implementationClass : serviceTypes) {
                serviceObjectMap.add((Object) implementationClass.newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            performInjection();
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
                        if (methodBefore != null) {
                            methodBefore.invoke(theTestClass);
                        }
                        method.invoke(theTestClass);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void performInjection() {
        try {
            for (Object theTestClass : objectMap) {
                // find annotated fields
                for (Field field : theTestClass.getClass().getDeclaredFields()) {
                    if (field.isAnnotationPresent(Inject.class)) {
                        // get the type of the field
                        Class<?> theFieldType = field.getType();
                        for (Object theServiceClass : serviceObjectMap) {
                            // only inject classes that are annotated with @Service
                            if (field.getType().getName().contentEquals(theServiceClass.getClass().getName())) {
                                field.setAccessible(true);
                                field.set(theTestClass, theServiceClass);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
