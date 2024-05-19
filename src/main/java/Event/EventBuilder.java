package Event;

import Event.Time.EventTime;

//Билдер ивентов
public class EventBuilder implements IProxyBuilder
{
    private EventTime time;
    private String message;
    private String position;

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setTime(EventTime time) {this.time = time;}

    public void setPosition(String pos) {this.position = pos;}

    public EventBuilder()
    {
    }

    public IEvent create()
    {
        if(time == null) return null;
        if(message == null) return null;
        IEvent objectToReturn = null;
        if(position == null)
            objectToReturn = new NoteEvent(message,time);
        else
        {
            NoteEvent obj = new NoteEvent(message, time);
            objectToReturn = new EventWithPosition(obj, position);
        }

        return objectToReturn;
    }

    public void reset()
    {
        time = null;
        message = null;
        position = null;
    }

    public void printInput()
    {
        System.out.println("Введенное время:");
        System.out.println(time);

        System.out.println("\nВведенное сообщение:");
        System.out.println(message);

        System.out.println("\nВведенное местоположение:");
        System.out.println(position);
    }
}

