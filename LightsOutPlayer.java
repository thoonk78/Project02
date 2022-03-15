import java.util.Scanner;
/**
 * Write a description of class LightsOutPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class LightsOutPlayer extends DuoplayPlayer
{
    LightsOutPlayer(String playerName){
        super (playerName);
    }
    //@override
    public GameState move(DuoPlay GameState){
        GameState state = GameState.IN_PROGRESS;
        Scanner scnr = new Scanner(System.in);
        if(GameState == GameState.IN_PROGRESS){
            int row = scnr.nextInt();
            int col = scnr.nextInt();
        }
    }
}
