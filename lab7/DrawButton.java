/**
 * Carmen St. Jean
 * CS 415 - Spring 2008
 * DrawButton.java - Lab 7 
 * 
 */
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class DrawButton extends Ellipse
{
   //------------------------ instance variables --------------------------
   protected Snake snake;
   private int buttonSize = 20;
   //------------------------- Constructors -------------------------------
   /**
    * Position tile at x,y and saves the passed-in snake
    */
   public DrawButton( int x, int y, Snake s )
   {
      super( x, y );
      snake = s;
      this.setSize( buttonSize, buttonSize );
      this.setColor( Color.BLUE );
   }
   
   //------------------------- mousePressed ------------------------------
   /**
    * make button red
    */
   public void mousePressed( MouseEvent e )
   {
      this.setColor( Color.RED );
   }
   
   //-------------------------- mouseReleased ----------------------------
   /**
    * make the button blue
    */
   public void mouseReleased( MouseEvent e )
   {
      this.setColor( Color.BLUE );
   }
   
   //--------------------------- main -----------------------------------
   /*
    * Unit test method for DrawButton class
    */
   public static void main( String args[] )
   {
      // Frame f = new Frame( );
      // Snake snake = new Snake( 10, 10 );
      // DrawButton app = new DrawButton( 100, 100, snake );
   }
}