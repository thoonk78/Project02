import java.util.Scanner;
/**
 * Carries out operations of the Battleship game
 *
 * @author Keith Thoong, Samuel Ayoade
 * @version (a version number or a date)
 */
public class Battleship extends DuoPlay
{
    final char WATER = '~';
    final char BOAT = '#';
    final char HIT = 'X';
    final char MISS = 'O';
    
    Scanner scnr = new Scanner (System.in);
    char[][] p1Board;
    char[][] p2Board;
    char[][] currBoard;
    int[][] boatNum;
    boolean isPlayer1Turn;
    /**
     * Battleship game constructor
     * 
     * @param player1 the first player
     * @param player2 the second player
     * @param size the size of the board
     */
    public Battleship(BattleshipPlayer player1, BattleshipPlayer player2, int size){
        super((DuoplayPlayer)player1, (DuoplayPlayer)player2);
        isPlayer1Turn = true;
        this.boatNum = new int[][]{{5},{4},{3,3},{2}};
        
        while(size < 0)
        {
            System.out.println("The board size must be positive");
            System.out.println("What board size would you like to play on? : ");
            size = scnr.nextInt();
            scnr.nextLine();
        }
        
        this.p1Board = new char [size][size];
        this.p2Board = new char [size][size];
        this.currBoard = p1Board;
        
        for(int i = 0; i < p1Board.length; i++){
            for(int j = 0; j < p1Board[i].length; j++)
            {
                p1Board[i][j] = WATER;
                p2Board[i][j] = WATER;
            }
        }
        
        System.out.println(super.player1.getPlayerName() + ", set up your boats. " + super.player2.getPlayerName() + ", no peeking!");
        setBoats();
        showGame(true);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        toggleTurn();
        System.out.println(super.player2.getPlayerName() + ", set up your boats. " + super.player1.getPlayerName() + ", no peeking!");
        setBoats();
        showGame(true);
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        toggleTurn();
        
    }
    /**
     * Sets the boats on the player's board
     */
    public void setBoats()
    {
        showGame();
        boolean isHorizontal = true;
        int firstRow;
        int firstCol;
        String userChoice;
        
        for(int i = 0; i < boatNum.length; i++)
        {
            for(int j = 0; j < boatNum[i].length; j++)
            {
                System.out.print("Do you want your boat to be horizontal? : ");
                userChoice = scnr.nextLine();
                
                //Checks if user input is invalid and prompts user to enter inputs again if invalid
                while(!(userChoice.toLowerCase().equals("yes")) && !(userChoice.toLowerCase().equals("no")))
                {
                    System.out.println("Invalid. Please enter yes or no");
                    System.out.println(userChoice);
                    userChoice = scnr.nextLine();
                }
                //Checks if user wants to place a boat horizontally or vertically
                if((userChoice.toLowerCase()).equals("yes"))
                {
                    isHorizontal = true;   
                }
                else if((userChoice.toLowerCase()).equals("no"))
                {
                    isHorizontal = false;   
                }                
                if(isHorizontal)
                {
                    System.out.println("Pick the coordinates for the left end of your " + boatNum[i][j] + " space boat\n");
                    System.out.print("top end row: ");
                    firstRow = scnr.nextInt();
                    while(firstRow > currBoard.length - 1 || firstRow < 0)
                    {
                        System.out.println("Invalid row. Try again.");  
                        System.out.print("top end row: ");
                        firstRow = scnr.nextInt();
                        scnr.nextLine();
                    }
                    System.out.print("top end column: ");
                    firstCol = scnr.nextInt();
                    while(firstCol > currBoard.length - 1 || firstCol < 0)
                    {
                        System.out.println("Invalid col. Try again.");  
                        System.out.print("top end col: ");
                        firstCol = scnr.nextInt();
                        scnr.nextLine();
                    }
                    fillBoat(firstRow, firstCol, boatNum[i][j], isHorizontal);
                }
                else
                {
                    System.out.println("Pick the coordinates for the top end of your " + boatNum[i][j] + " space boat\n");
                    System.out.print("left end row: ");
                    firstRow = scnr.nextInt();
                    scnr.nextLine();
                    System.out.print("left end column: ");
                    firstCol = scnr.nextInt();
                    scnr.nextLine();
                    fillBoat(firstRow, firstCol, boatNum[i][j], isHorizontal);
                }
            }
        }

       
        
    }
    /**
     * Fills the rest of the boat to its size
     * 
     * @param row the row of the first point of the boat
     * @param col the column of the first point of the boat
     */
    public void fillBoat(int row, int col, int limit, boolean isHorizontal)
    {
        boolean isEmpty = lineEmpty(row, col, limit, isHorizontal);
        //prompts user to enter positions again if boat overlaps
        if(isEmpty == false)
        {
            System.out.println("Sorry, this boat overlaps another boat or the edge. Try again.");
            System.out.print("Enter row : ");
            row = scnr.nextInt();
            System.out.print("Enter column : ");
            col = scnr.nextInt();
            fillBoat(row, col, limit, isHorizontal);
        }
        if(isHorizontal)//fills boat by size horizontally
        {
            if(isEmpty)
            {
                for(int i = 0; i < limit; i++)
                {
                    if(col + i < currBoard.length)
                    {
                        currBoard[row][col + i] = BOAT;
                    }
                }
            }
        }
        else//fills boat by size vertically
        {
            if(isEmpty)
            {
                for(int i = 0; i < limit; i++)
                {
                    if(row + i < currBoard.length)
                    {
                        currBoard[row + i][col] = BOAT;
                    }
                }
            }
        }
        showGame(true);
        System.out.println("\n");
    }
    /**
     * Checks if the boat overlaps with another boat or the board border
     */
    public boolean lineEmpty(int row, int col, int limit, boolean isHorizontal)
    {
        boolean lineEmpty = true;
            if(isHorizontal)
        {
            for(int i = 0; i < limit; i++)
            {
                if(col + i < currBoard.length)
                {
                    if(currBoard[row][col + i] == BOAT)
                    {
                        lineEmpty = false;   
                    }
                }
                else
                {
                    lineEmpty = false;   
                }
            }
        }
        else
        {
            for(int i = 0; i < limit; i++)
            {
                if(row + i < currBoard.length)
                {
                    if(currBoard[row + i][col] == BOAT)
                    {
                        lineEmpty = false;   
                    }
                }
                else
                {
                    lineEmpty = false;   
                }
            }
        }
        return lineEmpty;
        
    }
    /**
     * Checks if the player's guess is a hit or a miss
     * 
     * @param row the row of the position to strike
     * @param col the column of the position to strike
     */
    public void press(int row, int col){
        while(row < 0 || row > currBoard.length - 1 || col < 0 || col > currBoard.length - 1)
        {
            System.out.println("Invalid input. Please enter a row and column from the coordinates shown");
            
            System.out.print("row: ");
            row = scnr.nextInt();  
            System.out.print("column: ");
            col = scnr.nextInt();  
        }
        if(currBoard[row][col] == BOAT)
        {
            currBoard[row][col] = HIT;   
            System.out.println("Hit!\n\n");
        }
        else if(currBoard[row][col] == WATER)
        {
            currBoard[row][col] = MISS;   
            System.out.println("Miss!\n\n");
        }
    }
    /**
     * Toggles the board that the player is trying to strike on
     */
    public void toggleTurn()
    {
        isPlayer1Turn = !isPlayer1Turn;
        
        if(isPlayer1Turn)
        {
            currBoard = p1Board;            
        }
        else
        {
            currBoard = p2Board;   
        }
    }
    /**
     * Retruns the String formatted board
     * 
     * @param showBoats declares if the boat positions should be shown
     * @return the String formatted board
     */
    public String toString(boolean showBoats)
    {
        String playerName;
        String boardOut = "   ";
        
        if(isPlayer1Turn)
        {
            playerName = super.player1.getPlayerName();   
        }
        else
        {
            playerName = super.player2.getPlayerName();   
        }
        
        for(int i = 0; i < currBoard.length; i++){
            boardOut += String.format("%-2d ", i);
        }
        
        boardOut += "\n";
        for(int i = 0; i < currBoard.length; i++){
            boardOut += String.format("%-2d ", i);
            for(int j = 0; j < currBoard.length; j++){
                if(!showBoats && currBoard[i][j] == BOAT)//masks the boat position with water
                {
                    boardOut += String.format("%-2c ", WATER);
                }
                else
                {
                    boardOut += String.format("%-2c ", currBoard[i][j]);
                }
            }
            boardOut += "\n";
        }
        
        return "   " + playerName + "'s board\n" + boardOut;
    }
    /**
     * Checks if all boats have been hit
     * 
     * @return a boolean for if there are still boats left
     */
    public boolean noBoats(){
        boolean noBoats = true;
        for(int i = 0; i < currBoard.length; i++){
            for(int j = 0; j < currBoard[i].length / 2; j++){
                if(currBoard[i][j] == BOAT){
                    noBoats = false;   
                }
            }
        }
        super.isPlayer1Turn = !super.isPlayer1Turn;
        return noBoats;
    }
    /**
     * Prints the board
     * 
     * @param showBoats declares if the boat positions should be shown
     */
    public void showGame(boolean showBoats)
    {
        System.out.println(toString(showBoats));
    }
    /**
     * Prints the board
     */
    public void showGame()
    {
        System.out.println(toString(false));
    }

}
