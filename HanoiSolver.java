/**
 * 
 */
package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// Project 3
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- linda (lindahlee)

import java.util.Observable;

/**
 * this is the HanoiSolver class
 * 
 * @author linda
 * @version 2024.03.01
 */
public class HanoiSolver extends Observable {

    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * this the constructor
     * 
     * @param disks which is an int
     */
    public HanoiSolver(int disks) {
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
        numDisks = disks;
    }


    /**
     * this is the disks()
     * 
     * @return number of disks
     */
    public int disks() {
        return numDisks;
    }


    /**
     * this is the getTower()
     * 
     * @param pos
     *            is the position
     * @return positioning
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            default:
                return middle;
        }
    }


    /**
     * this is the toString()
     * 
     * @return string
     */
    public String toString() {
        String string = "";
        string += left.toString();
        string += middle.toString();
        string += right.toString();
        return string;
    }


    /**
     * this is the move()
     * 
     * @param source
     *            is the tower source
     * @param destination
     *            is the tower destination
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * this is the solveTowers()
     * 
     * @param currentDisks
     *            is an int
     * @param startPole
     *            is a tower
     * @param tempPole
     *            is a tower
     * @param endPole
     *            is a tower
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }

    }


    /**
     * this is the solve()
     * 
     */
    public void solve() {
        solveTowers(numDisks, left, middle, right);
    }
}
