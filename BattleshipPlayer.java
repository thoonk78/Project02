import java.util.Scanner;
/**
 * Write a description of class BattleshipPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BattleshipPlayer extends DuoplayPlayer
{
    Scanner scnr = new Scanner(System.in);
    /**
     * Battleship player constructor
     * 
     * @param playerName the player's name
     */
    BattleshipPlayer(String playerName){
        super(playerName);
    }    
    /**
     * Carries out the player's move
     * 
     * @param currGame the current game
     */
    @Override
    public GameState move(DuoPlay currGame){
        Scanner scnr = new Scanner(System.in);
        GameState state = currGame.state;
        
        System.out.printf("%s's turn\n", super.getPlayerName());
        if(currGame.state == GameState.IN_PROGRESS){
            System.out.println("Enter the coordinates you'd like to strike");
            
            System.out.print("row : ");
            int row = scnr.nextInt();
            System.out.print("column : ");
            int col = scnr.nextInt();
            
            //Toggles the players turn
            ((Battleship)(currGame)).toggleTurn();
            ((Battleship)(currGame)).press(row, col);

        }
        if(((Battleship)(currGame)).noBoats())
        {
            state = GameState.WON;
        }
        else
        {
            state = GameState.IN_PROGRESS;   
        }
        return state;
    }
}
