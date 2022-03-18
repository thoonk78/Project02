import java.util.Scanner;
/**
 * Lets user select game and runs the selelcted game.
 *
 * @author Samuel Ayoade & Keith Thoong
 * @version 03/18/2022
 */
public class Main
{
    public static void main(String args[]){
        System.out.println("////////////////////////////////\n" + "       Game Selection Menu       \n" + "////////////////////////////////");
        
        gameSelect();

    }
    
    
    /**
     * Method Prompts for palyers names and runs user selceted game
     *
     */
    public static void gameSelect()
    {
        System.out.printf("%-33s\nWhat game would you like to play?: ", "[Lights Out] [Battleship]");
        Scanner scnr = new Scanner(System.in);
        String gameSelection = scnr.nextLine();
        
        if(gameSelection.toLowerCase().equals("lights out"))
        {
            String p1Name;
            String p2Name;
            
            System.out.println("Enter player 1's name: ");
            p1Name = scnr.nextLine();
            System.out.println("Enter player 2's name: ");
            p2Name = scnr.nextLine();
            
            LightsOutPlayer p1 = new LightsOutPlayer(p1Name);
            LightsOutPlayer p2 = new LightsOutPlayer(p2Name);
            LightsOut myGame = new LightsOut(p1, p2, 4);
            
            myGame.play();
        }
        else if(gameSelection.toLowerCase().equals("battleship"))
        {
            String p1Name;
            String p2Name;
            
            System.out.println("Enter player 1's name: ");
            p1Name = scnr.nextLine();
            System.out.println("Enter player 2's name: ");
            p2Name = scnr.nextLine();
            
            BattleshipPlayer p1 = new BattleshipPlayer(p1Name);
            BattleshipPlayer p2 = new BattleshipPlayer(p2Name);
            Battleship myGame = new Battleship(p1, p2, 10);
            
            myGame.play();
               
        }
        else
        {
            System.out.println("There's no game that matches that name. Please choose one of the games displayed.");   
            gameSelect();
        }
    }
}
