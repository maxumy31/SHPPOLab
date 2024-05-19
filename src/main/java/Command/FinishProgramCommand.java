package Command;

import Notebook.NotebookSystem;

public class FinishProgramCommand implements ICommand
{
    NotebookSystem notebook;
    public FinishProgramCommand()
    {
    }
    @Override
    public void execute()
    {
        notebook.endMainLoop();
    }

    public void setNotebookSystem(NotebookSystem s)
    {
        notebook = s;
    }

    @Override
    public void printCommand()
    {
        System.out.print("Прекратить работу программы");
    }
}
