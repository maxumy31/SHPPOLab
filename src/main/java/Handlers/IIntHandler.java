package Handlers;

public interface IIntHandler
{
    void setHandler(IIntHandler h);
    Status handle(int i);


    enum Status
    {
        OK,
        TOO_BIG_NUMBER,
        TOO_SMALL_NUMBER

    }
}

