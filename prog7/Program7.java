/** 
 * Program7.java
 *   This program uses buttons and a slider to move a buggy around.
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, March 4, 2008
 * 
 * NOTE:  I know something is causing a runtime error in the console, but it is
 * only happening a fraction of the time.  I've tried it on multiple computers
 * and I haven't been able to recreate the conditions which cause this runtime
 * error.
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;

public class Program7 extends Frame 
{   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------
   public Program7( ) 
   {
      Buggy b = new Buggy( 0, 0, Color.GREEN );
      Slider s = new Slider( 388, 420 );       
      DrawButton rightButton = new RightButton( 360, 420, b, s );
      DrawButton leftButton = new LeftButton( 324, 420, b, s );
      DrawButton upButton = new UpButton( 342, 402, b, s );
      DrawButton downButton = new DownButton( 342, 438, b, s );
   }
   
   //---------------------------------------------------------------------------
   // main method  
   public static void main ( String[] argv ) 
   {
      new Program7( );
   }
}
//---- 80 characters wide ------------------------------------------------------