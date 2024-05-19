package AOP;

import Event.IEvent;
import Event.Time.HashDate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Aspect
public class NearMapCacheAspect
{
    List<IEvent> list;
    boolean isDirty = true;
    int distance = 7;
    public NearMapCacheAspect()
    {
        list = new ArrayList<>(distance);
    }

    public boolean getDirty()
    {
        return isDirty;
    }

    public void makeDirty()
    {
        isDirty = true;
    }



    public List<IEvent> findInCache(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        List<IEvent> e = null;
        if(!isDirty)
        {
            e = list;
        }
        else
        {
            e = (List<IEvent>)joinPoint.proceed();
            list = e;
            isDirty = false;
        }

        return e;
    }
}
