package AOP;

import org.aspectj.lang.JoinPoint;

public class LoggerAspect
{
    public void log(JoinPoint joinPoint,Object result)
    {
        System.out.println("After method: " + joinPoint.getSignature().toShortString());
        System.out.println("User input = " + result);

    }
}
