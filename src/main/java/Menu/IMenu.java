package Menu;

import Command.ICommand;

public interface IMenu
{

    ICommand pollAction();
    void printMenu();
}
