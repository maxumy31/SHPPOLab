import AOP.NearMapCacheAspect;
import Notebook.NotebookSystem;
import Server.NotebookServer;
import Server.ServerRunnable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        ServerRunnable r = new ServerRunnable(NotebookServer.getInstance());
        new Thread(r).start();

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        Thread serverThread = new Thread(ctx.getBean(ServerRunnable.class));

        NotebookSystem notebook = ctx.getBean("system", NotebookSystem.class);
        ctx.close();
        serverThread.start();
        notebook.startMainLoop();

        try {
            serverThread.interrupt();
        }
        catch (SecurityException e)
        {

        }




    }

    //Синглтон
    //Строитель
    //Цепочка отвественности
    //Прокси
    //Команда
    //Декоратор
    //Не больше 4 табов на строку

    //2.
    //ioc и di
    //aop(cache, logger)

    //3.
    //Задача о спящем брадобрее

}