
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
    boolean isPlayer1Turn;
    public DuoPlay(DuoplayPlayer player1, DuoplayPlayer player2){
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public void play(){
        //GameState state = GameState.IN_PROGRESS;
        while(state == GameState.IN_PROGRESS){
            showGame();
            isPlayer1Turn = true;
            state = player1.move(this);
            showGame();
            isPlayer1Turn = false;
            player2.move(this);
        }
        if(isPlayer1Turn)
        {
            System.out.printf("%s Won! Better luck next time, %s\n", player1.playerName, player2.playerName);
        }
        else
        {
            System.out.printf("%s Won! Better luck next time, %s\n", player2.playerName, player1.playerName);
        }
    }
}
