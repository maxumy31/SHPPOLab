package Handlers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LenientHandler extends StringHandler
{
    SimpleDateFormat format;
    public LenientHandler(SimpleDateFormat s)
    {
        format = s;
        format.setLenient(false);
    }
    @Override
    public Status handle(String s)
    {
        try
        {
            Date y = format.parse(s);
        }
        catch (ParseException e)
        {
            return Status.INVALID_DATE;
        }
        super.handle(s);
        return Status.OK;
    }
}
