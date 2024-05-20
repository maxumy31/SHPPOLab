package Server;

import Command.ICommand;
import Command.ServerCommand.IServerCommand;
import Event.EventQuery;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotebookServer
{
    List<IServerCommand> commandList;
    static NotebookServer instance;
    boolean isRunning = true;

    private NotebookServer()
    {
        commandList = new LinkedList<>();
    }

    public synchronized void shutdown()
    {
        notify();
        isRunning = false;
    }

    public synchronized boolean getRunning()
    {
        return isRunning;
    }


    public synchronized IServerCommand getNextCommand()
    {
        if(!commandList.isEmpty())
        {
            IServerCommand c = commandList.getFirst();
            commandList.remove(c);
            return c;
        }
        else
            return  null;
    }

    public static synchronized  NotebookServer getInstance()
    {
        if(instance == null)
        {
            instance = new NotebookServer();
        }
        return instance;
    }


    public synchronized void addCommandToQueue(IServerCommand c)
    {
        commandList.add(c);
        notify();
    }

    public synchronized void processCommands()
    {
        while(true)
        {
            IServerCommand c = getNextCommand();
            if(c == null) break;
            c.execute();
        }

        if(!isRunning) return;


        try
        {
            wait();
        }
        catch (InterruptedException e)
        {

        }
    }

}
