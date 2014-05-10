/**
 * Lab7
 * 


 */

import wheelsunh.users.*;
import java.awt.Color;

public class Lab7 extends Frame 
{   
   /**
    * The constructor 
    */
   public Lab7() 
   {
      Snake s = new Snake( 350, 350 );
    
      // Make the direction buttons
       
      DrawButton rightButton = new RightButton( 370, 420, s );
      DrawButton leftButton  = new LeftButton( 330, 420, s );
      DrawButton moveButton  = new MoveButton( 350, 460, s );
     
   }
   
   public static void main ( String[] argv ) 
   {
      new Lab7();
   }
}
