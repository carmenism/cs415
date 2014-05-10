/** 
 * Carmen St. Jean
 * Spring 2008 CS 415 Lab5 - February 14, 2008
 * Eyeball.java:
 * 
 * Displays an eyeball.  Methods include setLocation,
 * setColor, lookMad, and lookNormal.
 * 
 * Eyeball has position arguments.
 *
 * @author rdb
 * Created 9/11/07; derived from cs415 demo program, Start.java 
 */

// --------------- imports ------------------------------
import wheelsunh.users.*;
import java.awt.Color;


public class Eyeball 
{
    //---------------- instance variables ------------------------------
    // other local variables are used to references the Wheels objects
    // used to draw the eyeball.
    int    ballSize = 120,  irisSize = 60;
    int    xLocation = 0, yLocation = 0;
    Ellipse    ball, iris;
    Color irisColor;
    // -----------------------------------------------------------------
    /** 
     * Constructor for the Eyeball class.
     */
    public Eyeball( )
    {
       xLocation = 0;
       yLocation = 0;
      
       ball = new Ellipse( xLocation, yLocation );
       ball.setSize( ballSize, ballSize );
       ball.setFrameThickness( 3 );
       ball.setFrameColor( Color.BLACK );
       ball.setFillColor( Color.WHITE );
       
       iris = new Ellipse( xLocation + 30, yLocation + 30 );
       iris.setSize( irisSize, irisSize );
       iris.setFrameThickness( 18 );
       iris.setFillColor( Color.BLACK );
       iris.setFrameColor( Color.BLUE );
       irisColor = Color.BLUE;
    }
      
    public void setLocation( int x, int y )
    {
       xLocation = x;
       yLocation = y;
       ball.setLocation( x , y );
       iris.setLocation( x + 30, y + 30 );
    }
    
    public void setColor( Color c )
    {
       iris.setFrameColor( c );
       irisColor = c;
    }
    
    public void lookMad( )
    {
       iris.setFrameColor( Color.RED );
    }
    
    public void lookNormal( )
    {
       iris.setFrameColor( irisColor ); 
    }
    
    // -----------------------------------------------------------------
    /** main program just invokes the class constructor.
     */
    public static void main(String[] args)
    {
        // Frame f = new Frame();
        Eyeball app = new Eyeball( );
    }
}//End of Class Eyeball