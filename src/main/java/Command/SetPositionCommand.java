package Command;

import java.util.Scanner;

import Event.DependencyManager;
import  Event.IProxyBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetPositionCommand implements ICommand
{
    IProxyBuilder b;
    private String inputPosition()
    {
        System.out.println("Введите местоположение мероприятия");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }


    @Override
    public void execute()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        var d = ctx.getBean(DependencyManager.class);
        var b = d.getBuilder();
        b.setPosition(inputPosition());
        ctx.close();
    }

    @Override
    public void printCommand()
    {
        System.out.print("Ввести местоположение");
    }



}
