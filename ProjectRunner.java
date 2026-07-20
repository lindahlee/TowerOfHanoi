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

/**
 * this is the ProjectRunner class
 * 
* @author linda
* @version 2024.03.01
 */
public class ProjectRunner {

    
    /**
     * this the constructor
     */
    public ProjectRunner()
    {
      //empty  
    }
    
    /**
     * this is the main()
     */
    public static void main(String[] args)
    {
        int disks = 6;
        HanoiSolver han = new HanoiSolver(disks);
        PuzzleWindow puz = new PuzzleWindow(han);
        
    }
}
