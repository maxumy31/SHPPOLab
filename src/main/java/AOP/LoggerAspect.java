package AOP;

import org.aspectj.lang.JoinPoint;

public class LoggerAspect
{
    public void log(JoinPoint joinPoint)
    {
        System.out.println("After method: " + joinPoint.getSignature().toShortString());

    }
}
