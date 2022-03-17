import java.util.Random;
import java.util.Scanner;
/**
 * Write a description of class LightsOut here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LightsOut extends DuoPlay
{
    boolean[][] board;
    Scanner scnr = new Scanner (System.in);
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
        
        //System.out.println(this.board.toString());
        return board;
    }
    @Override
    public void showGame(){
        System.out.println(toString());   
    }
}
