package Handlers;

public class BiggerIntHandler extends IntHandler
{
    int bigger;
    public BiggerIntHandler(int i)
    {
        bigger = i;
    }

    @Override
    public Status handle(int i)
    {
        if(i < bigger)
            return Status.TOO_SMALL_NUMBER;
        return super.handle(i);
    }
}
