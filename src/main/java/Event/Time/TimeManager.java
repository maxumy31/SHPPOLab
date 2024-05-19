package Event.Time;

import Handlers.LenientHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

//Обращается со временем
public class TimeManager
{
    Calendar calendar;
    static TimeManager instance;
    private TimeManager()
    {
        calendar = new GregorianCalendar();
    }

    public static TimeManager getInstance()
    {
        if(instance == null) instance = new TimeManager();
        return instance;
    }

    public Date getCurrentDate()
    {
        return calendar.getTime();
    }

    public int getMonthDay()
    {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getYearDay()
    {
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public Date inputDate(SimpleDateFormat s)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try
        {
            str = reader.readLine();
        }
        catch (IOException e)
        {
            return null;
        }

        LenientHandler handler = new LenientHandler(s);
        String date = str;

        switch (handler.handle(date))
        {
            case OK:
                break;
            case INVALID_DATE:
                return null;
        }
        try {
            return s.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
