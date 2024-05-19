package Command;

import Event.DependencyManager;
import Event.EventBuilder;
import Event.IProxyBuilder;
import Event.Time.EventTime;
import Event.Time.HashDate;
import Event.Time.TimeManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SetEventTimeCommand implements ICommand
{

    @Override
    public void execute()
    {
        EventTime time = inputEventTime();
        if(time == null) return;
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ctx.getBean(DependencyManager.class).getBuilder().setTime(time);
        ctx.close();
    }

    @Override
    public void printCommand() {
        System.out.print("Ввести время");
    }

    private EventTime inputEventTime() {

        System.out.println("Введите дату в формате часы/минуты-дни/месяцы/года");
        SimpleDateFormat s = new SimpleDateFormat("H/m-dd/MM/yyyy");


        Date y = TimeManager.getInstance().inputDate(s);
        if(y == null) return  null;

        return new EventTime(new HashDate(y));
    }
}
