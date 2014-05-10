/** 
 * Carmen St. Jean
 * Spring 2008 CS 415 Lab 5 - February 14, 2008
 * Lab5.java:
 *
 * Uses the Eyeball class to display eyeballs.
 * 
 */

// ------------------- imports -----------------------------------------
import wheelsunh.users.*;
import java.awt.Color;

public class Lab5 extends Frame
{
    //---------------- instance variables ------------------------------
    private Eyeball eye;
    
    // -----------------------------------------------------------------
    /** Constructor for the Lab5 class.
     */
    public Lab5( )
    {
        eye = new Eyeball( );
        eye.setLocation( 100, 100 );
        eye.setColor( Color.GREEN );
        eye.lookMad( );
        eye.lookNormal( );
    } 
    
    // -----------------------------------------------------------------
    /** main program just invokes the class constructor.
     */
    public static void main(String[] args)
    {
        Lab5 app = new Lab5();
    }
}//End of Class Lab5
