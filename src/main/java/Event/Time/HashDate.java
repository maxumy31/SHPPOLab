package Event.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HashDate extends Date
{
    public HashDate(Date d)
    {
        super(d.getTime());
    }

    @Override
    public int hashCode() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(this);
        int hash = cal.get(Calendar.DAY_OF_YEAR) + cal.get(Calendar.YEAR) * 1000;
        return hash;
    }

    public boolean equals(HashDate d) {
        return d.hashCode() == this.hashCode();
    }
}
