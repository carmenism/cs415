/**
 * Carmen St. Jean
 * CS 415 - Spring 2008
 * LeftButton.java - Lab 7 
 * 
 */
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class LeftButton extends DrawButton
{
   //------------------------ instance variables --------------------------
   protected Snake snake;
   //------------------------- Constructors -------------------------------
   /**
    * Position button at x,y and saves the passed-in snake
    */
   public LeftButton( int x, int y, Snake s )
   {
      super( x, y, s );
      snake = s;
   }
   
   //------------------------- mousePressed ------------------------------
   /**
    * make button red and turn the snake left
    */
   public void mousePressed( MouseEvent e )
   {
      snake.turnLeft( );
      this.setColor( Color.RED );
   }
   
  
   //--------------------------- main -----------------------------------
   /*
    * Unit test method for LeftButton class
    */
   public static void main( String args[] )
   {
      // Frame f = new Frame( );
      // Snake snake1 = new Snake( 10, 10 );
      // LeftButton app = new LeftButton( 100, 100, snake1 );
   }
}