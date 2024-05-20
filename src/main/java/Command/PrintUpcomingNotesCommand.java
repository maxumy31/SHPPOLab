package Command;

import Command.ServerCommand.IAwaitCommand;
import Command.ServerCommand.IServerCommand;
import Command.ServerCommand.PrepareNotesToListCommand;
import Event.EventQuery;
import Event.IEvent;
import Server.NotebookServer;
import Server.ServerRunnable;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PrintUpcomingNotesCommand implements ICommand
{

    public PrintUpcomingNotesCommand()
    {

    }

    @Override
    public void execute()
    {
        String v = allBeforeNotesIntoString();
        System.out.println(v);
    }

    @Override
    public void printCommand()
    {
        System.out.print("Вывести список заметок.");
    }

    public String allBeforeNotesIntoString()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        String res = "";
        IAwaitCommand c = ctx.getBean(PrepareNotesToListCommand.class);
        ctx.getBean(NotebookServer.class).addCommandToQueue((IServerCommand) c);

        List<IEvent> l = c.waitList();

        for(int i = 0; i < l.size();i++)
        {
            res = res + (l.get(i));
            res = res + '\n';
        }
        return res;
    }



}
