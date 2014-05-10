/**
 * Carmen St. Jean
 * CS 415 - Spring 2008
 * MoveButton.java - Lab 7 
 * 
 */
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class MoveButton extends DrawButton
{
   //------------------------ instance variables --------------------------
   protected Snake snake;
   //------------------------- Constructors -------------------------------
   /**
    * Position button at x,y and save the passed-in snake
    */
   public MoveButton( int x, int y, Snake s )
   {
      super( x, y, s );
      snake = s;
   }
   
   //------------------------- mousePressed ------------------------------
   /**
    * make button and move the snake
    */
   public void mousePressed( MouseEvent e )
   {
      snake.move( 10 );
      this.setColor( Color.RED );
   }
   
  
   //--------------------------- main -----------------------------------
   /*
    * Unit test method for MoveButton class
    */
   public static void main( String args[] )
   {
      // Frame f = new Frame( );
      // Snake snake1 = new Snake( 10, 10 );
      // MoveButton app = new MoveButton( 100, 100, snake1 );
   }
}