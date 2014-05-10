import wheelsunh.users.*;
import java.awt.Color;



/** 
 *  Lab12.java:
 * 
 *  
 */
public class Lab12 extends Frame
{ 
 
   //------------------ constructor ---------------------------------------------
   public Lab12(  ) 
   {      
       // Try Pumping Circle
       PumpingCircle e = new PumpingCircle( 30, 60 );
       
       // Try Overlapping Rectangles
       Rectangle r = new Rectangle( 300, 200 );
       r.setColor( Color.ORANGE );
       OverlappingRectangle or = new OverlappingRectangle( r, 600, 400 );
       
       //Try Morphing Shape
       MorphingShape ms = new MorphingShape( 400, 100 );
   }
   

   //---------------------------- main -----------------------------------------
   public static void main( String[] args )      
   {    
      Lab12 p = new Lab12(  );
   }
}