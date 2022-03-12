
/**
 * Abstract class DuoplayPlayer - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class DuoplayPlayer 
{
    String playername;    

    public DuoplayPlayer(String playerName){
        getPlayerName();
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public abstract GameState move(){

    
    }

}
