import java.util.Random;
import java.util.Scanner;

public class MyAgent extends Agent
{
    Random r;

    /**
     * Constructs a new agent, giving it the game and telling it whether it is Red or Yellow.
     * 
     * @param game The game the agent will be playing.
     * @param iAmRed True if the agent is Red, False if the agent is Yellow.
     */
    public MyAgent(Connect4Game game, boolean iAmRed)
    {
        super(game, iAmRed);
        r = new Random();

    }

    /**
     * The move method is run every time it is this agent's turn in the game. You may assume that
     * when move() is called, the game has at least one open slot for a token, and the game has not
     * already been won.
     * 
     * By the end of the move method, the agent should have placed one token into the game at some
     * point.
     * 
     * After the move() method is called, the game engine will check to make sure the move was
     * valid. A move might be invalid if:
     * - No token was place into the game.
     * - More than one token was placed into the game.
     * - A previous token was removed from the game.
     * - The color of a previous token was changed.
     * - There are empty spaces below where the token was placed.
     * 
     * If an invalid move is made, the game engine will announce it and the game will be ended.
     * 
     */
    public void move()
    {
        //Starts in center not needed anymore
 
        // if (isThisTheFirstMove())
            // {moveOnColumn(3);
             // return; 
            // }
            int iCanWin=iCanWin();
            int theyCanWin=theyCanWin(myGame.getBoardMatrix());
 
            int bestMove=columnWithMostOpp();

            if(iCanWin !=-1)
            {
                //System.out.println("iCanWin: " + iCanWin);
                moveOnColumn(iCanWin);
            }
            else if (theyCanWin !=-1)
            {
                //System.out.println("theyCanWin: " + theyCanWin);
                moveOnColumn(theyCanWin);
            }
            else if (bestMove !=-1)
            {
                //System.out.println("best move: " + bestMove);
                moveOnColumn(bestMove );
                
            }
            else {
                //System.out.println("randomMove");
                moveOnColumn(randomMove());
                
            }
  
 
    }

