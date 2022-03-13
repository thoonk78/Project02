import java.util.Random;
/**
 * Write a description of class LightsOut here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LightsOut extends DuoPlay
{
    boolean[][] board;
    public LightsOut(){
    
    
    }
    public void randomize(int n){
        board = new boolean [n][n];
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
                else{
                    System.out.println("Wrong range dummy lmao");   
                }
            }
        }
    }
    public void press(int row, int col){
        
        if(board[row][col] == true){
            this.board[row][col] = false;
        }
        else{
            this.board[row][col] = false;
        }
        //left
        press(row, Math.max((col - 1) , 0));
        //right
        press(row, Math.max((col + 1) , 0));
        //top
        press(Math.max((row - 1), 0), col);
        //bottom
        press(Math.max((row + 1), 0), col);
        
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
                board += "\n";
            }
        }
        
        System.out.println(this.board.toString());
        return board;
    }
    @Override
    public void showGame(){
        System.out.println(toString());   
    }
}
