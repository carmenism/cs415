/** 
 * Program8.java:
 *  
 *mlb 3/2008
 */

import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;
import javax.swing.JOptionPane;
import java.awt.Point;

public class Program8 extends Frame
{  
 
   private Buggy buggy;
   
   //---------------------------------------------------------
   public Program8( )
   {
      String s;
      Point p;
      
      buggy = new Buggy( 20, 20 );
      Utilities.drawPoint( new Point( 20, 20 ) );  
      
      
      s = JOptionPane.showInputDialog( null, "enter a point x y" );      
      p = Utilities.parsePoint( s );
      
      while ( p != null )
      {
         Utilities.drawPoint( p );   
         buggy.driveTo( p , 10 );
         
         s = JOptionPane.showInputDialog( null, "enter a point x y" );    
         p = Utilities.parsePoint( s );     
      }     
      
      buggy.driveHome( );
   }

   //---------------------------------------------------------
   public static void main( String[ ] args )
   {
       new Program8( ); 
   }  
}//End of Class Program8