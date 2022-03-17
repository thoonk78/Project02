import java.util.Scanner;
/**
 * Write a description of class Project02Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String args[]){
        System.out.println("////////////////////////////////\n" + "       Game Selection Menu       \n" + "////////////////////////////////");
        
        gameSelect();

    }
    public static void gameSelect()
    {
        System.out.printf("%-33s\nWhat game would you like to play?: ", "[Lights Out] [Tic Tac Toe]");
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
        else
        {
            System.out.println("There's no game that matches that name. Please choose one of the games displayed.");   
            gameSelect();
        }
    }
}
