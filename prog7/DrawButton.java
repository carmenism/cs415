/**
 * DrawButton.java
 *    This abstract class will be used to create buttons to move a buggy with 
 *    the increment from the slider.
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

public abstract class DrawButton extends Ellipse
{
   //------------------------- instance variables ------------------------------
   private Buggy buggy;
   private Slider slider;
   private final int BUTTON_SIZE = 20;
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------
   
   /**
    * DrawButton( int x, int y, Buggy b, Slider s )
    *    This constructor creates a button at the specified screen coordinates
    *    and saves a buggy and slider.
    * 
    * x, y: define the desired location in screen coordinates
    * b: saves a buggy
    * s: saves a slider
    */
   public DrawButton( int x, int y, Buggy b, Slider s )
   {
      super( x, y );
      buggy = b;     // stores reference to peer buggy
      slider = s;
      this.setSize( BUTTON_SIZE, BUTTON_SIZE );
      this.setColor( Color.BLUE );
   }
   
   //---------------------------------------------------------------------------
   //-------------------------- mouse methods ----------------------------------

   /**
    * mousePressed
    *    Sets the color of the button to red.
    */
   public void mousePressed( MouseEvent e )
   {
      this.setColor( Color.RED );
   }
   
   //---------------------------------------------------------------------------

   /**
    * mouseReleased
    *    Sets the color of the button back to blue.
    */
   public void mouseReleased( MouseEvent e )
   {
      this.setColor( Color.BLUE );
   }
   
   //---------------------------------------------------------------------------
   // main method for testing
   public static void main( String args[] )
   {
   }
}
//---- 80 characters wide ------------------------------------------------------