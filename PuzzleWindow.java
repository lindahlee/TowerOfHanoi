/**
 * 
 */
package towerofhanoi;

//Virginia Tech Honor Code Pledge:
//
//Project 3
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I
//accept the actions of those who do.
//-- linda (lindahlee)

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Puzzle window class
 *
 * @author linda
 * @version 2024.03.01
 */
public class PuzzleWindow implements Observer {
    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;

    public static final int WIDTH_FACTOR = 15;
    public static final int DISK_GAP = 0;
    public static final int DISK_HEIGHT = 15;

    /**
     * Creates a new PuzzleWindow view for a given HanoiSolver game
     * 
     * @param game
     *            the game to create a view for
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");
        window.setSize(500, 500);
        
        
        int poleHeight = 400;
        int poleY = (window.getGraphPanelHeight() / 2) - (poleHeight / 2);
        left = new Shape((200 - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        middle = new Shape(((window.getGraphPanelWidth() / 2) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        right = new Shape(((window.getGraphPanelWidth() - 200) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        
        for (int width = (game.disks() + 1) * WIDTH_FACTOR;
            width > WIDTH_FACTOR;
            width -= WIDTH_FACTOR) {
            
            Disk disk = new Disk(width);
            window.addShape(disk);
            game.getTower(Position.LEFT).push(disk);
            moveDisk(Position.LEFT);       
       }
        
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        Button solveButton = new Button("Solve");
        solveButton.onClick(this, "clickedSolve");
        window.addButton(solveButton, WindowSide.NORTH);
        
    }


    private void moveDisk(Position position) {
        Tower t = game.getTower(position);
        Disk currentDisk = t.peek(); 
        Shape currentPole;
      
        

        if (position == Position.MIDDLE) {
            currentPole = middle;
        }
        else if (position == Position.LEFT) {
            currentPole = left;
        }
        else if (position == Position.RIGHT) {
            currentPole = right;
        }
        else {
            currentPole = middle;
        }
        currentDisk.setX(currentPole.getX() + currentPole.getWidth() / 2 - currentDisk
            .getWidth() / 2);

        currentDisk.setY(currentPole.getY() + currentPole.getHeight() - game.getTower(
            position).size() * DISK_HEIGHT);
    }


    /**
     * Updates the view whenever a disk is moved in the back-end
     * 
     * @param o
     *            The observable that triggered the update
     * @param arg
     *            arguments sent by the game; should be a position
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }
    }


    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }

    /**
     * this is the sleep()
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }
  
}
