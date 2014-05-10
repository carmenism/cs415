/** 
 * Carmen St. Jean
 * Spring 2008 CS 415, February 19, 2008
 * Program4.java: implements methods from the Buggy class.
 */

// ------------------- imports -----------------------------------------
import wheelsunh.users.*;
import java.awt.Color;

public class Program4 extends Frame
{
    //---------------- instance variables ------------------------------
    private Buggy car1, car2, car3, car4, car5;
    
    // -----------------------------------------------------------------
    /** Constructor for the Program4 class.
     */
    public Program4( )
    {
        car1 = new Buggy( );
        car2 = new Buggy( 100, 100 );
        car3 = new Buggy( Color.PINK );
        car4 = new Buggy( 300, 0 );
        car5 = new Buggy( 400, 0 );
        
        car3.setLocation( 200, 200 );
        car4.setLocation( 300, car2.getYLocation() );
        car3.setLocation( 200, car5.getXLocation() );
        
        car2.setColor( Color.RED );
        car4.setColor( Color.CYAN );
        car5.setColor( car3.getColor() );
        
        car3.moveForward( 200 );
        car5.moveForward( -200 );
        
        car1.stealthOn( );
        car5.stealthOn( );
        car1.stealthOff( );
    }
    
    // -----------------------------------------------------------------
    /** main program just invokes the class constructor.
     */
    public static void main(String[] args)
    {
        Program4 app = new Program4();
    }
}//End of Class Program4
