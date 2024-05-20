package Command.ServerCommand;

import Event.EventMap;
import Event.IEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class DeleteNoteCommand implements IServerCommand
{
    IEvent event;

    public void setEvent(IEvent e)
    {
        event = e;
    }


    @Override
    public void execute()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        EventMap m=  ctx.getBean(EventMap.class);
        m.delete(event);
    }
}
