package game;

import boards.BasicBoard;
import boards.Board;
import gfx.Assets;
import gfx.Display;
import input.MouseManager;


import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Main game class that implements the Runnable interface
 */
public class Game implements Runnable{
    /**
     * boolean for whether or not the game is running
     */
    private boolean running = false;

    /**
     * Width, height, and title for the display window
     */
    private int width, height;
    private String title;

    /**
     * Main thread the game runs on
     */
    private Thread thread;

    /**
     * Main game board
     */
    private Board board;

    /**
     * Buffer Strategy and graphics component so drawing to the screen can happen
     */
    private BufferStrategy bs;
    private Graphics g;

    /**
     * Variable to store the display information
     */
    private Display display;

    /**
     * Mouse manager to get mouse input
     */
    private MouseManager mouseManager;

    /**
     * Handler class that is passed on to almost every other class to get information about the board
     * and about the game class;
     */
    private Handler handler;

    /**
     * Constructor for the Game class. Creates the mouseManager and instantiates
     * the width, height, and title variables.

     * @param height height of the display window
     * @param width width of the display window
     * @param title title to be displayed at the top of the window
     */
    public Game(int width, int height, String title){
        this.width = width;
        this.height = height;
        this.title = title;
        mouseManager = new MouseManager();
    }

    /**
     * Initializes the display and adds the mouseManager class to the display.
     * <p>
     * Initializes the assets to be used on the board. Also initializes the
     * handler variable and the board variable.
     * </p>
     */
    private void init(){
        display = new Display(width,height,title);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        Assets.init();
        handler = new Handler(this);
        board = new BasicBoard(handler);


    }

    /**
     * Ticks the board, which essentially makes the whole game function.
     */
    private void tick(){
        board.tick();
    }

    /**
     * Initializes the buffer strategy to the displays current buffer strategy.
     * If the display doesn't have a buffer strategy then it creates one with 3
     * buffers.
     *
     * <p>
     * Sets the graphics component to the graphics of the buffer strategy, then
     * clears the screen. Renders the board, then shows the current buffer and
     * disposes of the graphics component.
     * </p>
     */
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        //Get graphics and clear screen
        g = bs.getDrawGraphics();
        g.clearRect(0,0,width,height);

        //Draw
        board.render(g);

        //showing the current buffer and disposing of the current graphcis
        bs.show();
        g.dispose();

    }


    /**
     * Called from the game class start method when thread.Start() is called.
     * This is where the init() method is called and where the game loop is located.
     * <p>
     * Calls tick and render in the game loop while running == true. Each tick and
     * render call is made once every 1/fps seconds
     */
    public void run(){
        init();

        //Frames per second
        int fps = 30;

        //The amount of time taken for each frame
        double timePerFrame = 1000000000/fps;

        //The time difference between each frame
        double delta = 0;

        //The current time during the game loop
        long currentTime;

        //The time in nano seconds when the last loop started
        long lastFrame = System.nanoTime();


        while(running){
            currentTime = System.nanoTime();
            delta += (currentTime - lastFrame)/timePerFrame;
            lastFrame = currentTime;

            if(delta >= 1) {
                tick();
                render();
                delta--;
            }

        }
        stop();
    }

    /**
     * Method that is called when the game is intended to be started.
     * Returns if the game is already running.
     * <p>
     * If the game isn't running, it sets running to true and creates and starts a new thread
     * with the game class as the target and a name of Main.
     * </p>
     */
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this,"Main");
        thread.start();
    }

    /**
     * Method is called when the game is intended to be stopped and closed.
     * Return if the game is already not running.
     * <p>
     * Method sets running to false and thread tries to wait to die.
     * If it is interrupted it throws and error and is caught. The stack trace
     * is then printed to the console
     * </p>
     */
    public synchronized void stop(){
        if(!running)
            return;

        try {
            running = false;
            thread.join();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Gets the mouse manager
     * @return Game's mouseManager object
     */
    public MouseManager getMouseManager() {
        return mouseManager;
    }

    /**
     * Gets the display window's width
     * @return Game's int width variable
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the display window's height
     * @return Game's int height variable
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the game board
     * @return Game's board object
     */
    public Board getBoard() {
        return board;
    }

    public Graphics getG() {
        return g;
    }
}