    /**
     *Return if the agent has the first move 
     *not needed anymore
     *@return true if it is the first move(player starts)
     */
    public boolean isThisTheFirstMove()
    {
        int sum = 0; 
        for  (int i=0;i<myGame.getColumnCount()-1 ;i++)
        {
            if (myGame.getColumn(i).getSlot(myGame.getRowCount()-1).getIsFilled())
            {
                sum ++;
            }
        }

        return (sum==0);
    }
    /**
     *Return them column number where the possible 4s are the highest
     *
     *@return colunm ID, worst case -1 if not opportunity->random move will come
     */
    public int columnWithMostOpp()
    {
        int mostOppColumn=-1;
        int mostOpp=-1;
        for (int column=0; column<myGame.getColumnCount();column++)
        {
            //myGame.highlightSlot(getLowestEmptyIndex(myGame.getColumn(column)),column);
            if(getLowestEmptyIndex(myGame.getColumn(column))!=-1)
            {
                int opportunities=howManyWinnigOpportunity(getLowestEmptyIndex(myGame.getColumn(column)),column,myGame.getBoardMatrix(),getMyColor(),true);
                //System.out.println("Number of Opportunity at column - " + column + " -: " + opportunities);
                //if extended with check the move dont cause lose
                char[][] board= myGame.getBoardMatrix();

                //System.out.println(Arrays.deepToString(board));
                board[getLowestEmptyIndex(myGame.getColumn(column))][column]=getMyColor();
                //System.out.println(Arrays.deepToString(board));
                
                if ((mostOpp < opportunities) && (theyCanWin(board)==-1))
                {
                    //System.out.println("Column " +  column + " set to move because opportunities: " + opportunities + " > most op: " + mostOpp);
                    mostOpp=opportunities;
                    mostOppColumn = column;
                }
            }
            
        }
        return mostOppColumn;
    }
    /**
    *Return the Agent's color
    *
    *@return char of the Agent's color, 'R' if red and 'Y' if yellow
    */
    public char getMyColor()
    {
        if (iAmRed)
        {
            return 'R';
        }
        else 
        {
            return 'Y';
        }
    }
    /**
    *Return the opponent's color
    *
    *@return char of the opponent's color, 'R' if red and 'Y' if yellow
    */
    public char getTheyColor()
    {
        if (!iAmRed)
        {
            return 'R';
        }
        else 
        {
            return 'Y';
        }
    }    
    /**
    *Return the number of 4s for a slot
    *@param int columnNumber The column into belongs to slot which checked
    *@param int rowNumber The row into belongs to slot which checked
    *@param char[][] gameBoard  Board where to to check the opportunities
    *@param char checkColor  which color shall be checked
    *@param boolean checkBlank  which blank slots are counting or not
    *@return sum of the possible 4s
    */
    public int howManyWinnigOpportunity(int rowNumber, int columnNumber,char[][] gameBoard,char checkColor, boolean checkBlank)
    {
        int sum = 0;
        char blankColor= 'B';
        char ownColor=checkColor;
        char[][] board = gameBoard;
        if (!checkBlank)
        {
            board[rowNumber][columnNumber]=ownColor;
        }
        

        //check that the slot how many winning opportunities have, Blank slot or own color shall be checked
        //check the rows & columns
        for(int i=0;i<4;i++)
        {
            //check rows
             
            if((rowNumber -i) > -1 && (rowNumber + 3 - i)<myGame.getRowCount())
            {
       
                if((board[rowNumber -i][columnNumber] == ownColor|| (checkBlank && board[rowNumber -i][columnNumber] == blankColor)) && 
                    (board[rowNumber+1-i][columnNumber] == ownColor|| (checkBlank && board[rowNumber+1-i][columnNumber] == blankColor)) && 
                    (board[rowNumber+2-i][columnNumber] == ownColor|| (checkBlank && board[rowNumber+2-i][columnNumber] == blankColor)) &&
                    (board[rowNumber+3-i][columnNumber] == ownColor|| (checkBlank && board[rowNumber+3-i][columnNumber] == blankColor)))
                {

                    sum++;
                }
            }
            //check columns
            if((columnNumber -i) > -1 && (columnNumber + 3 - i)<myGame.getColumnCount())
            {
       
                if ((board[rowNumber][columnNumber + 0 - i] == ownColor || (checkBlank && board[rowNumber][columnNumber + 0 - i] == blankColor)) && 
                    (board[rowNumber][columnNumber + 1 - i] == ownColor || (checkBlank && board[rowNumber][columnNumber + 1 - i] == blankColor)) && 
                    (board[rowNumber][columnNumber + 2 - i] == ownColor || (checkBlank && board[rowNumber][columnNumber + 2 - i] == blankColor)) &&
                    (board[rowNumber][columnNumber + 3 - i] == ownColor || (checkBlank && board[rowNumber][columnNumber + 3 - i] == blankColor)))
                {
                    sum++;
                }
            } 
            //check the diagonal leftdown
            if((columnNumber + 0 - i) > -1 && (columnNumber + 3 - i)<myGame.getColumnCount() && (rowNumber + 0 - i) > -1 && (rowNumber + 3 - i)<myGame.getRowCount())
            {
       
                if ((board[rowNumber + 0 - i][columnNumber + 0 - i] == ownColor || (checkBlank && board[rowNumber + 0 - i][columnNumber + 0 - i] == blankColor)) && 
                    (board[rowNumber + 1 - i][columnNumber + 1 - i] == ownColor || (checkBlank && board[rowNumber + 1 - i][columnNumber + 1 - i] == blankColor)) && 
                    (board[rowNumber + 2 - i][columnNumber + 2 - i] == ownColor || (checkBlank && board[rowNumber + 2 - i][columnNumber + 2 - i] == blankColor)) &&
                    (board[rowNumber + 3 - i][columnNumber + 3 - i] == ownColor || (checkBlank && board[rowNumber + 3 - i][columnNumber + 3 - i] == blankColor)))
                {
                    sum++;
                }
            } 
            //check the diagonal rightdown
             
            if((columnNumber -3+i) > -1 && (columnNumber + i)<myGame.getColumnCount() && (rowNumber -i) > -1 && (rowNumber + 3 - i)<myGame.getRowCount())
            {
                
                if ((board[rowNumber + 0 - i][columnNumber - 0 + i] == ownColor || (checkBlank && board[rowNumber + 0 - i][columnNumber - 0 + i] == blankColor)) && 
                    (board[rowNumber + 1 - i][columnNumber - 1 + i] == ownColor || (checkBlank && board[rowNumber + 1 - i][columnNumber - 1 + i] == blankColor)) && 
                    (board[rowNumber + 2 - i][columnNumber - 2 + i] == ownColor || (checkBlank && board[rowNumber + 2 - i][columnNumber - 2 + i] == blankColor)) &&
                    (board[rowNumber + 3 - i][columnNumber - 3 + i] == ownColor || (checkBlank && board[rowNumber + 3 - i][columnNumber - 3 + i] == blankColor)))
                {
                    sum++;
                }
            }            

        }
        
        return sum;
    }
    /**
     * Drops a token into a particular column so that it will fall to the bottom of the column.
     * If the column is already full, nothing will change.
     * 
     * @param columnNumber The column into which to drop the token.
     */
    public void moveOnColumn(int columnNumber)
    {
        int lowestEmptySlotIndex = getLowestEmptyIndex(myGame.getColumn(columnNumber));   // Find the top empty slot in the column
        // If the column is full, lowestEmptySlot will be -1
        if (lowestEmptySlotIndex > -1)  // if the column is not full
        {
            Connect4Slot lowestEmptySlot = myGame.getColumn(columnNumber).getSlot(lowestEmptySlotIndex);  // get the slot in this column at this index
            if (iAmRed) // If the current agent is the Red player...
            {
                lowestEmptySlot.addRed(); // Place a red token into the empty slot
            }
            else // If the current agent is the Yellow player (not the Red player)...
            {
                lowestEmptySlot.addYellow(); // Place a yellow token into the empty slot
            }
        }
    }

