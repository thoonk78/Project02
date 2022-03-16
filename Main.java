
/**
 * Write a description of class Project02Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String args[]){
        LightsOutPlayer p1 = new LightsOutPlayer("player 1");
        LightsOutPlayer p2 = new LightsOutPlayer("player 2");
        LightsOut myGame = new LightsOut(p1, p2, 4);
        
        myGame.play();
    }
}
