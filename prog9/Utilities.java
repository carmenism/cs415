/** 
 * Utilities.java:
 *  
 *mlb 3/2008
 */

import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;
import javax.swing.JOptionPane;
import java.awt.Point;

public class Utilities
{  
  //-------------------- class variables -----------------------
  private static int frameTime = 200;
  
  
   //---------------------------------------------------------
   // 
   public static Point parsePoint( String s )
   {
      int x, y;
      Scanner scanner = new Scanner( s );
      Point p = null;
      
      if ( scanner.hasNextInt( ) )
      {
         x =  scanner.nextInt( );
         if ( scanner.hasNextInt( ) )
         {
            y = scanner.nextInt( );
            p = new Point( x, y );
            System.out.println( "Point parse: " + p );
         }
         else
            System.out.println( "Point parse error: " + s );
      }
      else
         System.out.println( "Point parse error: " + s );
      
      return p;    
   }
 
   //---------------------------------------------------------
   // 
   public static void drawPoint( Point p )
   {
      Line h,v;
      
      h = new Line( p.x -4, p.y, p.x + 4 , p.y );
      v = new Line( p.x, p.y -4,  p.x, p.y +4 );
   }

  //---------------------------------------------------------
  // 
  public static void frame( ) 
  {
    sleep( frameTime );
  }
  
  
  //---------------------------------------------------------
  // 
  public static void sleep( int milliseconds ) 
  {
      try
      {
        Thread.sleep( milliseconds );
      }
      catch ( java.lang.InterruptedException e ) 
      {  }
  }

}//End of Class 