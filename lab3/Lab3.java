/** 
 * Carmen St. Jean
 * CS 415, Spring 2008
 * 
 * Lab3.java:
 * 
 * The entire target is built in a method, makeTarget.
 * This version only uses a single circle shape to make the target.
 * 
 * @author rdb
 * 
 */

// --------------- imports ------------------------------
import wheelsunh.users.*;
import java.awt.Color;

public class Lab3 extends Frame
{
    //---------------- instance variables ------------------------------
    
    // -----------------------------------------------------------------
    /** 
     * Constructor for the Lab3 class.
     */
    public Lab3( )
    {
       makeTarget( 0, 0 );
       makeTarget( 400, 100 );
       makeTarget( 400, 400 );
    } 
    
    // -----------------------------------------------------------------
    /**
     * makeTarget
     * encapsulates all the Wheelsunh components needed to draw a target.
     */
    public void makeTarget( int x, int y )
    {
       // local "constant" variables define location/size of each circle
       int    outerX     =  0,  outerY  = 0;
       int    outerSize  = 80;
       
       // <------ Add declarations for the inner circles ----------------->
       
       // local variables to reference the Wheels objects used to draw the target.
       Ellipse    outer, inner1, inner2, inner3;
       
       // <------- Add declarations for the Wheels variables for inner circles ----->
       
       // create the outer circle
       outer = new Ellipse( x + outerX, y + outerY );
       outer.setSize( outerSize, outerSize );
       outer.setColor( Color.RED );
       
       // <------ Add code to create inner circles from largest to smallest --------->
       inner1 = new Ellipse( x + outerX + 10, y + outerY + 10 );
       inner1.setSize( outerSize - 20, outerSize - 20);
       inner1.setColor( Color.BLUE );
       
       inner2 = new Ellipse( x + outerX + 20, y + outerY + 20 );
       inner2.setSize( outerSize - 40, outerSize - 40);
       inner2.setColor( Color.GREEN );
       
       inner3 = new Ellipse( x + outerX + 30, y + outerY + 30 );
       inner3.setSize( outerSize - 60, outerSize - 60);
       inner3.setColor( Color.YELLOW );  
    }
    
    // -----------------------------------------------------------------
    /** main program just invokes the class constructor.
     */
    public static void main(String[] args)
    {
        Lab3 app = new Lab3();
    }
}//End of Class Lab3