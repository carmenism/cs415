/** 
 * Balloon.java:
 *  
 *mlb 3/2008
 * 
 * Edited by Carmen St. Jean for Lab13
 */

import wheelsunh.users.*;

public class Balloon extends Ellipse
{  
   private int xLocation, yLocation;
   //---------------------------------------------------------
   public Balloon( int x, int y )
   {
       super( x, y );
       xLocation = x;
       yLocation = y;
       this.setSize( 30, 30 );
   }
   
   //---------------------------------------------------------
   public void floatAt( int speed )
   {
       while ( yLocation > -40 )
       {
          yLocation -= speed;
          Utilities.frame( );
          this.setLocation( xLocation, yLocation );
       }
   }


   //---------------------------------------------------------
   public static void main( String[ ] args )
   {
       Frame f = new Frame();
       Balloon b1 = new Balloon( 10, 10 );
       Balloon b2 = new Balloon( 300, 300 );
       b2.floatAt( 10 );
   }  
}//End of Class Balloon