package customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAopConfig {
    @Autowired
    Logger logger;

    @After("execution(* customers.EmailSender.sendEmail(..)) && args(address, message)")
    public void logAfterMethod(JoinPoint joinpoint, String address, String message) {
        logger.log("method="+joinpoint.getSignature().getName() + " address=" + address
            + " message=" + message);
    }
}
