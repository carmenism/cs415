/**
 * Slider.java
 *   When dragged by the mouse, the slider will change its width.  Its width
 *   determines the increment for the buggy.  With a press of the mouse, a
 *   text box appears to show width of the slider.
 *   Methods:
 *    - Mutators: setSize, updateInfo, growBy
 *    - Accessors: getIncrement
 *    - Mouse methods: mousePressed, mouseDragged, mouseReleased
 *
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, March 11, 2008
 * 
 * History:
 *   March 4, 2008 - edited for Lab10
 *   March 11, 2008 - edited for Program7 
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;

public class Slider extends Rectangle
{
   //------------------------- instance variables ------------------------------
   private TextBox peerBox;
   private int xLocation, yLocation, width;
   private final int HEIGHT = 20;
   private Point lastMousePosition;
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------

   /**
    * public Slider( int x, int y )
    *    This constructor creates a blue slider at the specified location with
    *    an initial width of 25 and height of 20 pixels.
    * 
    * x, y: define the desired location in screen coordinates
    */
   public Slider( int x, int y )
   {
      super( x, y );   // you'll need to add code after this line
      xLocation = x;
      yLocation = y;
      width = 25;
      this.setColor( Color.BLUE );
      this.setSize( width, HEIGHT );
      
      peerBox = new TextBox( "" + width );
      peerBox.setLocation( xLocation, yLocation + 30 );
      peerBox.setBorderWidth( 1 );
      peerBox.setSize( new Dimension(80, HEIGHT) );
      peerBox.hide( );
   }

   //---------------------------------------------------------------------------
   //---------------------------- mutators -------------------------------------

   /**
    * void setSize( int w, int h )
    *    This method sets the side of the slider using the setSize method in
    *    Rectangle.  After that, it updates the info of the textbox.
    * w, h: defines the width and height of the slider.
    */
   public void setSize( int w, int h )
   {
      super.setSize( w, h );  // you'll need to add code after this line
      width = w;
      this.updateInfo( );
   }

   //---------------------------------------------------------------------------

   /**
    * void update( )
    *    This method updates the info in the textbox if it is not null.  The
    *    textbox reveals the width of the slider.
    */
   private void updateInfo( )
   {
      if( peerBox != null )
      {
         peerBox.setText( "" + width );
      }
   }
      
   //---------------------------------------------------------------------------

   /**
    * void growBy( int deltaX )
    *    This method uses the deltaX (from the mouseDragged method) to increase
    *    (or decrease) the width, which is then passed on to the setSize method.
    *
    * deltaX: defines the change to the width
    */
   private void growBy( int deltaX )
   {
      width += deltaX;
      this.setSize( width, HEIGHT );
      // this.updateInfo( );
   }
   
   //---------------------------------------------------------------------------
   //---------------------------- accessors ------------------------------------

   /**
    * int getIncrement( )
    *    Returns the width of the slider.  Used by the buttons to determine the
    *    increment for movement.
    */
   public int getIncrement( )
   {
      return width;
   }

   //---------------------------------------------------------------------------
   //-------------------------- mouse methods ----------------------------------

   /**
    * mousePressed
    *    Turns the slider red and reveals the textbox.  Also saves the mouse
    *    position for the mouseDragged method.
    */
   public void mousePressed( MouseEvent e )
   {
      // Add your code here
      lastMousePosition = e.getPoint();
      this.setColor( Color.RED );
      if( peerBox != null )
      {
         peerBox.show( );
      }
   }

   //---------------------------------------------------------------------------

   /**
    * mouseDragged
    *    Saves the delta the mouse moves (in the x-direction) so the slider can
    *    change the same delta in width.  Uses the mouse position saved in
    *    mousePressed.
    */
   public void mouseDragged( MouseEvent e )
   {
      // Add your code here
      Point currentPoint = e.getPoint();
      int deltaX = currentPoint.x - lastMousePosition.x;
      growBy( deltaX );
      lastMousePosition = currentPoint;
   }

   //---------------------------------------------------------------------------

   /**
    * mouseReleased
    *    This method hides the box and turns the slider back to blue.
    */
   public void mouseReleased( MouseEvent e )
   {
      this.setColor( Color.BLUE );
      if( peerBox != null )
      {
         peerBox.hide( );
      }
   }

   //---------------------------------------------------------------------------
   // main method for testing
   public static void main( String args[] )
   {
      Frame f = new Frame();
      Slider pe1 = new Slider( 400, 10 );
   }
}
//---- 80 characters wide ------------------------------------------------------