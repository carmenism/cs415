// --------------- imports ------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.util.Random;
import java.awt.event.*;

public class Cockroach extends Ellipse
{
    //---------------- instance variables ------------------------------
    private int height, xLocation, yLocation;
    private Random generator;
  
    // -----------------------------------------------------------------
    /** 
     * Constructor for the Cockroach class.
     */
    public Cockroach( )
    {
       super( 0, 0 );
       generator = new Random( );
       this.setColor( Color.BLACK );
       xLocation = generator.nextInt( 690 );
       yLocation = generator.nextInt( 490 );
       height = generator.nextInt( 30 );
       while( height < 3 )
       {
          height = generator.nextInt( 30 );
       }
       this.setLocation( xLocation, yLocation );
       this.setSize( 3 * height, height );
    } 
    
    // -----------------------------------------------------------------

   public void mousePressed( MouseEvent e )
   {
       xLocation = generator.nextInt( 690 );
       yLocation = generator.nextInt( 490 );
       this.setLocation( xLocation, yLocation );
       System.out.println( "Value " + xLocation );
       Cockroach c = new Cockroach( );
   }
    
    // -----------------------------------------------------------------
    /** main program just invokes the class constructor.
     */
    public static void main(String[] args)
    {
        Frame f = new Frame();
        Cockroach c = new Cockroach();
    }
}//End of Class Cockroach