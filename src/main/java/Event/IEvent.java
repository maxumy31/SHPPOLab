package Event;

import Event.Time.EventTime;

public interface IEvent
{
    public EventTime getTime();
    public int hashCode();
    public boolean equals(NoteEvent eve);
    public String toString();

    public String getMessage();
}
