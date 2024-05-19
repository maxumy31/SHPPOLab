package Event;

import Event.Time.EventTime;

public class EventWithPosition extends EventDecorator
{
    String position;
    public EventWithPosition(IEvent e, String s)
    {
        super(e);
        position = s;
    }

    @Override
    public EventTime getTime()
    {
        return event.getTime();
    }

    @Override
    public String toString()
    {
        return event.toString() + "\nМестоположение - '" + position + "'.";
    }

    @Override
    public boolean equals(NoteEvent eve)
    {
        return event.getTime() == eve.getTime() && event.getMessage().equals(eve.getMessage());
    }

    @Override
    public String getMessage()
    {
        return event.getMessage();
    }

    @Override
    public int hashCode() {
        return event.hashCode();
    }
}