    /**
     * Returns the index of the top empty slot in a particular column.
     * 
     * @param column The column to check.
     * @return the index of the top empty slot in a particular column; -1 if the column is already full.
     */
    public int getLowestEmptyIndex(Connect4Column column) {
        int lowestEmptySlot = -1;
        for  (int i = 0; i < column.getRowCount(); i++)
        {
            if (!column.getSlot(i).getIsFilled())
            {
                lowestEmptySlot = i;
            }
        }
        return lowestEmptySlot;
    }

    /**
     * Returns a random valid move. If your agent doesn't know what to do, making a random move
     * can allow the game to go on anyway.
     * 
     * @return a random valid move.
     */
    public int randomMove()
    {
        int i = r.nextInt(myGame.getColumnCount());
        while (getLowestEmptyIndex(myGame.getColumn(i)) == -1)
        {
            i = r.nextInt(myGame.getColumnCount());
        }
        return i;
    }

    /**
     * Returns the column that would allow the agent to win.
     * 
     * You might want your agent to check to see if it has a winning move available to it so that
     * it can go ahead and make that move. Implement this method to return what column would
     * allow the agent to win.
     *
     * @return the column that would allow the agent to win.
     */
    public int iCanWin()
    {

        for (int column=0; column<myGame.getColumnCount();column++)
        {
            //myGame.highlightSlot(getLowestEmptyIndex(myGame.getColumn(column)),column);
            if(getLowestEmptyIndex(myGame.getColumn(column))!=-1)
            {
                int winningmove=howManyWinnigOpportunity(getLowestEmptyIndex(myGame.getColumn(column)),column,myGame.getBoardMatrix(),getMyColor(),false);

                if (winningmove>0)
                {
                    
                    return column;
                }
                
            }
            
        }
        

        return -1;
    }

    /**
     * Returns the column that would allow the opponent to win.
     * 
     * You might want your agent to check to see if the opponent would have any winning moves
     * available so your agent can block them. Implement this method to return what column should
     * be blocked to prevent the opponent from winning.
     *
     * @return the column that would allow the opponent to win.
     */
    public int theyCanWin(char[][] myBoard)
    {
        char[][] board =myBoard;
        for (int column=0; column<myGame.getColumnCount();column++)
        {
            //myGame.highlightSlot(getLowestEmptyIndex(myGame.getColumn(column)),column);
            if(getLowestEmptyIndex(myGame.getColumn(column))!=-1)
            {
                int losemove=howManyWinnigOpportunity(getLowestEmptyIndex(myGame.getColumn(column)),column,board,getTheyColor(),false);

                if (losemove>0)
                {
                    
                    return column;
                }
                
            }
            
        }
        return -1;
    }

    /**
     * Returns the name of this agent.
     *
     * @return the agent's name
     */
    public String getName()
    {
        return "My Agent";
    }
    
    
}
