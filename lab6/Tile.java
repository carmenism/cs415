/**
 * Carmen St. Jean
 * CS 415 - Spring 2008
 * Tile.java - Lab 4 
 * 
 * @author rdb
 */
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class Tile extends Rectangle
{
   //------------------------ instance variables --------------------------
   int tileSize = 25;
   //------------------------- Constructors -------------------------------
   /**
    * Position tile at x,y; tile fill color is white; tile frame color is 
    * gray   tile is size 25x25 
    */
   public Tile( int x, int y )
   {
      super( x, y );
      this.setSize( tileSize, tileSize );
      this.setFillColor( Color.WHITE );
      this.setFrameColor( Color.GRAY );
   }
   
   //------------------------- mousePressed ------------------------------
   /**
    * make tile frame red on mouse down event
    */
   public void mousePressed( MouseEvent e )
   {
      this.setFrameColor( Color.RED );
   }
   
   //-------------------------- mouseReleased ----------------------------
   /**
    * make tile frame gray on mouse up event
    */
   public void mouseReleased( MouseEvent e )
   {
      this.setFrameColor( Color.GRAY );
   }
   
   //--------------------------- main -----------------------------------
   /*
    * Unit test method for Tile class
    */
   public static void main( String args[] )
   {
      // Frame f = new Frame( );
      // Tile app = new Tile( 100, 100 );
   }
}