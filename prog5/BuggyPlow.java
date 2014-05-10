/**
 * BuggyPlow.java
 *   Creates a buggy with a plow attached using the Buggy class.
 *   METHODS:
 *    - Mutators: mouseClicked, showComponent
 * 
 * Note: For use with Program5.java
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, February 26, 2008
 * 
 * History:
 *   23 February 2008 - created
 */

// ---------------------- imports ------------------------------------------
import wheelsunh.users.*;
import java.awt.event.*;
import java.awt.Color;

public class BuggyPlow extends Buggy
{
   // ------------------------ instance variables --------------------------
   private Rectangle plow;             // main part of plow
   private Line leftConnector, rightConnector; // connect to the buggy
   private int xLocation, yLocation;           // ( x, y ) location
  
   // ------------------------ contructor ----------------------------------
   /**
    * BuggyPlow( )
    *     This constructor creates a buggy with a plow attached at
    *     default location ( 0, 0 ) with default color blue.  The plow
    *     itself will be yellow with gray connector pieces.
    */
   public BuggyPlow( )
   {
      super( 0, 0 );  
      xLocation = 0;
      yLocation = 0;
   
      leftConnector = new Line( xLocation + 20, yLocation - 4,
                                xLocation + 20, yLocation - 2 );
      leftConnector.setThickness( 3 );
      leftConnector.setColor( Color.GRAY );
      
      rightConnector = new Line( xLocation + 44, yLocation - 4,
                                 xLocation + 44, yLocation - 2 );
      rightConnector.setThickness( 3 );
      rightConnector.setColor( Color.GRAY );
      
      plow = new Rectangle( xLocation + 2, yLocation - 12 );
      plow.setFillColor( Color.YELLOW );
      plow.setFrameColor( Color.BLACK );
      plow.setSize( 60, 8 );
       
      this.add(plow);
      this.add(leftConnector);
      this.add(rightConnector);
      
      this.setLocation( 0, 0 );  // Resets location of WHOLE object
                                 // to ( 0, 0 ).  Otherwise, the plow
                                 // will be out of the frame.
   }
    
   /**
    * BuggyPlow( int x, int y )
    *     This constructor creates a buggy with a plow attached at
    *     location ( x, y ) specified in parameters with default color
    *     blue.  The plow itself will be yellow with gray connector
    *     pieces.
    * x, y: desired location of buggy in screen coordinates.
    */
   public BuggyPlow( int x, int y )
   {
      super( x, y );  
      xLocation = x;
      yLocation = y;
   
      leftConnector = new Line( xLocation + 20, yLocation - 4,
                                xLocation + 20, yLocation - 2 );
      leftConnector.setThickness( 3 );
      leftConnector.setColor( Color.GRAY );
      
      rightConnector = new Line( xLocation + 44, yLocation - 4,
                                 xLocation + 44, yLocation - 2 );
      rightConnector.setThickness( 3 );
      rightConnector.setColor( Color.GRAY );
      
      plow = new Rectangle( xLocation + 2, yLocation - 12 );
      plow.setFillColor( Color.YELLOW );
      plow.setFrameColor( Color.BLACK );
      plow.setSize( 60, 8 );
       
      this.add(plow);
      this.add(leftConnector);
      this.add(rightConnector);
       
      this.setLocation( x, y );  // Resets location of WHOLE object
                                 // to ( x, y ).  Otherwise, the plow
                                 // may be out of the frame.
   }

   /**
    * BuggyPlow( Color c )
    *     This constructor creates a buggy with a plow attached
    *     at default location ( 0, 0 ) with the color specified in the
    *     parameter.  The plow itself will be yellow with gray
    *     connector pieces.
    * c: desired color of main component of buggy.
    */
   public BuggyPlow( Color c )
   {
      super( c );   
      xLocation = 0;
      yLocation = 0;
    
      leftConnector = new Line( xLocation + 20, yLocation - 4,
                                xLocation + 20, yLocation - 2 );
      leftConnector.setThickness( 3 );
      leftConnector.setColor( Color.GRAY );
       
      rightConnector = new Line( xLocation + 44, yLocation - 4,
                                 xLocation + 44, yLocation - 2 );
      rightConnector.setThickness( 3 );
      rightConnector.setColor( Color.GRAY );
       
      plow = new Rectangle( xLocation + 2, yLocation - 12 );
      plow.setFillColor( Color.YELLOW );
      plow.setFrameColor( Color.BLACK );
      plow.setSize( 60, 8 );
       
      this.add(plow);
      this.add(leftConnector);
      this.add(rightConnector);
       
      this.setLocation( 0, 0 );  // Resets location of WHOLE object
                                 // to ( 0, 0 ).  Otherwise, the plow
                                 // will be out of the frame.
   }
    
   // ------------------------ mutators ------------------------------------
   /**
    * void mouseClicked( MouseEvent e )
    *     This method will hide the plow component when the mouse
    *     is clicked.
    */
   public void mouseClicked( MouseEvent e )
   {
      plow.hide( );
      leftConnector.hide( );
      rightConnector.hide( );
   }
    
   /**
    * void showComponent( MouseEvent e )
    *     This method shows hidden components when called.
    *     NOTE:  To be called in the Button class by a mouse click.
    */
   public void showComponent( )
   {
      leftConnector.show( );
      rightConnector.show( );
      plow.show( );
   }
    
   // ----------------------------------------------------------------------
   /** main program just invokes the class constructor.
    */
   public static void main(String[] args)
   {
      Frame f = new Frame();
      BuggyPlow app = new BuggyPlow( );
     
      Buggy test1 = new BuggyPlow( 100, 100 );
      Buggy test2 = new BuggyPlow( Color.YELLOW );
      app.setColor( Color.GREEN );
      app.setLocation( 400, 150 ); 
   }
} // End of Class BuggyPlow