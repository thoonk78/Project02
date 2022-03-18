import java.util.Scanner;
/**
 * Write a description of class LightsOutPlayer here.
 *
 * @author Samuel Ayoade & Keith Thoong
 * @version 03/18/2002
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
        
        System.out.printf("%s's turn\n", super.getPlayerName());
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
            winningMessege();
            state = GameState.WON;
        }
        else
        {
            state = GameState.IN_PROGRESS;   
        }
        return state;
    }
    public void winningMessege()
    {
        System.out.printf("%s Won!\n", super.getPlayerName());
    }
}
