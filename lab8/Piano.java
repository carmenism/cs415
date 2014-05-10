/** 
 *  Piano.java: A draggable piano
 *  
 * @author CS 415 
*/
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;

public class Piano extends Rectangle implements Draggable, Faller
{ 
   //----------------- instance variables --------------------------------------
   
   //  utility variables  
   private Rectangle keys;
   private int xLocation, yLocation;
   private Point lastMousePosition;
   private int fallIncrement = 50;
   
   //------------------ constructors ---------------------------------------------
   public Piano( int x, int y ) 
   {  
      // add code here to create a very simple piano image
      super( x, y );
      xLocation = x;
      yLocation = y;
      
      this.setColor( Color.BLACK );
      this.setSize( 120, 50 );
      
      keys = new Rectangle( x + 10, y + 25 );
      keys.setColor( Color.WHITE );
      keys.setSize( 100, 20 );
      
   }
       
   //------------------ Draggable interface methods -----------------------------
   //
   public void mousePressed( MouseEvent e )
   {
      // change color of main part of piano
      this.setColor( Color.GRAY );
      // save mouse position for mouseDragged method
      lastMousePosition = e.getPoint();
      // me.getX() returns the x position of the mouse
      // me.getY() returns the y position of the mouse
      // me.getPoint() returns a Point object with x,y in it
   }
   
   public void mouseDragged( MouseEvent e )
   {
      // find delta change in x and y sinc last mouse position,
      //    update piano location by those deltas.
      // save mouse position for next event
      Point currentPoint = e.getPoint();
      int diffX = currentPoint.x - lastMousePosition.x;
      int diffY = currentPoint.y - lastMousePosition.y;
      setLocation( getLocation().x + diffX, getLocation().y + diffY );
      keys.setLocation( getLocation().x + diffX + 10, getLocation().y + diffY + 25 );
      lastMousePosition = currentPoint;
   }
   
   public void mouseReleased( MouseEvent e )
   {
      // restore main part of piano to original color
      this.setColor( Color.BLACK );
   }

   public void mouseClicked( java.awt.event.MouseEvent e )
   {
      xLocation = getXLocation();
      yLocation = getYLocation();
      
      yLocation += fallIncrement;
      this.setLocation( xLocation, yLocation );
      keys.setLocation( xLocation + 10, yLocation + 25 );
   }
   
   public void setFallIncrement( int y )
   {
      fallIncrement = y;
   }
   
   
   //---------------------------- main -----------------------------------------
   public static void main( String[] args )      
   {
      Frame f = new Frame();
      // create a Piano object for unit testing purposes
      Piano p = new Piano( 50, 50 );
   }
}