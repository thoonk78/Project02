import java.util.Scanner;
/**
 * Write a description of class LightsOutPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LightsOutPlayer extends DuoplayPlayer
{
    LightsOutPlayer(String playerName){
        super (playerName);
    }
    @Override
    public GameState move(DuoPlay currGame){
        //GameState state = GameState.IN_PROGRESS;
        Scanner scnr = new Scanner(System.in);
        GameState state = currGame.state;
        if(currGame.state == GameState.IN_PROGRESS){
            System.out.println("Enter the coordinates for the light you want to toggle");
            
            System.out.print("row : ");
            int row = scnr.nextInt();
            System.out.print("column : ");
            int col = scnr.nextInt();
            
            ((LightsOut)(currGame)).press(row, col);

        }
        if(((LightsOut)(currGame)).isDark())
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
