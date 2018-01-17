/*
 * SAGe
 * Checkers Class
 */
import becker.robots.*;
import java.awt.Color;
import becker.robots.icons.ShapeIcon;
import becker.robots.icons.*;
import becker.robots.icons.Icon;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
public class Board extends City
{
    private int street;
    private int avenue;
    public Board(int s, int a)
    {
        //initialise instance variables
        street = s;
        avenue = a;
    }
    public void setBoard(Board b)
    {
        //orange section
        Icon ic = new ShapeIcon(new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0),Color.ORANGE);
        //yellow section
        Icon oc = new ShapeIcon(new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0),Color.YELLOW);
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                Thing bkgd = new Thing(b,i,j);//set up new things as background
                //spread the color evenly so that it is like a chess board
                if((i+j)%2 == 0)
                {
                    bkgd.setIcon(ic);//orange icon
                }
                else if((i+j)%2 == 1)
                {
                    bkgd.setIcon(oc);//yellow icon
                }
            }
        }
    }
}