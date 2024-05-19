package Event;

import Event.Time.EventTime;
import Event.Time.TimeManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileWriter;
import java.io.IOException;

public class ProxyEventBuilder implements IProxyBuilder
{
    IProxyBuilder builder;
    String filePath;

    public ProxyEventBuilder()
    {
        filePath = "Logs.txt";
        write(TimeManager.getInstance().getCurrentDate().toString());
    }


    public void setNewBuilder()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        builder = ctx.getBean("eventBuilder",EventBuilder.class);
        ctx.close();
    }
    @Override
    public void setPosition(String s)
    {
        write("Set position:" + s);
        builder.setPosition(s);
    }

    @Override
    public void setMessage(String s)
    {
        write("Set message:" + s);
        builder.setMessage(s);
    }

    @Override
    public void setTime(EventTime e)
    {
        write("Set time:" + e.toString());
        builder.setTime(e);
    }

    @Override
    public IEvent create()
    {
        IEvent res = builder.create();
        if(res == null)
        {
            write("NoteEvent builder error. Note enough arguments.");
        }
        else
        {
            write("NoteEvent was created.");
        }
        return res;
    }

    public void reset()
    {
        builder.reset();
    }


    public void write(String s)
    {
        try(FileWriter writer = new FileWriter(filePath,true))
        {
            writer.write(s + "\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void printInput()
    {
        builder.printInput();
    }
}