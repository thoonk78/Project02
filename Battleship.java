import java.util.Scanner;
/**
 * Write a description of class Battleship here.
 *
 * @author ()
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
    char[][] p1BoardSeen;
    char[][] p2Board;
    char[][] p2BoardSeen;
    char[][] currBoard;
    int[][] boatNum;
    boolean isPlayer1Turn;
    public Battleship(BattleshipPlayer player1, BattleshipPlayer player2, int size){
        super((DuoplayPlayer)player1, (DuoplayPlayer)player2);
        isPlayer1Turn = true;
        int[][] boatNum = {{5},{4},{3,3},{2}};
        this.boatNum = boatNum;
        /*
        System.out.println("What board size would you like to play on? : ");
        size = scnr.nextInt();
        */
        
        while(size < 0)
        {
            System.out.println("The board size must be positive");
            System.out.println("What board size would you like to play on? : ");
            size = scnr.nextInt();
        }
        
        this.p1Board = new char [size][size];
        this.p2Board = new char [size][size];
        this.p1BoardSeen = new char [size][size];
        this.p2BoardSeen = new char [size][size];
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
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        toggleTurn();
        System.out.println(super.player2.getPlayerName() + ", set up your boats. " + super.player1.getPlayerName() + ", no peeking!");
        setBoats();
        showGame(true);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        toggleTurn();
        
    }
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
                //System.out.println();
                userChoice = scnr.nextLine();
                //System.out.println();
                
                while(!(userChoice.toLowerCase().equals("yes")) && !(userChoice.toLowerCase().equals("no")))
                {
                    System.out.println("Invalid. Please enter yes or no");
                    System.out.println(userChoice);
                    userChoice = scnr.nextLine();
                }
                
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
                    }
                    System.out.print("top end column: ");
                    firstCol = scnr.nextInt();
                    while(firstCol > currBoard.length - 1 || firstCol < 0)
                    {
                        System.out.println("Invalid col. Try again.");  
                        System.out.print("top end col: ");
                        firstCol = scnr.nextInt();
                    }
                    fillBoat(firstRow, firstCol, boatNum[i][j], isHorizontal);
                }
                else
                {
                    System.out.println("Pick the coordinates for the top end of your " + boatNum[i][j] + " space boat\n");
                    System.out.print("left end row: ");
                    firstRow = scnr.nextInt();
                    System.out.print("left end column: ");
                    firstCol = scnr.nextInt();
                    fillBoat(firstRow, firstCol, boatNum[i][j], isHorizontal);
                }
            }
        }

       
        
    }
    public void fillBoat(int row, int col, int limit, boolean isHorizontal)
    {
        boolean isEmpty = lineEmpty(row, col, limit, isHorizontal);
        
        if(isEmpty == false)
        {
            System.out.println("Sorry, this boat overlaps another boat or the edge. Try again.");
            System.out.print("Enter row : ");
            row = scnr.nextInt();
            System.out.print("Enter column : ");
            col = scnr.nextInt();
            fillBoat(row, col, limit, isHorizontal);
        }
        if(isHorizontal)
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
        else
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
    public void press(int row, int col){
        //toggleTurn();
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
        //toggleTurn();
    }
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
                if(!showBoats && currBoard[i][j] == BOAT)
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
        
        //System.out.println(this.board.toString());
        return "   " + playerName + "'s board\n" + boardOut;
    }
    
    
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
    
    public void showGame(boolean showBoats)
    {
        System.out.println(toString(showBoats));
    }
    public void showGame()
    {
        System.out.println(toString(false));
    }

}
