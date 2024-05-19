package Command;
import Event.EventInput;
import Event.EventMap;
import Event.EventQuery;
import jdk.jfr.Event;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateNewNoteCommand implements ICommand
{
    EventInput input;
    EventQuery query;

    @Override
    public void execute()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        EventMap m=  ctx.getBean(EventMap.class);
        var v = input.input();
        query.addNewEvent(v);
        ctx.close();
    }

    public void setQuery(EventQuery q)
    {
        query = q;
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
