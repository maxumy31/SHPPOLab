package Event;

import Event.Time.EventTime;

public interface IProxyBuilder
{

    void reset();
    void setPosition(String s);
    void setMessage(String s);
    void setTime(EventTime e);
    IEvent create();
    void printInput();
}
