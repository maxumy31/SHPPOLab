package Command.ServerCommand;

import Event.IEvent;

import java.util.List;

public interface IAwaitCommand
{
    public List<IEvent> waitList();
}
