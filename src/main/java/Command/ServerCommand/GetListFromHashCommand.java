package Command.ServerCommand;

import Event.EventMap;
import Event.IEvent;
import Event.Time.HashDate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class GetListFromHashCommand implements IServerCommand, IAwaitCommand
{
    boolean isReady = false;
    List<IEvent> eventList;
    HashDate hash;

    public synchronized void setHashDate(HashDate d)
    {
        hash = d;
    }
    @Override
    public synchronized void execute()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        eventList = ctx.getBean(EventMap.class).formListFromHash(hash.hashCode());
        ctx.close();
        notify();
        isReady = true;

    }

    public synchronized List<IEvent> waitList()
    {
        if(!isReady)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
        return eventList;
    }
}
