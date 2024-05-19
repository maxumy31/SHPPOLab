package Handlers;

public class IntHandler implements IIntHandler
{
    IIntHandler next;
    @Override
    public void setHandler(IIntHandler h)
    {
        next = h;
    }

    @Override
    public Status handle(int i)
    {
        if(next != null)return next.handle(i);
        return IIntHandler.Status.OK;
    }
}
