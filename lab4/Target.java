/** 
 * Target.java:
 * 
 * Displays a simple archery target using multiple Wheels Shapes.
 * The entire target is built in a method, makeTarget.
 * 
 * makeTarget has position arguments.
 *
 * @author rdb
 * Created 9/11/07; derived from cs415 demo program, Start.java 
 */

// --------------- imports ------------------------------
import wheelsunh.users.*;
import java.awt.Color;


public class Target 
{
    //---------------- instance variables ------------------------------
    // other local variables are used to references the Wheels objects
    // used to draw the target.
    int    outerX     =  0,  outerY  = 0;
    int    level2X    = 15,  level2Y = 15;
    int    level3X    = 25,  level3Y = 25;
    int    innerX     = 30,  innerY  = 30;
    Ellipse    outer;
    Ellipse    level2;
    Ellipse    level3;
    Ellipse    inner;
    // -----------------------------------------------------------------
    /** 
     * Constructor for the Target class.
     */
    public Target( )
    {
       makeTarget( 0, 0 );
    }
    
    public Target( int x, int y )
    {
       makeTarget( x, y ); 
    }
    
    public void setLocation( int x1, int y1 )
    {
       outer.setLocation( x1 + outerX, y1 + outerY );
       level2.setLocation( x1 + level2X, y1 + level2Y );
       level3.setLocation( x1 + level3X, y1 + level3Y );
       inner.setLocation( x1 + innerX, y1 + innerY );
    }
    
    // -----------------------------------------------------------------
    /**
     * makeTarget
     * encapsulates all the Wheels components needed to draw a target.
     */
    public void makeTarget( int x, int y )
    {
       // local "constant" variables are used to define the locations of each of the
       // components

       int    outerSize  = 80;

       int    level2Size = 50; 

       int    level3Size = 30; 

       int    innerSize  = 20;
       

       
       // create the outer circle
       outer = new Ellipse( x + outerX, y + outerY );
       outer.setSize( outerSize, outerSize );
       
       // create the next inner circle
       level2 = new Ellipse( x + level2X, y + level2Y );
       level2.setSize( level2Size, level2Size );
       level2.setColor( Color.BLUE );
       
       // create the next inner circle
       level3 = new Ellipse( x + level3X, y + level3Y );
       level3.setSize( level3Size, level3Size );
       level3.setColor( Color.CYAN );
       
       // create the inner circle
       inner = new Ellipse( x + innerX, y + innerY );
       inner.setColor( Color.BLACK );
       inner.setSize( innerSize, innerSize );
    }
    
    // -----------------------------------------------------------------
    /** main program just invokes the class constructor.
     */
    public static void main(String[] args)
    {
        // Frame f = new Frame();
        Target app = new Target( );
    }
}//End of Class Target