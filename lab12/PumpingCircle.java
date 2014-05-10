/* Edited by Carmen St. Jean for CS 415 (Spring 2008) Lab 12
 *  March 25, 2008
 */

import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;


/** 
 *  PumpingCircle.java:
 *  
 */
public class PumpingCircle extends Ellipse
{ 
   //----------------- instance variables --------------------------------------
   
   private int mySize = 100, lastSize = 110; 
   private boolean growing = false;
   private int inc = 10;
   
   //------------------ constructor ---------------------------------------------
   public PumpingCircle(  int x, int y ) 
   {      
      super( x, y );   
      setSize( mySize, mySize );  
   }
   

   
   //------------------------------------------------------------------------------
   //
   public void mouseClicked( MouseEvent me )
   {
           // circle should grow by 10 pixels if it is in the growing  state
           // if not in the growing state then it should shrink by 10 pixels
      
           // initially it is in the shrinking state
           // then, if the size is 50 or less it should change to the growing state
           // then, if the size is 100 or greater it should change to the shrinking state
      if ( ( ( lastSize > mySize ) && ( mySize > 50 ) ) || ( mySize == 100 ) )
      {
         // SHRINK
         lastSize = mySize;
         mySize -= 10;
         setSize( mySize, mySize );
      }
      else 
      {
         // GROW
         lastSize = mySize;
         mySize += 10;
         setSize( mySize, mySize );
      }
   }
  
   
   //---------------------------- main -----------------------------------------
   public static void main( String[] args )      
   {
      Frame f = new Frame();
      PumpingCircle p = new PumpingCircle( 20, 30 );
      p.setSize( 100 , 100 );
   }
}