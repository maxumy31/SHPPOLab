package Command;

import Event.DependencyManager;
import Event.EventBuilder;
import Event.IProxyBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class SetMessageCommand implements ICommand
{

    @Override
    public void execute()
    {
        String message = inputMessage();
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ctx.getBean(DependencyManager.class).getBuilder().setMessage(message);
        ctx.close();
    }

    @Override
    public void printCommand()
    {
        System.out.print("Ввести сообщение");
    }

    private String inputMessage()
    {
        System.out.println("Введите название мероприятия");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

}
