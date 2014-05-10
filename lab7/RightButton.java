/**
 * Carmen St. Jean
 * CS 415 - Spring 2008
 * RightButton.java - Lab 7 
 * 
 */
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class RightButton extends DrawButton
{
   //------------------------ instance variables --------------------------
   protected Snake snake;
   //------------------------- Constructors -------------------------------
   /**
    * Position button at x,y, saves passed-in snake.
    */
   public RightButton( int x, int y, Snake s )
   {
      super( x, y, s );
      snake = s;
   }
   
   //------------------------- mousePressed ------------------------------
   /**
    * make button red and turn the snake
    */
   public void mousePressed( MouseEvent e )
   {
      snake.turnRight( );
      this.setColor( Color.RED );
   }
   
  
   //--------------------------- main -----------------------------------
   /*
    * Unit test method for RightButton class
    */
   public static void main( String args[] )
   {
      //Frame f = new Frame( );
      //Snake snake = new Snake( 10, 10 );
      //RightButton app = new RightButton( 100, 100, snake );
   }
}