/**
 * Paddles.java
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, April 8, 2008
 * 
 * For Program9
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Point;

public class Paddle extends Rectangle
{
   //------------------------- instance variables ------------------------------
   private int xLocation, yLocation, score = 0;
   private Point lastMousePosition;
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------

   /**
    * Paddle( int x, int y )
    *    This constructor creates a paddle which is draggable.
    */
   public Paddle( int x, int y )
   {
      super( x, y );
      xLocation = x;
      yLocation = y;
      this.setSize( 12, 50 );
      this.setColor( Color.WHITE );
   }
   
   //---------------------------------------------------------------------------
   //------------------------- mutators ----------------------------------------
   
   /**
    * void gainPoint( )
    *    Adds one point to this player's score.
    */
   public void gainPoint( )
   {
      score++;
   }

   //---------------------------------------------------------------------------

   /**
    * int getScore( )
    *    Returns this player's score.
    */
   public int getScore( )
   {
      return score;
   }
   
   //---------------------------------------------------------------------------
   //------------------------- mouse methods -----------------------------------
   
   /**
    * void mousePressed( MouseEvent e )
    *    Saves the last mouse position for use in mouseDragged.
    */
   public void mousePressed( MouseEvent e )
   {
      lastMousePosition = e.getPoint();
   }

   //---------------------------------------------------------------------------

   /**
    * void mouseDragged( MouseEvent e )
    *    Allow the paddle to be dragged, but only in the y-direction.
    */
   public void mouseDragged( MouseEvent e )
   {
      Point currentPoint = e.getPoint();
      int deltaY = currentPoint.y - lastMousePosition.y;
      yLocation += deltaY;
      setLocation( xLocation, yLocation );
      lastMousePosition = currentPoint;
   }
}