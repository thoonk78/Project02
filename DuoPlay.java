
/**
 * Abstract class DuoPlayer - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class DuoPlay extends Game
{
    DuoplayPlayer player1;
    DuoplayPlayer player2;
    GameState state = GameState.IN_PROGRESS;
    public void DuoplayPlayer(DuoplayPlayer player1, DuoplayPlayer player2){
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public void play(){
        //GameState state = GameState.IN_PROGRESS;
        while(state == GameState.IN_PROGRESS){
            showGame();
            player1.move(this);
            player2.move(this);
        }
    }
}
