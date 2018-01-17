/*
 * SAGe
 * Main Class
 * Chen Gray
 * Kim Sheeha
 * Shi Alex
 * February 19 2016
 * V.1
 */
import becker.robots.*;
import java.util.*;
import java.awt.Color;
import javax.swing.*;
import becker.robots.icons.*;
import java.awt.geom.Rectangle2D;
public class Main
{
    public static void main(String args[])
    {
        Random numGen = new Random();//Do we still need comments on randomization?
        Scanner in = new Scanner(System.in);//Do we still need comments on scanner?
        int fun = 0;//To have some fun
        int counterC;//Colom counter
        int counterR;//Rows counter
        int rows, cols;//Num rows and cols
        int turn = 0;//Turns to switch between players
        int movePlayer1 = 0;
        int movePlayer2 = 0;
        boolean regret = false;//To let user choose another checker to move
        boolean allowMove;//Moving condition, avoid checkers overlap
        boolean checkTeleport;//Teleport condition, check and call teleport procedure
        boolean win = false;//Winning condition
        String winner = "NO ONE YET";//TO declare who's the winner
        String input;//To get the input of how to move the checkers
        String userMoveCheckers = "";
        String userInput = "";
        //Comments, Sponsors, Creators
        //The following is so-called "fun"
        //In fact, they are nonsense XD
        System.out.append("GAME INITIALIZING.");
        for(int x = 0; x < 10; x++)
        {
            for(int z = 0; z < 99999999; z++)
            {
                //999999999
                //Do nothing, just to make time and let the program look awesome
            }
            System.out.append(".");
        }
        System.out.println("");
        System.out.append("IMPORTING JAVA PACKAGES.");
        for(int x = 0; x < 10; x++)
        {
            for(int z = 0; z < 99999999; z++)
            {
                //Do nothing, just to make time and let the program look awesome
            }
            System.out.append(".");
        }
        System.out.println("");
        for(int w = 0; w < 15; w++)
        {
            for(int y = 0; y < 10; y++)
            {
                fun = numGen.nextInt(2);
                System.out.append(" " + fun);
            }
            for(int z = 0; z < 10000000; z++)
            {
                //Do nothing, just to make time and let the program look awesome
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("************************************");
        System.out.println("** Welcome to our UBG board game! **");
        System.out.println("**  This program is created by:   **");
        System.out.println("** Shi Shi, Chen Chen and Kim Kim **");
        System.out.println("************************************");
        //==================== GAME START ====================
        //two arrays of checkers to differentiate each player's 4 checkers
        Board board = new Board(4,4);//4 x 4 board
        board.setBoard(board);//Set up the background of the board
        Checkers c = new Checkers(board, 5, 5, Direction.NORTH);//Temporary checker for 
        Checkers[] player1Checkers = new Checkers[4];//player 1
        Checkers[] player2Checkers = new Checkers[4];//player 2
        CircleIcon[] P1 = new CircleIcon[4];//player 1's icons
        CircleIcon[] P2 = new CircleIcon[4];//player 2's icons
        for (int i = 0; i < 4; i ++)
        {
            if (i % 2 == 1)
            {
                //player 1 checkers set up
                P1[i] = new CircleIcon(Color.BLUE, 0.8);
                player1Checkers[i] = new Checkers(board, i, 0, Direction.EAST);
                player1Checkers[i].setIcon(P1[i]);
                player1Checkers[i].getIcon().setLabel("A" + (i + 1));
                //player 2 checkers set up
                P2[i] = new CircleIcon(Color.RED, 0.8);
                player2Checkers[i] = new Checkers(board, i, 3, Direction.WEST);
                player2Checkers[i].setIcon(P2[i]);
                player2Checkers[i].getIcon().setLabel("B" + (i + 1));
            }
            else 
            {
                //player 1 checkers set up
                P1[i] = new CircleIcon(Color.BLUE, 0.8);
                player1Checkers[i] = new Checkers(board, i, 3, Direction.WEST);
                player1Checkers[i].setIcon(P1[i]);
                player1Checkers[i].getIcon().setLabel("A" + (i + 1));
                //player 2 checkers set up
                P2[i] = new CircleIcon(Color.RED, 0.8);
                player2Checkers[i] = new Checkers(board, i, 0, Direction.EAST);
                player2Checkers[i].setIcon(P2[i]);
                player2Checkers[i].getIcon().setLabel("B" + (i + 1));
            }
            SaveAndMove.saveSpot(i, 0);//Save the spots to check moving condition
            SaveAndMove.saveSpot(i, 3);//Same as above
        }
        while (win == false)
        {
            turn += 1;
            do
            {
                if (turn % 2 == 1)
                {
                    movePlayer1 = Move.askP1();
                }
                else
                {
                    movePlayer2 = Move.askP2();
                }
                do{
                    counterC = 0;
                    counterR = 0;
                    allowMove = false;
                    rows = 0;
                    cols = 0;
                    System.out.println("Player " + (2 - (turn % 2)) + ": what is your move?");
                    System.out.println("input 'left' , 'right' , 'up' , 'down', 'undo'");
                    userInput = in.nextLine();
                    switch (userInput)
                    {
                        case "left":
                        counterC -= 1;
                        break;
                        case "right":
                        counterC += 1;
                        break;
                        case "up":
                        counterR -= 1;
                        break;
                        case "down":
                        counterR += 1;
                        break;
                        case "undo":
                        regret = true;
                        break;
                    }
                    if (turn % 2 == 1)
                    {
                        rows = player1Checkers[movePlayer1].getStreet();
                        cols = player1Checkers[movePlayer1].getAvenue();
                    }
                    else if (turn % 2 == 0)
                    {
                        rows = player2Checkers[movePlayer2].getStreet();
                        cols = player2Checkers[movePlayer2].getAvenue();
                    }
                    checkTeleport = SaveAndMove.checkTeleport(rows, cols, counterR, counterC);
                    allowMove = SaveAndMove.checkAndAllow(userInput, rows, cols, counterR, counterC, checkTeleport);
                    if (allowMove == false)
                    { 
                        System.out.println("Sorry there is something over there");
                    }
                }while((!userInput.equals("left") &&  !userInput.equals("right") &&  !userInput.equals("up") && !userInput.equals("down"))  || allowMove == false);
            }while(regret == true);
            if (checkTeleport == true)
            {
                //turn and move the checkers
                if (turn % 2 == 1)
                {
                    player1Checkers[movePlayer1].move(userInput);
                    player1Checkers[movePlayer1].setIcon(P1[turn % 4]);
                    player1Checkers[movePlayer1].getIcon().setTransparency(1.0);
                    player1Checkers[movePlayer1].getIcon().setLabel(" ");
                }
                else
                //if(turn % 2 == 1)
                {
                    player2Checkers[movePlayer2].move(userInput);
                    player2Checkers[movePlayer2].setIcon(P2[turn % 4]);
                    player2Checkers[movePlayer2].getIcon().setTransparency(1.0);
                    player2Checkers[movePlayer2].getIcon().setLabel(" ");
                }
                if (rows + counterR == 4)
                {
                    c = new Checkers(board, -1, cols, Direction.SOUTH);
                }

                else if (rows + counterR == -1)
                {
                    c = new Checkers(board, 4, cols, Direction.NORTH);
                }
                else if (cols + counterC == 4)
                {
                    c = new Checkers(board, rows, -1, Direction.EAST);
                }
                else if (cols + counterC == -1)
                {
                    c = new Checkers(board, rows, 4, Direction.WEST);
                }
                if (turn % 2 == 1)
                {
                    c.setIcon(P1[turn%4]);
                    c.getIcon().setLabel(userMoveCheckers);
                    c.move();
                    player1Checkers[movePlayer1] = c;
                    c.getIcon().setTransparency(0.0);
                }
                else
                {
                    c.setIcon(P2[turn%4]);
                    c.getIcon().setLabel(userMoveCheckers);
                    c.move();
                    player2Checkers[movePlayer2] = c;
                    c.getIcon().setTransparency(0.0);
                }
            }
            else
            {
                if (turn % 2 == 1)
                {
                    //move the checkers
                    player1Checkers[movePlayer1].move(userInput);
                }
                else
                //if (turn % 2 == 0)
                {
                    //move the checkers
                    player2Checkers[movePlayer2].move(userInput);
                }
            }
            //winning condition
            switch (turn % 2)
            {
                case 1:
                Cdn player1 = new Cdn(player1Checkers[0], player1Checkers[1], player1Checkers[2],player1Checkers[3]);
                win = Cdn.Check(player1);
                break;
                case 0:
                Cdn player2 = new Cdn(player2Checkers[0], player2Checkers[1], player2Checkers[2],player2Checkers[3]);
                win = Cdn.Check(player2);
                break;
            }
        }
        //declare the winner
        if(turn % 2 == 1)
        {
            winner = "PLAYER 1";
        }
        else if(turn % 2 == 0)
        {
            winner = "PLAYER 2";
        }
        System.out.println("************************************");
        System.out.println("**        Congratulations!        **");
        System.out.println("**         " + winner + " WON!          **");
        System.out.println("************************************");
    }
}