package Command.ServerCommand;

import Event.EventQuery;
import Server.NotebookServer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CloseServerCommand implements IServerCommand
{
    public synchronized void execute()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ctx.getBean(NotebookServer.class).shutdown();
        ctx.close();
    }
}
