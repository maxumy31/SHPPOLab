package Menu;

import Command.ICommand;
import Handlers.IIntHandler;
import Handlers.LessIntHandler;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;


public class Menu implements IMenu
{

    public void setMap(Map<Integer, ICommand> m)
    {
        map = m;
    }
    Map<Integer, ICommand> map = new HashMap<>();
    static Menu activeMenu;

    IntInput in;

    public Menu()
    {

    }


    public static IMenu getActiveMenu()
    {
        return activeMenu;
    }

    @Override
    public ICommand pollAction() {
        return null;
    }

    @Override
    public void printMenu()
    {
        int number = 1;
        for(ICommand c : map.values())
        {
            System.out.print(number++ + "\t");
            c.printCommand();
            System.out.print("\n");
        }
    }

    public Integer inputAndCheck()
    {
        activeMenu = this;
        int max = map.size()-1;

        int action = in.getInt();
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        LessIntHandler h = ctx.getBean(LessIntHandler.class);
        IIntHandler handler = h;
        ctx.close();
        Integer result = null;

        if(handler.handle(action) == IIntHandler.Status.OK)
        {
            result = action;
        }
        return result;
    }

    public void setInput(IntInput i)
    {
        in = i;
    }

    public int getMapSize()
    {
        return map.size();
    }

    public boolean putCommand(int i, ICommand c)
    {
        if(map.get(i) == null)
        {
            map.put(i,c);
            return true;
        }
        else
        {
            return false;
        }
    }

    public ICommand getCommand(int i)
    {
        return map.get(i);
    }
}
