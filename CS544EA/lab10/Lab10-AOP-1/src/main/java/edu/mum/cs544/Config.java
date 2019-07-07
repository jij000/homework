package edu.mum.cs544;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("edu.mum.cs544")
@EnableAspectJAutoProxy
// proxy-target-class is an attribute of the AOP config that, 
// if set to “true” forces the proxying to use CGLIB proxies instead of Java Proxies.
// @EnableAspectJAutoProxy(proxyTargetClass=true)
public class Config {

}