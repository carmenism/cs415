/* Edited by Carmen St. Jean for CS 415 (Spring 2008) Lab 12
 *  March 25, 2008
 */

import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;


/** 
 *  OverlappingRectangle.java:
 *  
 */


public class OverlappingRectangle extends Rectangle
{ 
   //----------------- instance variables --------------------------------------
   private int myX, myY, myWidth, myHeight, myXb, myYb;
   private int peerX, peerY, peerWidth, peerHeight;  
   private Rectangle other;  // peer Rectangle
   private Point lastMouse; 
   
   //------------------ constructors ---------------------------------------------
   public OverlappingRectangle( Rectangle r, int x, int y ) 
   {      
      super( x, y );
      other = r;        // the other Rectangle
      myX = x;
      myY = y;
      myWidth = this.getWidth( );
      myHeight = this.getHeight( );
      
      peerX = r.getXLocation( );
      peerY = r.getYLocation( );
      peerWidth = r.getWidth( );
      peerHeight = r.getHeight( );
   }
   
   //----------------------------------------------------------
   public void mousePressed( MouseEvent me )
   {
      lastMouse = me.getPoint();
      
   }
   
   //----------------------------------------------------------
   public void mouseDragged( MouseEvent me )
   {
      Point curMouse = me.getPoint();
      myX = myX + curMouse.x - lastMouse.x;
      myY = myY + curMouse.y - lastMouse.y;

      setLocation( myX, myY);   
      lastMouse = curMouse;  
      
      // add code to make the SmartRectagle change to blue if it overlaps
      // the Rectangle "other"   and to red if it doesn't
      
      myXb = myX + myWidth;
      myYb = myY + myHeight;
      
      if ( ( ( myX >= peerX ) && ( myX <= peerX + peerWidth ) ||
             ( myXb >= peerX ) && ( myXb <= peerX + peerWidth ) ) &&
           ( ( myYb >= peerY ) && ( myYb <= peerY + peerHeight ) ||
             ( myY >= peerY ) && ( myY <= peerY + peerHeight ) ) )
         this.setColor( Color.BLUE );
      else
         this.setColor( Color.RED );
   }
   
   
   //---------------------------- main -----------------------------------------
   public static void main( String[ ] args )      
   {
      Frame f = new Frame( );
      Rectangle r = new Rectangle( 200, 200 );
      r.setColor( Color.ORANGE );
      OverlappingRectangle p = new OverlappingRectangle(r,  400, 30 );
   }
}