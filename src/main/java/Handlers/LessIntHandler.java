package Handlers;


public class LessIntHandler extends IntHandler
{
    int less;
    public LessIntHandler(int less)
    {
        this.less = less;
    }


    @Override
    public Status handle(int i)
    {
        if(i > less)
            return Status.TOO_BIG_NUMBER;
        super.handle(i);
        return Status.OK;
    }
}
