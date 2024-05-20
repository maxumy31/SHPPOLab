package Command.ServerCommand;

import Event.EventMap;
import Event.EventQuery;
import Event.IEvent;
import Event.NoteEvent;
import Server.NotebookServer;
import org.aspectj.weaver.ast.Not;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class CreateNewNoteCommand implements IServerCommand
{
    boolean isReady = false;
    IEvent event;
    public CreateNewNoteCommand() {}

    public void setEvent(IEvent e)
    {
        event = e;
    }
    @Override
    public synchronized void execute()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ctx.getBean(EventQuery.class).addNewEvent(event);
        ctx.close();
        isReady = true;
        notify();
    }

    public synchronized void waitUntilCreate()
    {
        if(!isReady)
        try
        {
            wait();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

}
