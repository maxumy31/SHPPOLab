package Command;
import Command.ServerCommand.CreateNewNoteCommand;
import Event.EventInput;
import Event.EventMap;
import Event.EventQuery;
import Server.NotebookServer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AskToCreateNewNoteCommand implements ICommand
{
    EventInput input;

    @Override
    public void execute()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        EventMap m = ctx.getBean(EventMap.class);
        var v = input.input();
        CreateNewNoteCommand c = ctx.getBean(CreateNewNoteCommand.class);
        c.setEvent(v);
        ctx.getBean(NotebookServer.class).addCommandToQueue(c);
        //c.waitUntilCreate();
        ctx.close();
    }


    public void setEventInput(EventInput i)
    {

        this.input = i;
    }

    @Override
    public void printCommand() {
        System.out.print(
                "Создать новую запись.");
    }
}
