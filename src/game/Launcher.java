package game;

/**
 * Class the launches the game by declaring a new Game object and starting it
 */
public class Launcher {
    /**
     * Main Method to begin the program
     * @param args
     */
    public static void main(String[] args){
        //Creates a new Game object with width, height, and title, then calls the start method
        new Game(1200,1000,"Chess Bitch!!!").start();
    }
}
