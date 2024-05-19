package Event;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EventQuery
{
    int distance = 7;
    public EventQuery()
    {

    }


    public List<IEvent> takeList()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        List<IEvent> l = ctx.getBean(EventMap.class).formNotesList(distance);
        ctx.close();
        return l;
    }

    public void addNewEvent(IEvent e)
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        EventMap m = ctx.getBean(EventMap.class);
        m.addNewEvent(e);
        ctx.close();
    }
}
