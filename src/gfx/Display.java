package gfx;

import javax.swing.*;
import java.awt.*;

/**
 * Class that stores the JFrame anc canvas for the Display of the game
 */
public class Display {
    /**
     * JFrame object to hold the canvas
     */
    private JFrame frame;

    /**
     * Canvas object to be able to draw on the window
     */
    private Canvas canvas;

    /**
     * Width and height variable to store the size of the window
     */
    private int width;
    private int height;

    /**
     * Constructor of the Display class. Takes in a width, height, and title.
     * <p>
     *     Instantiates the JFrame with a title of the inputted title parameter.
     *     Instantiates the canvas object.
     * <p>
     *     Calls the initDisplay() method
     *
     *
     * @param width width of the JFrame and canvas
     * @param height height of the JFrame and canvas
     * @param title Title to be displayed at the top of the JFrame
     */
    public Display(int width, int height, String title){
        this.width = width;
        this.height = height;
        frame = new JFrame(title);
        canvas = new Canvas();
        initDisplay();

    }

    /**
     * Sets the size of the JFrame and the Canvas. Initializes other features of the JFrame
     * and canvas such as location and visibility.
     * <p>
     * Adds the canvas to the frame and packs the frame
     */
    public void initDisplay(){
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setPreferredSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();

    }

    /**
     * Gets the JFrame object
     * @return Display windowss frame object
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Gets the Canvas object
     * @return Display window's canvas object
     */
    public Canvas getCanvas() {
        return canvas;
    }
}
