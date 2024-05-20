package Notebook;

import Command.*;
import Event.EventMap;
import Menu.Menu;
import Server.NotebookServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NotebookSystem
{
    boolean isRunning = true;

    Menu menu;


    public NotebookSystem()
    {

    }

    public void setMenu(Menu men)
    {
        menu = men;
    }


    public synchronized void processCommand(ICommand c)
    {
        c.execute();
    }


    public void startMainLoop()
    {
        printStartingMessage();
        while(isRunning)
        {
            //printInfoMessage();
            menu.printMenu();
            ICommand c = pollAction();
            if(c == null) continue;
            processCommand(c);
        }
    }

    public void endMainLoop()
    {
        isRunning = false;
    }

    public ICommand pollAction()
    {
        Integer action = menu.inputAndCheck();
        if(action == null) return null;
        return menu.getCommand(action);
    }

    public void printStartingMessage()
    {
        System.out.println("Запуск программы");
    }


}
