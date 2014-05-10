
/** 
 *  Comet.java: 
 *  
 * @author  CS 415  
 */
import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;

public class Comet extends Ellipse implements Faller
{ 
   //----------------- instance variables -------------------------------
    
   // utility variables and magic numbers
   private Line tail;
   private int xLocation, yLocation;
   private int fallIncrement = 50;
   
   //------------------ constructors ---------------------------------------------
   public Comet( int x, int y ) 
   {
      // draw the comet head (as this Ellipse) and tail (as a thick Line)
      super( x, y );
      xLocation = x;
      yLocation = y;
      this.setSize( 20, 20 );
      this.setColor( Color.CYAN );
      
      tail = new Line( x + 10, y + 4,
                       x + 10, y );
      tail.setThickness( 3 );
      tail.setColor( Color.BLUE );
   }
   
   //------------------- interface methods ------------------------------------
  /* public void setLocation( int x, int y )
   {
      xLocation = x;
      yLocation = y;
      this.setLocation( xLocation, yLocation );
      tail.setLocation( xLocation + 10, yLocation + 4 ); 
   } */
   
   public void mouseClicked( java.awt.event.MouseEvent e )
   {
      yLocation += fallIncrement;
      this.setLocation( xLocation, yLocation );
      tail.setPoints( tail.getP1().x, tail.getP1().y,
                      tail.getP2().x, tail.getP2().y + fallIncrement );
   }
   
   public void setFallIncrement( int y )
   {
      fallIncrement = y;
   }
   
   //---------------------------- main -----------------------------------------
   public static void main(String[] args)      
   {
      Frame f = new Frame();
      // create a Comet for unit testing
      Comet c = new Comet( 100, 100 );
   }
}