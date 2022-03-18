import java.util.Scanner;
/**
 * Abstract class DuoplayPlayer - write a description of the class here
 *
 * @author Samuel Ayoade & Keith Thoong
 * @version 03/18/2022
 */
public abstract class DuoplayPlayer 
{
    String playerName;
    boolean isTurn;
    
    
    /**
     * DuoplayPlayer Constructor: Sets player name
     *
     * @param playerName: player's name
     */
    public DuoplayPlayer(String playerName){
        this.playerName = playerName;
        this.isTurn = false;
    }

    /**
     * Method getPlayerName: Get's player's name
     *
     * @return The return value: The players name
     */
    public String getPlayerName(){
        return this.playerName;
    }
    
    /**
     * Method move: While game state is in progress it prompts players for row and column then pressses the positon entered and checks if game is 
     * won or still in progress.
     *
     * @param currGame: Takes in current game
     * @return Method: returns game state
     */
    public abstract GameState move(DuoPlay player);
    
    
    

}
