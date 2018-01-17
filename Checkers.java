/*
 * SAGe
 * Checkers Class
 */
import java.util.*;
import becker.robots.*;
import java.awt.Color.*;
public class Checkers extends Robot
{
    //setting variables
    private int street ,avenue;
    public Checkers(City b, int r, int c, Direction d)
    {
        super(b, r, c, d);
        street = r;
        avenue = c;
    }
    //move extent
    public void move(String m)
    {
        boolean turning = false;
        Direction currentD = super.getDirection();
        //make a stupid method because my advanced thinking did not work
        Direction turn = Direction.NORTH;
        do 
        {
            if (m.equals("left"))
            {
                turn = Direction.WEST;
            }
            if (m.equals("right"))
            {
                turn = Direction.EAST;
            }
            if (m.equals("up"))
            {
                turn = Direction.NORTH;
            }
            if (m.equals("down"))
            {
                turn = Direction.SOUTH;
            }
            super.turnLeft(); 
            currentD = super.getDirection();
            if (currentD.equals(turn))
            {
                turning = true;
            }
        }while (turning == false);
        super.move();
    }
    public Checkers teleport(City board, int row, int col, int countR, int countC)
    {
        if (row + countR == -1 || row + countR == 4)
        {
            return new Checkers(board, row + countR, col, Direction.NORTH);
        }
        if (col + countC == -1 || col + countC == 4)
        {
            return new Checkers(board, row, col + countC, Direction.NORTH);
        }
        return new Checkers(board, row + countR, col, Direction.NORTH);
    }
}
