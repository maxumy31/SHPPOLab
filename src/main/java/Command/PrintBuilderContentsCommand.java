package Command;

import Event.EventBuilder;
import Event.IProxyBuilder;

public class PrintBuilderContentsCommand implements ICommand
{
    IProxyBuilder b;

    public PrintBuilderContentsCommand(IProxyBuilder build)
    {
      b = build;
    }
    @Override
    public void execute()
    {
        b.printInput();
    }

    @Override
    public void printCommand()
    {
        System.out.print("Вывести введенные данные.");
    }
}
