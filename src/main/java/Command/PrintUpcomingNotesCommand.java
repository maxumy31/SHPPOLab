package Command;

import Event.EventMap;
import Event.EventQuery;
import Event.IEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PrintUpcomingNotesCommand implements ICommand
{
    EventQuery query;
    public PrintUpcomingNotesCommand()
    {

    }

    public void setQuery(EventQuery q)
    {
        query = q;
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
        String res = "";
        List<IEvent> l = query.takeList();
        for(IEvent event : l)
        {
            res = res + (event);
            res = res + '\n';
        }
        return res;
    }



}
