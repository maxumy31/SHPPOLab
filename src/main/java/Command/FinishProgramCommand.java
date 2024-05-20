package Command;

import Command.ServerCommand.CloseServerCommand;
import Event.EventQuery;
import Notebook.NotebookSystem;
import Server.NotebookServer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FinishProgramCommand implements ICommand
{
    NotebookSystem notebook;
    public FinishProgramCommand()
    {
    }
    @Override
    public void execute()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ctx.getBean(NotebookServer.class).addCommandToQueue(ctx.getBean(CloseServerCommand.class));
        ctx.close();
        notebook.endMainLoop();
    }

    public void setNotebookSystem(NotebookSystem s)
    {
        notebook = s;
    }

    @Override
    public void printCommand()
    {
        System.out.print("Прекратить работу программы");
    }
}
