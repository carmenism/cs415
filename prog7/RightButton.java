/**
 * RightButton.java
 *    This creates a button to move a buggy to the right with the increment
 *    from the slider.
 *    Methods:
 *     - Mouse methods: mousePressed, mouseReleased
 * 
 * Based on 5.4 of the text: "Object-Oriented Programming in Java: A Graphical"
 * Approach" (Kathryn E. Sanders & Andries van Dam)
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, March 11, 2008
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Point;

public class RightButton extends DrawButton
{
   //------------------------- instance variables ------------------------------
   private Buggy buggy;
   private Slider slider;
   private final int BUTTON_SIZE = 20;
   private int increment = 10;
   private Point currentPoint, nextPoint;
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------
   
   /**
    * RightButton( int x, int y, Buggy b, Slider s )
    *    This constructor creates a button at the specified screen coordinates
    *    and saves a buggy and slider.
    * 
    * x, y: define the desired location in screen coordinates
    * b: saves a buggy
    * s: saves a slider
    */
    public RightButton( int x, int y, Buggy b, Slider s )
   {
      super( x, y, b, s );
      buggy = b;     // stores reference to peer buggy
      slider = s;
   }
   
   //---------------------------------------------------------------------------
   //-------------------------- mouse methods ----------------------------------

   /**
    * mousePressed
    *    Sets the color of the button to red and moves the buggy to the right
    *    using the increment from the slider.
    */
   public void mousePressed( MouseEvent e )
   {
      this.setColor( Color.RED );
      increment = slider.getIncrement( );
      currentPoint = buggy.getPoint( );
      nextPoint = new Point( currentPoint.x + increment,
                             currentPoint.y );
      buggy.moveTo( nextPoint );
   }
   
   //---------------------------------------------------------------------------
   // main method for testing
   public static void main( String args[] )
   {
   }
}
//---- 80 characters wide ------------------------------------------------------