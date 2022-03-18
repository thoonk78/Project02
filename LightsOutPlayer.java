import java.util.Random;
import java.util.Scanner;
/**
 * Write a description of class LightsOut here.
 *
 * @author Samuel Ayoade & Keith Thoong
 * @version 03/18/2022
 */
public class LightsOut extends DuoPlay
{
    boolean[][] board;
    int testing;
    Scanner scnr = new Scanner (System.in);
    /**
     * LightsOut Constructor: Sets player objects and board size, and checks if valid board size is entered and creates new board
     *
     * @param player1: player1 object
     * @param player2: player2 Object
     * @param boardSize: takes in board size
     */
    public LightsOut(LightsOutPlayer player1, LightsOutPlayer player2, int boardSize){
        super((DuoplayPlayer)player1, (DuoplayPlayer)player2);

        System.out.println("What board size would you like to play on? : ");
        boardSize = scnr.nextInt();

        while(boardSize < 0)
        {
            System.out.println("The board size must be positive");
            System.out.println("What board size would you like to play on? : ");
            boardSize = scnr.nextInt();
        }

        board = new boolean [boardSize][boardSize];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++)
            {
                board[i][j] = false;   
            }
        }
        randomize(this.board);
    }

    /**
     * Method randomize: Randomly setting spots int hte board as on or off
     *
     * @param board: The game board
     */
    public void randomize(boolean[][] board){
        Random rand = new Random();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                int randomLight = rand.nextInt(2);
                if(randomLight == 0){
                    board[i][j] = false;   
                }
                else if(randomLight == 1){
                    board[i][j] = true;   
                }
            }
        }
        if(isDark())
        {
            randomize(board);   
        }
    }

    /**
     * Method press: Takes in user's valid coordinates and turns light off if its on in that spot
     *
     * @param row: users row
     * @param col: users col
     */
    public void press(int row, int col){
        while(row < 0 || row > board.length || col < 0 || col > board.length)
        {
            System.out.println("Invalid input. Please enter a row and column from the coordinates shown");

            System.out.print("row: ");
            row = scnr.nextInt();  
            System.out.print("column: ");
            col = scnr.nextInt();  
        }
        for(int i = row - 1; i <= row + 1; i++)
        {
            if(i != row && i > -1 && i < board.length && col > -1 && col < board.length)
            {
                this.board[i][col] = !this.board[i][col];   
            }
            for(int j = col - 1; j <= col + 1; j++)
            {
                if(row > -1 && row < board.length && j > -1 && j < board.length)
                {
                    this.board[row][j] = !this.board[row][j];
                }
            }
        }
    }

    /**
     * Method isDark: Checks if the light is turned on and shuts it off
     *
     * @return The return value: returns the updated status of the spot
     */
    public boolean isDark(){
        boolean isDark = true;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == true){
                    isDark = false;   
                }
            }
        }
        return isDark;
    }

    /**
     * Method toString: Prints out board 
     *
     * @return The return value: returns the board
     */
    public String toString()
    {
        String board = " ";

        for(int i = 0; i < this.board.length; i++){
            board += i;
        }

        board += "\n";
        for(int i = 0; i < this.board.length; i++){
            board += i;
            for(int j = 0; j < this.board.length; j++){
                if(this.board[i][j] == true){
                    board += "x";   
                }
                else
                {
                    board += "_";   
                }
                //board += "\n";
            }
            board += "\n";
        }

        return board;
    }

    /**
     * Method showGame: Displays game by calling toString method
     *
     */
    @Override
    public void showGame(){
        System.out.println(toString());   
    }
}
