package Command;

import Event.*;
import Notebook.NotebookSystem;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FinishBuildingCommand implements ICommand
{
    IProxyBuilder builder;
    EventInput input;
    public FinishBuildingCommand()
    {

    }

    @Override
    public void execute()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        builder = ctx.getBean(DependencyManager.class).getBuilder();
        ctx.close();
        IEvent result = builder.create();
        if(result == null) return;
        input.endInputLoop();
    }

    public void setEventInput(EventInput i)
    {
        input = i;
    }

    public void setEventBuilder(ProxyEventBuilder b)
    {
        builder = b;
    }


    @Override
    public void printCommand()
    {
        System.out.print("Завершить сборку записи");
    }
}
