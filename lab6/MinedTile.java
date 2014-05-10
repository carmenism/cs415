/**
 * Carmen St. Jean
 * CS 415 - Spring 2008
 * MinedTile.java - Lab 4 
 * 
 * @author rdb
 */
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class MinedTile extends Tile
{
   //------------------------ instance variables --------------------------
   //------------------------- Constructors -------------------------------
   /**
    * Position tile at x,y; tile fill color is white; tile frame color is 
    * gray   tile is size 25x25 
    */
   public MinedTile( int x, int y )
   {
      super( x, y );
   }
   
   //------------------------- mouseClicked ------------------------------
   /**
    * make tile fill red on mouse click event
    */
   public void mouseClicked( MouseEvent e )
   {
      this.setFillColor( Color.RED );
   }
   
   //--------------------------- main -----------------------------------
   /*
    * Unit test method for MinedTile class
    */
   public static void main( String args[] )
   {
      Frame f = new Frame( );
      MinedTile app = new MinedTile( 100, 100 );
   }
}