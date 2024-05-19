import AOP.NearMapCacheAspect;
import Command.CreateNewNoteCommand;
import Command.DeleteNoteCommand;
import Command.FinishProgramCommand;
import Command.PrintUpcomingNotesCommand;
import Event.DependencyManager;
import Event.IProxyBuilder;
import Notebook.NotebookSystem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import Menu.Menu;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(NearMapCacheAspect.class);
        NotebookSystem notebook = ctx.getBean("system", NotebookSystem.class);
        notebook.startMainLoop();

        ctx.close();
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
    //aop
}