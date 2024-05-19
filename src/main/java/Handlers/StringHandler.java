package Handlers;

public class StringHandler implements IStringHandler
{
    IStringHandler next;
    @Override
    public void setHandler(IStringHandler h) {
        next = h;
    }

    @Override
    public Status handle(String s) {
        if(next != null)next.handle(s);
        return Status.OK;
    }

}
