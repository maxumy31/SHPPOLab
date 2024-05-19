package Event;

import Command.*;
import Event.Time.EventTime;
import Event.Time.HashDate;
import Event.Time.TimeManager;

import Menu.Menu;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventInput
{

    boolean isRunning = true;
    Menu menu;

    public EventInput()
    {

    }


    public void setMenu(Menu menu) {
        this.menu = menu;
    }


    public void endInputLoop()
    {
        isRunning = false;
    }

    public IEvent input()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        DependencyManager man = ctx.getBean(DependencyManager.class);
        IProxyBuilder builder = man.getBuilder();
        ctx.close();

        builder.setMessage("Сообщение создано автоматически.");
        isRunning = true;
        builder.setTime(new EventTime(new HashDate(TimeManager.getInstance().getCurrentDate())));
        while(isRunning)
        {

            builder.printInput();

            menu.printMenu();
            Integer action = menu.inputAndCheck();
            if (action == null) continue;
            ICommand c = menu.getCommand(action);
            if (c == null) continue;
            c.execute();
        }
        man.updateDependencies();
        return builder.create();
    }



}
