package Command;
import Command.ServerCommand.CreateNewNoteCommand;
import Command.ServerCommand.DeleteNoteCommand;
import Command.ServerCommand.GetListFromHashCommand;
import Event.EventMap;
import Event.IEvent;
import Event.Time.HashDate;
import Menu.IntInput;
import Server.NotebookServer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AskToDeleteNoteCommand implements ICommand
{
    @Override
    public void execute()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Date toDelete = inputDeleteEvent();
        if(toDelete == null) return;
        DeleteNoteCommand c = ctx.getBean(DeleteNoteCommand.class);
        c.setEvent(chooseToDelete(new HashDate(toDelete)));
        ctx.getBean(NotebookServer.class).addCommandToQueue(c);
        ctx.close();
    }

    @Override
    public void printCommand()
    {
        System.out.print("Удалить запись.");
    }


    public Date inputDeleteEvent()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите дату в формате дни/месяцы/года");
        String date = null;
        try
        {
            date = reader.readLine();
        }
        catch (IOException e)
        {
            return null;
        }
        SimpleDateFormat s = new SimpleDateFormat("H/m-dd/MM/yyyy");
        s.setLenient(false);
        Date d = null;
        try
        {
            date = "0/00-" + date;
            d = s.parse(date);
        }
        catch (ParseException e)
        {
            return null;
        }
        System.out.println(d);
        return d;
    }

    public IEvent chooseToDelete(HashDate d) {
        GetListFromHashCommand c = new GetListFromHashCommand();
        c.setHashDate(d);
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ctx.getBean(NotebookServer.class).addCommandToQueue(c);
        List<IEvent> l = c.waitList();
        if (l == null) return null;
        int lastID = 0;
        for (IEvent n : l) {
            System.out.println(lastID + " - номер мероприятия");
            System.out.println(n);
            System.out.println(' ');
            lastID++;
        }

        System.out.println("Какой номер удалить?");
        IntInput inp = new IntInput();
        return l.get(inp.getInt());
    }
}
