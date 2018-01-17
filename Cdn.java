/*
 * SAGe
 * Save and Move Class
 */
public class Cdn
{
    //four checkers to store
    static Checkers[] tpt = new Checkers[4];
    //another four checkers to order
    static Checkers first, second, third, last;
    public Cdn(Checkers fi, Checkers se, Checkers th, Checkers la)
    {
        tpt[0] = fi;
        tpt[1] = se;
        tpt[2] = th;
        tpt[3] = la;
    }
    public static boolean Check(Cdn n)
    {
        //store the four checkers
        tpt[0] = first;
        tpt[1] = second;
        tpt[2] = third;
        tpt[3] = last;
        //==================== REORDERING ====================
        for(int a = 0; a < 4; a++)
        {
            //assign the first
            if(tpt[a].getStreet() < first.getStreet() && tpt[a].getAvenue() < first.getAvenue())
            {
                first = tpt[a];
            }
        }
        for(int d = 0; d < 4; d++)
        {              
            //assign the last
            if(tpt[d].getStreet() > first.getStreet() && tpt[d].getAvenue() > first.getAvenue())
            {
                last = tpt[d];
            }
        }
        for(int b = 0; b < 4; b++)
        {
            //assign temporary second
            if(tpt[b] != first && tpt[b] != last)
            {
                second = tpt[b];
            }
        }
        for(int c = 0; c < 4; c++)
        {
            //assign the temporary third
            if((tpt[c] != first) && (tpt[c] != last) && (tpt[c] != second))
            {
                third = tpt[c];
            }
        }
        //change the order of third and second because we don't really know who is earlier
        //temp checker for re-ordering second and third
        Checkers ha;
        if(third.getStreet() < second.getStreet())
        {
            //ummmmmmmmm i don't know how to explain
            //this is a classic switching position method
            //function is switch names, third is now called forth, and the old forth is called third
            ha = third; //temporarily store third
            third = second; //store the forth checker into third position
            second = ha; //the old third is stored in forth
        }
        else if(third.getStreet() == second.getStreet() && third.getAvenue() < second.getAvenue())
        {
            //example
            //third (a,b) forth(c,d) ha(0,0)
            ha = third; //third (a,b) forth(c,d) ha(a,b)
            third = second; //third (c,d) forth(c,d) ha(a,b)
            second = ha; //third (c,d) forth(a,b) ha(a,b)
            //then we switched third and forth!
            //magic!
        }
        //==================== CHECKING ====================
        //123
        if( ( (first.getStreet() + third.getStreet()) == second.getStreet()*2 ) && ( (first.getAvenue() + third.getAvenue()) == second.getAvenue()*2 ) )
        {
            return true; //return true
        }
        //124
        else if( ( (first.getStreet() + last.getStreet()) == second.getStreet()*2 ) && ((first.getAvenue() + last.getAvenue()) == second.getAvenue()*2 ) )
        {
            return true; //return true
        }
        //234
        else if( ((second.getStreet() + last.getStreet())== third.getStreet()*2 ) && ((second.getAvenue() + last.getAvenue())== third.getAvenue()*2 ) )
        {
            return true;//return true
        }
        //134
        else if( ((first.getStreet() + last.getStreet())== third.getStreet()*2 ) && ((first.getAvenue() + last.getAvenue())== third.getAvenue()*2 ) )
        {
            return true;//return true
        }
        else
        {
            System.out.println("No Winner");
            return false;
        }
    }
}