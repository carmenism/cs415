/** 
 * Lab10.java: 
 *     
 *
 * @author mlb
 * 2/1/08
 */

// --------------- imports ------------------------------
import wheelsunh.users.*;
import java.awt.Color;

public class Lab10 extends Frame
{
    //---------------- instance variables ------------------------------
  
    
    // -----------------------------------------------------------------
    /** 
     * Constructor for the Lab10 class.
     */
    public Lab10( )
    {
         PowerEllipse e = new PowerEllipse( 100, 200 );
         e.setSize(20,20);
         e.setColor(Color.BLACK);
         PowerRectangle r = new PowerRectangle( 300, 200 );
         r.setSize(50, 60);
         e.setColor(Color.ORANGE);   
         
    } 
     // -----------------------------------------------------------------
    /** main program just invokes the class constructor.
     */
    public static void main(String[] args)
    {
        Lab10 app = new Lab10();
    }
}//End of Class Lab10