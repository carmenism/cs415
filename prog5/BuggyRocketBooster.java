/**
 * BuggyRocketBooster.java
 *   Creates a buggy with a rocket booster attached using the 
 *   Buggy class.
 *   METHODS:
 *    -  Mutators: mouseClicked, showComponent
 * 
 * Note: For use with Program5.java
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, February 26, 2008
 * 
 * History:
 *   23 February 2008 - created
 */

// ---------------------- imports -------------------------------------------
import wheelsunh.users.*;
import java.awt.event.*;
import java.awt.Color;

public class BuggyRocketBooster extends Buggy
{
   // ------------------------ instance variables --------------------------
   private Rectangle rocketBarrel;           // barrel of the rocket
   private Line flame1, flame2, flame3, flame4, flame5; // flames
   private int xLocation, yLocation;         // ( x, y ) location
   private int barrelX = 15, barrelY = 22;   // barrel dimensions
  
   // ------------------------ contructor ----------------------------------
   /**
    * BuggyRocketBooster( )
    *     This constructor creates a buggy with a rocket booster
    *     attached at default location ( 0, 0 ) with the default 
    *     color of blue.  The rocket booster itself will have a light
    *     gray barrel and orange flames.
    */
   public BuggyRocketBooster( )
   {
      super( 0, 0 );
      xLocation = 0;
      yLocation = 0;
    
      flame1 = new Line( xLocation + 32, yLocation + 81,
                         xLocation + 32, yLocation + 105 );
      flame1.setThickness( 3 );
      flame1.setColor( Color.ORANGE );
      
      flame2 = new Line( xLocation + 32, yLocation + 81,
                         xLocation + 27, yLocation + 100 );
      flame2.setThickness( 3 );
      flame2.setColor( Color.ORANGE );
      
      flame3 = new Line( xLocation + 32, yLocation + 81,
                         xLocation + 38, yLocation + 100 );
      flame3.setThickness( 3 );
      flame3.setColor( Color.ORANGE );
       
      flame4 = new Line( xLocation + 36, yLocation + 82,
                         xLocation + 26, yLocation + 92 );
      flame4.setThickness( 3 );
      flame4.setColor( Color.ORANGE );
       
      flame5 = new Line( xLocation + 28, yLocation + 82,
                         xLocation + 38, yLocation + 92 );
      flame5.setThickness( 3 );
      flame5.setColor( Color.ORANGE );
      
      rocketBarrel = new Rectangle( xLocation + 24, yLocation + 63 );
      rocketBarrel.setFillColor( Color.GRAY.brighter() );
      rocketBarrel.setFrameColor( Color.BLACK );
      rocketBarrel.setSize( barrelX, barrelY );
      
      this.add(flame1);
      this.add(flame2);
      this.add(flame3);
      this.add(flame4);
      this.add(flame5);
      this.add(rocketBarrel);
       
      this.setLocation( 0, 0 );
   }
    
   /**
    * BuggyRocketBooster( int x, int y )
    *     This constructor creates a buggy with a rocket booster at
    *     ( x, y ) as specified in parameters with the default color
    *     blue.  The rocket rooster itself will have a light gray
    *     barrel and orange flames.
    * x, y: desired location in screen coordinates
    */
   public BuggyRocketBooster( int x, int y )
   {
      super( x, y );
      xLocation = x;
      yLocation = y;
   
      flame1 = new Line( xLocation + 32, yLocation + 81,
                         xLocation + 32, yLocation + 105 );
      flame1.setThickness( 3 );
      flame1.setColor( Color.ORANGE );
      
      flame2 = new Line( xLocation + 32, yLocation + 81,
                         xLocation + 27, yLocation + 100 );
      flame2.setThickness( 3 );
      flame2.setColor( Color.ORANGE );
      
      flame3 = new Line( xLocation + 32, yLocation + 81,
                         xLocation + 38, yLocation + 100 );
      flame3.setThickness( 3 );
      flame3.setColor( Color.ORANGE );
      
      flame4 = new Line( xLocation + 36, yLocation + 82,
                         xLocation + 26, yLocation + 92 );
      flame4.setThickness( 3 );
      flame4.setColor( Color.ORANGE );
      
      flame5 = new Line( xLocation + 28, yLocation + 82,
                         xLocation + 38, yLocation + 92 );
      flame5.setThickness( 3 );
      flame5.setColor( Color.ORANGE );
      
      rocketBarrel = new Rectangle( xLocation + 24, yLocation + 63 );
      rocketBarrel.setFillColor( Color.GRAY.brighter() );
      rocketBarrel.setFrameColor( Color.BLACK );
      rocketBarrel.setSize( barrelX, barrelY );
      
      this.add(flame1);
      this.add(flame2);
      this.add(flame3);
      this.add(flame4);
      this.add(flame5);
      this.add(rocketBarrel);     
   }
  
