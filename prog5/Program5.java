/** 
 * Program5.java
 *   This program will display three different buggies with
 *   three corresponding buttons.
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, February 26, 2008
 * 
 * History:
 *   23 February 2008 - created
 */

// ---------------------- imports ------------------------------------------
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class Program5 extends Frame 
{   
   // ------------------------ contructor ----------------------------------
   public Program5() 
   {
      Buggy buggy1 = new Buggy( );
      buggy1.setLocation( 150, 150 );
      
      BuggyPlow buggy2 = new BuggyPlow( Color.CYAN );
      buggy2.setLocation( 250, 139 );
      
      BuggyRocketBooster buggy3 = new BuggyRocketBooster( 350, 150 );
      buggy3.setColor( Color.RED );
       
      Button button1 = new Button( 170, 290, buggy1 );
      Button button2 = new Button( 270, 290, buggy2 );
      Button button3 = new Button( 370, 290, buggy3 );
   }
   
   public static void main ( String[] argv ) 
   {
      new Program5();
   }
} // End of Class Program5
