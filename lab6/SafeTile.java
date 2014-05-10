/**
 * Carmen St. Jean
 * CS 415 - Spring 2008
 * SafeTile.java - Lab 4 
 * 
 * @author rdb
 */
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class SafeTile extends Tile
{
   //------------------------ instance variables --------------------------
   //------------------------- Constructors -------------------------------
   /**
    * Position tile at x,y; tile fill color is white; tile frame color is 
    * gray   tile is size 25x25 
    */
   public SafeTile( int x, int y )
   {
      super( x, y );
   }
   
   //------------------------- mouseClicked ------------------------------
   /**
    * make tile fill black on mouse click event
    */
   public void mouseClicked( MouseEvent e )
   {
      this.setFillColor( Color.BLACK );
   }

   //--------------------------- main -----------------------------------
   /*
    * Unit test method for SafeTile class
    */
   public static void main( String args[] )
   {
      // Frame f = new Frame( );
      // SafeTile app = new SafeTile( 100, 100 );
   }
}