   /**
    * BuggyRocketBooster( Color c )
    *     This constructor creates a buggy with a rocket booster
    *     at default location ( 0, 0 ) with the color passed in
    *     by the parameter.  The rocket booster itself will have a 
    *     light gray barrel and orange flames.
    * c: desired color of buggy's main components
    */
   public BuggyRocketBooster( Color c)
   {
      super( c );
      xLocation = 0;
      yLocation = 0;
    
      flame1 = new Line( xLocation + 32, yLocation + 81,
                         xLocation + 32, yLocation + 105 );
      flame1.setThickness( 3 );
      flame1.setColor( Color.ORANGE );
       
      flame2 = new Line( xLocation + 32, yLocation + 81,
                         xLocation + 27, yLocation + 100 );
      flame2.setThickness( 3 );
      flame2.setColor( Color.ORANGE );
       
      flame3 = new Line( xLocation + 32, yLocation + 81,
                         xLocation + 38, yLocation + 100 );
      flame3.setThickness( 3 );
      flame3.setColor( Color.ORANGE );
       
      flame4 = new Line( xLocation + 36, yLocation + 82,
                         xLocation + 26, yLocation + 92 );
      flame4.setThickness( 3 );
      flame4.setColor( Color.ORANGE );
       
      flame5 = new Line( xLocation + 28, yLocation + 82,
                         xLocation + 38, yLocation + 92 );
      flame5.setThickness( 3 );
      flame5.setColor( Color.ORANGE );
      
      rocketBarrel = new Rectangle( xLocation + 24, yLocation + 63 );
      rocketBarrel.setFillColor( Color.GRAY.brighter() );
      rocketBarrel.setFrameColor( Color.BLACK );
      rocketBarrel.setSize( barrelX, barrelY );
      
      this.add(flame1);
      this.add(flame2);
      this.add(flame3);
      this.add(flame4);
      this.add(flame5);
      this.add(rocketBarrel);     
       
      this.setLocation( 0, 0 );
   }
    
   // ------------------------ mutators ------------------------------------
   /**
    * void mouseClicked( MouseEvent e )
    *     This method will hide the rocket booster component
    *     when the mouse is clicked.
    */
   public void mouseClicked( MouseEvent e )
   {
      flame1.hide( );
      flame2.hide( );
      flame3.hide( );
      flame4.hide( );
      flame5.hide( );
      rocketBarrel.hide( );
   }
    
   /**
    * void showComponent( MouseEvent e )
    *     This method shows hidden components when called.
    *     NOTE:  To be called in the Button class by a mouse click.
    */
   public void showComponent( )
   {
      flame1.show( );
      flame2.show( );
      flame3.show( );
      flame4.show( );
      flame5.show( );
      rocketBarrel.show( );
   }
   
   // ----------------------------------------------------------------------
   /** main program just invokes the class constructor.
    */
   public static void main(String[] args)
   {
      Frame f = new Frame();
      BuggyRocketBooster app = new BuggyRocketBooster( );
      
      Buggy test1 = new BuggyRocketBooster( 100, 100 );
      Buggy test2 = new BuggyRocketBooster( Color.YELLOW );
      app.setColor( Color.GREEN );
      app.setLocation( 400, 150 ); 
   }
} // End of Class BuggyRocketBooster