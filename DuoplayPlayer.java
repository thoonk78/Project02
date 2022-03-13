
/**
 * Abstract class DuoplayPlayer - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
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
