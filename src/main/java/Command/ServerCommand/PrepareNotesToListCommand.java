package Command.ServerCommand;

import Event.EventMap;
import Event.EventQuery;
import Event.IEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PrepareNotesToListCommand implements IServerCommand, IAwaitCommand
{
    final int distance = 7;
    List<IEvent> eventList;
    boolean isReady = false;

    @Override
    public synchronized void execute()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        eventList = ctx.getBean(EventQuery.class).takeList();
        ctx.close();
        isReady = true;
        notify();
    }

    public synchronized List<IEvent> waitList()
    {
        if(!isReady)
        try
        {
            wait();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        return eventList;
    }


}
