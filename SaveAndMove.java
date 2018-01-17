/*
 * SAGe
 * Save and Move Class
 */
public class SaveAndMove
{
    //private String userInput;
    static boolean[][] playerPosition = new boolean[4][4];
    //private int counterC, counterR;
    //Constructor
    public static void saveSpot(int setRow, int setCol)
    {
        playerPosition[setRow][setCol] = true;
    }
    //Checking move procedure
    public static boolean checkAndAllow(String direction, int row, int col, int countR, int countC, boolean tele)
    {
        //check if the position is taken by other checkers
        if (tele == true)
        {
            if (row + countR == 4 && playerPosition[0][col] == true)
            {
                return false;
            }
            else if (row + countR == -1 && playerPosition[3][col] == true)
            {
                return false;
            }
            else if (col + countC == 4 && playerPosition[row][0] == true)
            {
                return false;
            }
            else if (col + countC == -1 && playerPosition[row][3] == true)
            {
                return false;
            }
            else if (row + countR == 4 && playerPosition[0][col] == false)
            {
                playerPosition[row][col] = false;
                playerPosition[0][col] = true;
                return true;
            }
            else if (row + countR == -1 && playerPosition[3][col] == false)
            {
                playerPosition[row][col] = false;
                playerPosition[3][col] = true;
                return true;
            }
            else if (col + countC == 4 && playerPosition[row][0] == false)
            {
                playerPosition[row][col] = false;
                playerPosition[row][0] = true;
                return true;
            }
            else if (col + countC == -1 && playerPosition[row][3] == false)
            {
                playerPosition[row][col] = false;
                playerPosition[row][3] = true;
                return true;
            }
        }
        else{
            if (playerPosition[row + countR][col + countC] == true)
            { 
                return false;
            }

            else if (playerPosition[row + countR][col + countC] == false)
            {
                playerPosition[row][col] = false;
                playerPosition[row + countR][col + countC] = true;
            }
        }
        return true;
    }
    public static boolean checkTeleport(int row, int col, int countR, int countC)
    {
        if (row + countR == 4 || col + countC == 4 || row + countR == -1 || col + countC == -1)
        {
            return true;
        }
        return false;
    }
}