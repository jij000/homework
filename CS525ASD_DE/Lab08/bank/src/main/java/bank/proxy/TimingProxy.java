package bank.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimingProxy implements InvocationHandler {
    private Object target;
    public TimingProxy(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Timer timer = new Timer();
        timer.start();
        // invoke the method on the target
        Object returnValue = method.invoke(target, args);
        timer.stop();
        System.out.println("The method " + method.getName() + " took " + timer.getNanoTime() + " ns");
        return returnValue;
    }
}
