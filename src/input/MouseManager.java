package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Class to record the input from the mouse.
 * <p>
 * Implements the MouseListener and MouseMotionListener interfaces
 */
public class MouseManager implements MouseListener, MouseMotionListener {
    /**
     * Boolean to record if the right or left mouse buttons have been clicked or not
     */
    private boolean rightClicked, leftClicked;

    /**
     * integers to store the position of the mouseX and mouseY
     */
    private int mouseX,mouseY;

    /**
     * Gets whether or not the right mouse button has been clicked.
     * <p>
     * Sets a temp boolean to rightClicked, then sets rightClicked to false.
     * This is to get only one return of true per mouse click instead of several
     * @return rightClicked variable
     */
    public boolean isRightClicked() {
        boolean temp = rightClicked;
        rightClicked = false;
        return temp;
    }
    /**
     * Gets whether or not the left mouse button has been clicked.
     * <p>
     * Sets a temp boolean to leftClicked, then sets leftClicked to false.
     * This is to get only one return of true per mouse click instead of several
     * @return leftClicked variable
     */
    public boolean isLeftClicked() {
        boolean temp = leftClicked;
        leftClicked = false;
        return temp;

    }

    /**
     * Gets the position of the mouse on the x axis
     * @return mouseX
     */
    public int getMouseX() {
        return mouseX;
    }

    /**
     * Gets the position of the mouse on the y axis
     * @return mouseY
     */
    public int getMouseY() {
        return mouseY;
    }

    /**
     * Just initializes the mouseX and mouseY positions to 0
     * to avoid null pointer exceptions
     */
    public MouseManager(){
        mouseX = 0;
        mouseY = 0;
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    /**
     * Every time the mouse is moved, the mouseX and mouseY variables are updated to their new values.
     */
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

    }
    @Override
    /**
     * Every time the mouse is pressed and released, it sets either rightClicked or leftClicked
     * to true depending on which one was pressed. If it was neither, nothing happens.
     */
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftClicked = true;
        if(e.getButton() == MouseEvent.BUTTON2)
            rightClicked = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


}
