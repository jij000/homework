package customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class DaoAopConfig {

    @Around("execution(* customers.CustomerDAO.*(..))")
    public Object calculateDuration (ProceedingJoinPoint call) throws Throwable {
        StopWatch clock = new StopWatch("CustomerDAO");
        clock.start(call.toShortString());
        Object object= call.proceed();
        clock.stop();
        System.out.println(clock.prettyPrint());
        return object;
    }
}
