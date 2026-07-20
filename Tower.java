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
/**
 * this is the Tower class
 * 
 * @author linda
 * @version 2024.03.01
 */
public class Tower extends LinkedStack<Disk> {
    private Position position;

    /**
     * this is the Tower constructor
     * 
     * @param position
     *            is the position
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * this is the position()
     * 
     * @return position
     */
    public Position position() {
        return position;
    }


    /**
     * this is the push()
     * 
     * @param disk
     *            is the disk
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty() || this.peek().getWidth() > disk.getWidth()) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }

    }

}
