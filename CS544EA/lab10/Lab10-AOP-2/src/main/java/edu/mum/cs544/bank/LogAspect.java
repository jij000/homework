package edu.mum.cs544.bank;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import edu.mum.cs544.bank.logging.Logger;

@Aspect
@Component
public class LogAspect {
    @Autowired
    private Logger logger;

	// Log every call to any method in the bank.dao package (using the Logger).
	@Before("within(edu.mum.cs544.bank.dao..*)")
	public void logBefore(JoinPoint joinpoint) {
		logger.log("method= " + joinpoint.getSignature().getName());
	}

	// Use the Spring StopWatch functionality to measure the duration of all service
	// level methods (any method in the bank.service package) and output the results
	// to the
	// console.
	@Around("@target(org.springframework.stereotype.Service)")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		// print the time to the console
		logger.log("Time to execute Service = " + totaltime + "ms");
		return retVal;
	}

	// Log every JMS message that is sent (using the Logger)
	@After("execution(* edu.mum.cs544.bank.jms.JMSSender.sendJMSMessage(..))")
	public void logAfter(JoinPoint joinpoint) {
		logger.log("JMSMessage= " + joinpoint.getArgs()[0]);
	}

}
