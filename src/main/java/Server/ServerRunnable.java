package Server;

public class ServerRunnable implements Runnable
{
    NotebookServer server;
    public ServerRunnable(NotebookServer s)
    {
        server = s;
    }

    @Override
    public void run()
    {
        while (server.getRunning())
        {
            server.processCommands();
        }
    }
}
