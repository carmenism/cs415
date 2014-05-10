/**
 * PowerRectangle.java 
 *   This class extends Rectangle to add 
 *    - a peer object (a TextBox) that will be shown
 *      on mouse down and hidden on mouse up
 *    - code display the area and circumference of the rectangle in the
 *      TextBox. They use the ShapeFunctions class methods
 *      to compute the area and circumference.
 *    - drag capability
 *   
 * 
 * @author rdb
 * 10/15/07
 * 
 * MB
 * 3/1/08
 * 
 * Edited by Carmen St. Jean, March 4, 2008
 * CS 415, Spring 2008 - Lab 10
 * 
 */
import wheelsunh.users.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;

public class PowerRectangle extends Rectangle
{
   //--------------- instance variables --------------------
   private TextBox peerBox;
   private int xLocation, yLocation, width, height, area, circumference;
   private Point lastMousePosition;
   //--------------- constructor ---------------------------
   /**
    * Constructor requires the x,y location of the rectangle
    * It must create a hidden TextBox and provide 
    * text for the box with the current area and circumference 
    * information.
    */
   public PowerRectangle( int x, int y )
   {
      super( x, y );   // you'll need to add code after this line
      xLocation = x;
      yLocation = y;
      
      peerBox = new TextBox( "A: " + area + "\nC: " + circumference );
      peerBox.setLocation( xLocation + width + 15, yLocation );
      peerBox.setBorderWidth( 1 );
      peerBox.setSize( new Dimension(80, 40) );
      peerBox.hide( );
   }

   //------------ Overridden Rectangle methods  --------------
   /**
    * setSize( int, int ) -- defines the width and height of the rectangle. 
    * It needs to be overridden, because we must also use the new information
    * to update the text field of the associated TextBox object.
    * 
    * Warning: setSize will be called by the Rectangle constructor BEFORE you have
    *          a chance to create a TextBox in the PowerRectangle constructor.
    *          You need this override so that you can update the TextBox;
    *          this code needs to use a variable that references the box object. 
    *          Hence, in this code you must only do the update if your variable that
    *          references the box is not null.
    */
   public void setSize( int w, int h )
   {
      super.setSize( w, h );  // you'll need to add code after this line
      width = w;
      height = h;
      this.updateInfo( );
   }

   //------------ utility methods --------------------------
   /**
    * updateInfo -- computes the current area and circumference of the 
    * rectangle (using methods in the ShapeFunctions class) and updates
    * the text string in the TextBox.
    * 
    * Note that the ShapeFunctions methods compute the area and circumference
    * as doubles; this class only needs to show the integer version of that,
    * so you need to coerce (or cast) the value returned from ShapeFunctions to
    * an int before assigning it to the local int variables.
    * 
    * Note: The String object you need to pass to the TextBox
    *       must be constructed from strings of text and numbers. We have
    *       yet covered this in class. If you have variables "area" and
    *       "circumference" with the appropriate values, you can create a
    *       String to give to TextBox with the following line:
    * 
    *    String message = "A: " + area + ", C: " + circumference;
    */
   private void updateInfo()
   {
      // Add your code here
      area = height * width;
      circumference = 2 * ( height + width );
      if( peerBox != null )
      {
         peerBox.setText( "A: " + area + "\nC: " + circumference );
      }
   }
   
   //----------------------- dragging utilities -----------------------
   /**
    * moveBy( int, int ) -- update the location of the Rectangle by an encremental
    *                       amount in x and y.
    */
   private void growBy( int deltaX, int deltaY )
   {
      // Add your code here
      width += deltaX;
      height += deltaY;
      this.setSize( width, height );
      // this.updateInfo( );
      if( peerBox != null )
      {
         peerBox.setLocation( xLocation + width + 15, yLocation );
      }
   }
   
   //------------ mouseHandling methods --------------------
   /**
    * mousePressed - save the position of the mouse and the current color of the 
    * rectangle, and change the color of the rectangle to red and show the box .
    */
   public void mousePressed( MouseEvent e )
   {
      // Add your code here
      lastMousePosition = e.getPoint();
      if( peerBox != null )
      {
         peerBox.show( );
      }
   }

   /**
    * mouseDragged -- move the rectangle by the same delta that the mouse moved.
    * Use the mouse position saved in mousePressed.
    */
   public void mouseDragged( MouseEvent e )
   {
      // Add your code here
      Point currentPoint = e.getPoint();
      int deltaX = currentPoint.x - lastMousePosition.x;
      int deltaY = currentPoint.y - lastMousePosition.y;
      growBy( deltaX, deltaY );
      lastMousePosition = currentPoint;
   }

   /**
    * mouseReleased -- restore the original color  and hide the box.
    */
   public void mouseReleased( MouseEvent e )
   {
      // Add your code here
      if( peerBox != null )
      {
         peerBox.hide( );
      }
   }

  

   //------------------ main ----------------------------------
   // unit test code
   //
   public static void main( String args[] )
   {
      Frame f = new Frame();
      PowerRectangle pe1 = new PowerRectangle( 400, 10 );
      pe1.setColor( Color.BLUE );
      PowerRectangle pe2 = new PowerRectangle( 300, 100 );
      pe2.setColor( Color.GREEN ); 
      PowerRectangle pe3 = new PowerRectangle( 100, 300 );
      pe3.setColor( Color.BLACK ); 
      
      pe1.setSize( 20, 25 );
      pe2.setSize( 40, 50 );
      pe3.setSize( 10, 10 );
      
      //test the moveBy method. You won't see it move, but instead of being
      // in the upper right of the screen (400, 10), the blue rectangle will
      // be in the lower left part of the screen.
      
   //   pe1.growBy( -400, 400 );   // move it a lot to make it obvious
      
      System.out.println( "Black circumference: should be" + 40 );
      System.out.println( "Black area: should be" + 100 );     
   }
}