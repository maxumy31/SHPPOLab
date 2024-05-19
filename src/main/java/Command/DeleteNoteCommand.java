package Command;
import Event.EventMap;
import Event.Time.HashDate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeleteNoteCommand implements ICommand
{
    @Override
    public void execute()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Date toDelete = inputDeleteEvent();
        if(toDelete == null) return;
        ctx.getBean(EventMap.class).chooseToDelete(new HashDate(toDelete));
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
}
