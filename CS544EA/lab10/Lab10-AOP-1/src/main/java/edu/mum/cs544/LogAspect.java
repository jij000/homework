package edu.mum.cs544;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAspect {
    private static Logger logger = LogManager.getLogger(LogAspect.class.getName());

    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(..))")
    public void logAfter(JoinPoint joinpoint) {
        logger.warn("method= " + joinpoint.getSignature().getName() + " address=" + joinpoint.getArgs()[0] + " message="
                + joinpoint.getArgs()[1]);
        IEmailSender emailSender = (IEmailSender) joinpoint.getTarget();
        logger.warn("outgoing mail server = " + emailSender.getOutgoingMailServer());
    }
    @Around("execution(* edu.mum.cs544.CustomerDAO.*(..))")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        logger.warn("Time to execute save = " + totaltime + "ms");
        return retVal;
    }

}
