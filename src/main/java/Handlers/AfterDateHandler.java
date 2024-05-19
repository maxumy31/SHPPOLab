package Handlers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AfterDateHandler extends StringHandler
{
    Date dateToBeAfter;
    SimpleDateFormat format;
    public AfterDateHandler(Date after, SimpleDateFormat f)
    {
        dateToBeAfter = after;
        format = f;
    }

    @Override
    public Status handle(String s)
    {
        Date d = null;
        try {d = format.parse(s);}
        catch (ParseException e) {throw new RuntimeException(e);}

        if(d.after(dateToBeAfter)) {
            super.handle(s);
            return Status.OK;
        }

        return  Status.WRONG_DATE_INTERVAL;
    }
}
