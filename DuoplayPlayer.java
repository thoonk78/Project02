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
    public DuoplayPlayer(String playerName){
        this.playerName = playerName;
        this.isTurn = false;
    }

    public String getPlayerName(){
        return this.playerName;
    }
    
    public abstract GameState move(DuoPlay player);
    
    
    

}
