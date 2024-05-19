package Event.Time;

import jdk.jfr.Event;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EventTime
{
    protected HashDate startDate;


    public EventTime(HashDate date)
    {
        this.startDate = date;
    }

    @Override
    public int hashCode()
    {
        HashDate h = new HashDate(startDate);
        return h.hashCode();
    }

    @Override
    public String toString() {
        return startDate.toLocaleString();
    }

    public Date getStartDate()
    {
        return startDate;
    }
}
