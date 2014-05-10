/** 
 * Lab4.java:
 *
 * CS415 demo
 * 
 */

// ------------------- imports -----------------------------------------
import wheelsunh.users.*;
import java.awt.Color;

public class Lab4 extends Frame
{
    //---------------- instance variables ------------------------------
    private Ellipse circle;
    private Target target, target1, target2, target3;
    
    // -----------------------------------------------------------------
    /** Constructor for the Lab4 class.
     */
    public Lab4( )
    {
        circle = new Ellipse( );
        
        target = new Target( );
        
        target1 = new Target( 400, 400 );
        target1.setLocation( 400, 100 ); 
        
        target2 = new Target( );
        target2.setLocation( 500, 200 );
        
        target3 = new Target( 100, 100 );
        target3.setLocation( 100, 450 );
    } 
    
    // -----------------------------------------------------------------
    /** main program just invokes the class constructor.
     */
    public static void main(String[] args)
    {
        Lab4 app = new Lab4();
    }
}//End of Class Lab4
