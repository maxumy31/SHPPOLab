package Command;

import Event.DependencyManager;
import Event.Time.EventInterval;
import Event.Time.EventTime;
import Event.Time.HashDate;
import Event.Time.TimeManager;
import Handlers.AfterDateHandler;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetEventTimeIntervalCommand implements ICommand
{


    public SetEventTimeIntervalCommand()
    {

    }

    private EventTime inputIntervalTime()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите дату старта в формате часы/минуты-дни/месяцы/года");
        SimpleDateFormat s = new SimpleDateFormat("H/m-dd/MM/yyyy");
        Date start = TimeManager.getInstance().inputDate(s);
        if(start == null) return  null;
        System.out.println("Введите дату конца в формате часы/минуты-дни/месяцы/года");
        Date end = TimeManager.getInstance().inputDate(s);
        if(end == null) return null;

        AfterDateHandler handler  = new AfterDateHandler(start,s);
        switch (handler.handle(s.format(end)))
        {
            case OK:
                break;
            case WRONG_DATE_INTERVAL:
                return null;
        }

        return new EventInterval(new HashDate(start),new HashDate(end));
    }

    @Override
    public void execute()
    {
        EventTime time = inputIntervalTime();
        if(time == null) return;
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ctx.getBean(DependencyManager.class).getBuilder().setTime(time);
        ctx.close();
    }

    @Override
    public void printCommand()
    {
        System.out.print("Ввести временной интервал.");
    }
}
