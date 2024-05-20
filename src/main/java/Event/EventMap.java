package Event;

import Event.Time.EventTime;
import Event.Time.HashDate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class EventMap
{
    private static EventMap instance;
    private HashMap<Integer, ArrayList<IEvent>> eventMap;
    private EventMap()
    {
        eventMap = new HashMap<>(365);
    }

    public static EventMap getInstance()
    {
        if(instance == null)
            instance = new EventMap();
        return instance;
    }

    public void delete(HashDate d,int i)
    {
        List<IEvent> oldList = eventMap.get(d.hashCode());
        oldList.remove(i);
    }

    public void delete(IEvent e)
    {
        List<IEvent> oldList = eventMap.get(e.hashCode());
        oldList.remove(e);
    }




    public void addNewEvent(IEvent eve)
    {
        if(!eventMap.containsKey(eve.hashCode()))
        {
            ArrayList<IEvent> l = new ArrayList<>();
            l.add(eve);
            eventMap.put(eve.hashCode(),l);
        }
        else
        {
            eventMap.get(eve.hashCode()).add(eve);
        }

    }



    public List<IEvent> formListFromHash(int hash)
    {
        List<IEvent> result = new ArrayList<>();
        if(!eventMap.containsKey(hash)) return null;
        for(IEvent n : eventMap.get(hash))
            result.add(n);
        return result;
    }

    public List<IEvent> formNotesList(int showInterval)
    {
        List<HashDate> dateList = new ArrayList<>();
        Calendar cal = new GregorianCalendar();
        dateList.add(new HashDate(cal.getTime()));
        for(int i = 0; i < showInterval-1;i++)
        {
            cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) + 1);
            dateList.add(new HashDate(cal.getTime()));
        }

        List<IEvent> result = new ArrayList<>();
        for(HashDate h : dateList)
            if(eventMap.containsKey(h.hashCode()))
                result.addAll(eventMap.get(h.hashCode()));
        return result;
    }
}
