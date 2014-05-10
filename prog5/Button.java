/** 
 * Button.java
 *   This class creates a button by extending ellipse.  This button will
 *   show a hidden component of its corresponding buggy.
 *   METHODS:
 *    - Mutators: mouseClicked, mousePressed, mouseReleased
 * 
 * Note: For use with Program5.java
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, February 26, 2008
 * 
 * History:
 *   23 February 2008 - created
 */

// ---------------------- imports ------------------------------------------
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class Button extends Ellipse
{
   // ------------------------ instance variables --------------------------
   protected Buggy buggy;
   private int buttonSize = 20;
   private Color buttonColor;
   // ------------------------ contructor ----------------------------------
   /**
    * Button( int x, int y, Buggy b )
    *     The constructor creates a button at the specified location
    *     ( x, y ) and saves the passed-in buggy.  The button will become
    *     the same color as the buggy.
    * x, y: desired location in screen coordinates
    * b: buggy to be associated with this button
    */
  public Button( int x, int y, Buggy b )
   {
      super( x, y );
      buggy = b;
      this.setSize( buttonSize, buttonSize );
      buttonColor = buggy.getColor( );
      this.setColor( buttonColor );
   }
   
   // ------------------------ mutators ------------------------------------
   /**
    * void mouseClicked( MouseEvent e )
    *     When the button is clicked, the hidden component of the passed-in
    *     buggy will be shown.
    */
   public void mouseClicked( MouseEvent e )
   {
      buggy.showComponent( );
   }
   
   /**
    * void mousePressed( MouseEvent e )
    *     When the mouse is pressed on the button, the button will turn
    *     black.
    */
   public void mousePressed( MouseEvent e )
   {
      this.setColor( Color.BLACK );
   }
   
   /**
    * void mouseReleasted( MouseEvent e )
    *     When the mouse is released from the button, the button will
    *     return to its original color.
    */
   public void mouseReleased( MouseEvent e )
   {
      this.setColor( buttonColor );
   } 
   
   // ----------------------------------------------------------------------
   /** main program just invokes the class constructor.
    */
   public static void main( String args[] )
   {
      Frame f = new Frame( );
      BuggyPlow buggy = new BuggyPlow( );
      Button app = new Button( 100, 100, buggy );
   }
} // End of Class Button