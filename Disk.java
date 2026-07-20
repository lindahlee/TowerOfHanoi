/**
 * 
 */
package towerofhanoi;

import student.TestableRandom;
import cs2.Shape;
import java.awt.Color;
// Virginia Tech Honor Code Pledge:
//
// Project 3
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- linda (lindahlee)

/**
 * this is the Disk class
 * 
 * @author linda
 * @version 2024.03.01
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * this the constructor
     * 
     * @param width
     *            which is an int
     */
    public Disk(int width)

    {
        super(0, 0, width, 15);
        TestableRandom randomGen = new TestableRandom();
        int int1 = randomGen.nextInt(250);
        int int2 = randomGen.nextInt(250);
        int int3 = randomGen.nextInt(250);
        Color color = new Color(int1, int2, int3);
        this.setBackgroundColor(color);

    }


    /**
     * this is the compareTo()
     * 
     * @param otherDisk
     *            which is another disk
     * @return get width
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        else {
            if (this.getWidth() < otherDisk.getWidth()) {
                return -1;
            }
            if (this.getWidth() > otherDisk.getWidth()) {
                return 1;
            }
            else {
                return 0;
            }

        }

    }


    /**
     * this is the toString()
     * 
     * @return integer get width
     */

    public String toString() {
        return Integer.toString(this.getWidth());
    }


    /**
     * this is the equals()
     * 
     * @param obj
     *            is the object
     * @return false
     */

    public boolean equals(Object obj)

    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return (obj.getClass().equals(this.getClass())) && (this
            .getWidth() == ((Disk)obj).getWidth());

    }
}
