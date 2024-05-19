package Event.Time;

import java.util.Date;

public class EventInterval extends EventTime
{
    protected HashDate endDate;
    public EventInterval(HashDate start, HashDate end)
    {
        super(start);
        endDate = end;
    }

    @Override
    public String toString() {
        return super.toString() + " --- " +endDate.toLocaleString();
    }
}
