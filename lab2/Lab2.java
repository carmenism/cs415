/**
 * Carmen St. Jean
 * CS 415, Spring 2008
 * 
 * Lab2.java:
 * Displays two multicolored targets.
 * 
 * January 29, 2008
 */

// --------------- imports ------------------------------
import wheelsunh.users.*;
import java.awt.Color;

public class Lab2 extends Frame
{
    //---------------- instance variables ------------------------------
    
    // -----------------------------------------------------------------
    /** 
     * Constructor for the Lab2 class.
     */
    public Lab2( )
    {
       // local "constant" variables define location/size of each circle
       int    outerX1     =  50,  outerY1  = 50;
       int    outerX2 = 200, outerY2 = 200;
       int    outerSize  = 80;
       
       // <------ Add declarations for the inner circles ----------------->
       
       // local variables to reference the Wheels objects used to draw the target.
       Ellipse    outer, inner1, inner2, inner3;
       
       // <------- Add declarations for the Wheels variables for inner circles ----->
       
       // create the outer circle
       outer = new Ellipse( outerX1, outerY1 );
       outer.setSize( outerSize, outerSize );
       outer.setColor( Color.RED );
       inner1 = new Ellipse( 10 + outerX1, 10 + outerY1 );
       inner1.setSize( 60, 60 );
       inner1.setColor( Color.ORANGE );
       inner2 = new Ellipse( 20 + outerX1, 20 + outerY1 );
       inner2.setSize( 40, 40 );
       inner2.setColor( Color.YELLOW );
       inner3 = new Ellipse( 30 + outerX1, 30 + outerY1 );
       inner3.setSize( 20, 20 );
       inner3.setColor( Color.GREEN );
      
       outer = new Ellipse( outerX2, outerY2 );
       outer.setSize( outerSize, outerSize );
       outer.setColor( Color.RED );
       inner1 = new Ellipse( 10 + outerX2, 10 + outerY2 );
       inner1.setSize( 60, 60 );
       inner1.setColor( Color.ORANGE );
       inner2 = new Ellipse( 20 + outerX2, 20 + outerY2 );
       inner2.setSize( 40, 40 );
       inner2.setColor( Color.YELLOW );
       inner3 = new Ellipse( 30 + outerX2, 30 + outerY2 );
       inner3.setSize( 20, 20 );
       inner3.setColor( Color.GREEN );
       
    } 
    

    
    // -----------------------------------------------------------------
    /** main program just invokes the class constructor.
     */
    public static void main(String[] args)
    {
        Lab2 app = new Lab2();
    }
}//End of Class Lab2