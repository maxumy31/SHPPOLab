package Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntInput
{
    public IntInput()
    {

    }

    public int getInt()
    {
        Scanner input = new Scanner(System.in);
        int action = 0;
        try
        {
            action = input.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Введенное не является числом.");
            input.nextLine();
        }
        return action;
    }

}
