/** 
 * Lab13.java:
 *  
 *mlb 3/2008
 * 
 * Edited by Carmen St. Jean for Lab13
 */

import wheelsunh.users.*;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Lab13 extends Frame
{  
 
   private Balloon balloon;
   private Scanner scanner;
   private int speed;
   
   //---------------------------------------------------------
   public Lab13( )
   {
       String s;
      
       do
       {
          s = JOptionPane.showInputDialog( null, "enter  speed" );
          
          System.out.println( s );
       
          scanner = new Scanner( s );
      
          if ( scanner.hasNextInt() )
             speed = scanner.nextInt( );
          else
             speed = 0;
          
          Balloon b = new Balloon( 320, 400 );
          
          if ( speed >= 0 )
             b.floatAt( speed );
          
       } while ( speed > 0 );

   }

   //---------------------------------------------------------
   public static void main( String[ ] args )
   {
       new Lab13( ); 
   }  
}//End of Class Lab13