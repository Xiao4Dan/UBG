import java.util.*;
public class Move
{
    static String target;
    static int num;
    static int choice;
    public static int askP1()
    {
        Scanner in = new Scanner(System.in);//Do we still need comments on scanner?
        do{
            System.out.println("Player 1: Which checker do you want to move?");
            target = in.nextLine();
        }while((!target.equals("A1")) && (!target.equals("A2")) && (!target.equals("A3")) && (!target.equals("A4")));
        switch (target)
        {
            case "A1":
            num = 0;
            break;
            case "A2":
            num = 1;
            break;
            case "A3":
            num = 2;
            break;
            case "A4":
            num = 3;
            break;
        }
        return num;
    }

    public static int askP2()
    {
        Scanner in = new Scanner(System.in);//Do we still need comments on scanner?
        do{
            System.out.println("Player 2: Which checker do you want to move?");
            target = in.nextLine();
        }while((!target.equals("B1")) && (!target.equals("B2")) && (!target.equals("B3")) && (!target.equals("B4")));
        switch (target)
        {
            case "B1":
            num = 0;
            break;
            case "B2":
            num = 1;
            break;
            case "B3":
            num = 2;
            break;
            case "B4":
            num = 3;
            break;
        }
        return num;
    }
}
