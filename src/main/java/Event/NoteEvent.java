package Event;

import Event.Time.EventInterval;
import Event.Time.EventTime;

import java.util.Date;

public class NoteEvent implements IEvent
{
    protected String message;
    protected EventTime time;
    public NoteEvent(String message, EventTime time)
    {
        this.message = message;
        this.time = time;
    }

    public int getDelay(Date d)
    {
        long t =  time.getStartDate().getTime() - d.getTime();
        return (int)t/86400000;
    }

    public EventTime getTime()
    {
        return time;
    }


    @Override
    public int hashCode()
    {
        return time.hashCode();
    }

    public String getMessage()
    {
        return message;
    }


    public boolean equals(NoteEvent eve)
    {
        return time == eve.time && message.equals(eve.message);
    }

    public String toString()
    {
        return "Время заметки : " + time.toString() + ".\nСообщение - '" + message + "'.";
    }
}
