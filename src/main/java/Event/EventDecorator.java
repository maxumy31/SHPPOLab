package Event;

import Event.Time.EventTime;

public abstract class EventDecorator implements IEvent
{
    protected IEvent event;

    public EventDecorator(IEvent eve)
    {
        event = eve;
    }

}
