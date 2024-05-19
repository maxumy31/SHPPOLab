package Handlers;

public interface IStringHandler
{
    void setHandler(IStringHandler h);
    Status handle(String s);



    enum Status
    {
        OK,
        NOT_A_NUMBER,
        INVALID_DATE,
        WRONG_DATE_INTERVAL,

    }

}
