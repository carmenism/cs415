/** 
 * Buggy.java
 *   This class creates dune buggies.
 *   METHODS:
 *    - Mutators: setColor, mousePressed, mouseReleased, showComponent
 *    - Accessors: getColor, getXLocation, getYLocation
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

public class Buggy extends ShapeGroup
{  
   // ------------------------ instance variables --------------------------
   protected Rectangle rollbar;              // rollbar of buggy
   protected RoundedRectangle body, cab;     // body and cab of buggy
   protected RoundedRectangle leftSeat, rightSeat; // seats
   protected RoundedRectangle wheel1, wheel2, wheel3, wheel4; // wheels
   protected Ellipse steeringwheel;          // steering wheel
   protected Ellipse leftLight, rightLight;  // headlights
   protected Line bumper1, bumper2;          // front and rear bumpers
   protected int  xLocation, yLocation;        // ( x, y ) location
   protected int padX = 75, padY = 100;        // pad dimensions
   protected int wheelX = 10, wheelY = 20;     // wheel dimensions
   protected int lightX = 8, lightY = 5;       // headlight dimensions
   protected int seatX = 15, seatY = 14;       // seat dimension
   protected Color bodyColor, tempColorSave;   // color of main component
   protected Color lightgray = Color.GRAY.brighter( );  // light gray
   
   // ------------------------ contructor ----------------------------------
   /**
    * Buggy( )
    *     This constructor accepts no parameters to create a buggy at
    *     default location ( 0, 0 ) with default color blue.
    */
   public Buggy( )
   {   
      xLocation = 0;              // default location
      yLocation = 0;
      bodyColor = Color.BLUE;     // default color
      
      wheel1 = new RoundedRectangle ( xLocation, yLocation + 10 );
      wheel1.setColor( Color.BLACK );
      wheel1.setSize( wheelX, wheelY );
       
      wheel2 = new RoundedRectangle ( xLocation + 54, yLocation + 10 );
      wheel2.setColor( Color.BLACK );
      wheel2.setSize( wheelX, wheelY );
       
      wheel3 = new RoundedRectangle ( xLocation, yLocation + 55 );
      wheel3.setColor( Color.BLACK );
      wheel3.setSize( wheelX, wheelY );
        
      wheel4 = new RoundedRectangle ( xLocation + 54, yLocation + 55 );
      wheel4.setColor( Color.BLACK );
      wheel4.setSize( wheelX, wheelY );
        
      body = new RoundedRectangle( xLocation + 7, yLocation + 2 );
      body.setFillColor( bodyColor );
      body.setFrameColor( Color.BLACK );
      body.setSize( 50, 79 );
       
      cab = new RoundedRectangle( xLocation + 13, yLocation + 22 );
      cab.setFillColor( bodyColor.darker() );
      cab.setFrameColor( Color.BLACK );
      cab.setSize( 37, 44 );
      
      steeringwheel = new Ellipse( xLocation + 18, yLocation + 28 );
      steeringwheel.setFillColor( bodyColor.darker() );
      steeringwheel.setFrameColor( Color.BLACK );
      steeringwheel.setSize( 10, 5 );
      
      leftSeat = new RoundedRectangle( xLocation + 16, yLocation + 37 );
      leftSeat.setFillColor( Color.YELLOW );
      leftSeat.setFrameColor( Color.BLACK );
      leftSeat.setSize( seatX, seatY );
       
      rightSeat = new RoundedRectangle( xLocation + 33, yLocation + 37 );
      rightSeat.setFillColor( Color.YELLOW );
      rightSeat.setFrameColor( Color.BLACK );
      rightSeat.setSize( seatX, seatY );
       
      rollbar = new Rectangle( xLocation + 11, yLocation + 57 );
      rollbar.setFillColor( bodyColor );
      rollbar.setFrameColor( Color.BLACK );
      rollbar.setSize( 42, 4 );
       
      bumper1 = new Line( xLocation + 18, yLocation + 2,
                          xLocation + 46, yLocation + 2 );
      bumper1.setThickness( 3 );
      bumper1.setColor( lightgray );
      
      bumper2 = new Line( xLocation + 16, yLocation + 81,
                          xLocation + 47, yLocation + 81 );
      bumper2.setThickness( 3 );
      bumper2.setColor( lightgray );
       
      leftLight = new Ellipse( xLocation + 16, yLocation );
      leftLight.setFillColor( Color.YELLOW );
      leftLight.setFrameColor( Color.BLACK );
      leftLight.setSize( lightX, lightY );
      
      rightLight = new Ellipse( xLocation + 40, yLocation );
      rightLight.setFillColor( Color.YELLOW );
      rightLight.setFrameColor( Color.BLACK );
      rightLight.setSize( lightX, lightY );
      
      this.add(wheel1);
      this.add(wheel2);
      this.add(wheel3);
      this.add(wheel4);
      this.add(body);
      this.add(cab);
      this.add(steeringwheel);
      this.add(leftSeat);
      this.add(rightSeat);
      this.add(rollbar);
      this.add(bumper1);
      this.add(bumper2);
      this.add(leftLight);
      this.add(rightLight);
   }

   /**
    * Buggy( int x, int y )
    *     This constructor creates a buggy at the location ( x, y ) as
    *     specified in the parameters with default color blue.
    * x, y: define the desired location in screen coordinates
    */
   public Buggy( int x, int y )
   {
      xLocation = x;
      yLocation = y;
      bodyColor = Color.BLUE;     // default color
      
      wheel1 = new RoundedRectangle ( xLocation, yLocation + 10 );
      wheel1.setColor( Color.BLACK );
      wheel1.setSize( wheelX, wheelY );
       
      wheel2 = new RoundedRectangle ( xLocation + 54, yLocation + 10 );
      wheel2.setColor( Color.BLACK );
      wheel2.setSize( wheelX, wheelY );
       
      wheel3 = new RoundedRectangle ( xLocation, yLocation + 55 );
      wheel3.setColor( Color.BLACK );
      wheel3.setSize( wheelX, wheelY );
       
      wheel4 = new RoundedRectangle ( xLocation + 54, yLocation + 55 );
      wheel4.setColor( Color.BLACK );
      wheel4.setSize( wheelX, wheelY );
       
      body = new RoundedRectangle( xLocation + 7, yLocation + 2 );
      body.setFillColor( bodyColor );
      body.setFrameColor( Color.BLACK );
      body.setSize( 50, 79 );
       
      cab = new RoundedRectangle( xLocation + 13, yLocation + 22 );
      cab.setFillColor( bodyColor.darker() );
      cab.setFrameColor( Color.BLACK );
      cab.setSize( 37, 44 );
      
      steeringwheel = new Ellipse( xLocation + 18, yLocation + 28 );
      steeringwheel.setFillColor( bodyColor.darker() );
      steeringwheel.setFrameColor( Color.BLACK );
      steeringwheel.setSize( 10, 5 );
      
      leftSeat = new RoundedRectangle( xLocation + 16, yLocation + 37 );
      leftSeat.setFillColor( Color.YELLOW );
      leftSeat.setFrameColor( Color.BLACK );
      leftSeat.setSize( seatX, seatY );
       
      rightSeat = new RoundedRectangle( xLocation + 33, yLocation + 37 );
      rightSeat.setFillColor( Color.YELLOW );
      rightSeat.setFrameColor( Color.BLACK );
      rightSeat.setSize( seatX, seatY );
      
      rollbar = new Rectangle( xLocation + 11, yLocation + 57 );
      rollbar.setFillColor( bodyColor );
      rollbar.setFrameColor( Color.BLACK );
      rollbar.setSize( 42, 4 );
       
      bumper1 = new Line( xLocation + 18, yLocation + 2,
                          xLocation + 46, yLocation + 2 );
      bumper1.setThickness( 3 );
      bumper1.setColor( lightgray );
      
      bumper2 = new Line( xLocation + 16, yLocation + 81,
                          xLocation + 47, yLocation + 81 );
      bumper2.setThickness( 3 );
      bumper2.setColor( lightgray );
       
      leftLight = new Ellipse( xLocation + 16, yLocation );
      leftLight.setFillColor( Color.YELLOW );
      leftLight.setFrameColor( Color.BLACK );
      leftLight.setSize( lightX, lightY );
      
      rightLight = new Ellipse( xLocation + 40, yLocation );
      rightLight.setFillColor( Color.YELLOW );
      rightLight.setFrameColor( Color.BLACK );
      rightLight.setSize( lightX, lightY );
      
      this.add(wheel1);
      this.add(wheel2);
      this.add(wheel3);
      this.add(wheel4);
      this.add(body);
      this.add(cab);
      this.add(steeringwheel);
      this.add(leftSeat);
      this.add(rightSeat);
      this.add(rollbar);
      this.add(bumper1);
      this.add(bumper2);
      this.add(leftLight);
      this.add(rightLight);
   }
   
   /**
    * Buggy( Color c )
    *     This constructor creates a buggy at default location ( 0, 0 )
    *     with the color specified in the parameter.
     * c: defines the desired color of the main component of the buggy
    */
   public Buggy( Color c )
   {  
      xLocation = 0;              // default location
      yLocation = 0;
      bodyColor = c;
      
      wheel1 = new RoundedRectangle ( xLocation, yLocation + 10 );
      wheel1.setColor( Color.BLACK );
      wheel1.setSize( wheelX, wheelY );
       
      wheel2 = new RoundedRectangle ( xLocation + 54, yLocation + 10 );
      wheel2.setColor( Color.BLACK );
      wheel2.setSize( wheelX, wheelY );
       
      wheel3 = new RoundedRectangle ( xLocation, yLocation + 55 );
      wheel3.setColor( Color.BLACK );
      wheel3.setSize( wheelX, wheelY );
       
      wheel4 = new RoundedRectangle ( xLocation + 54, yLocation + 55 );
      wheel4.setColor( Color.BLACK );
      wheel4.setSize( wheelX, wheelY );
       
      body = new RoundedRectangle( xLocation + 7, yLocation + 2 );
      body.setFillColor( bodyColor );
      body.setFrameColor( Color.BLACK );
      body.setSize( 50, 79 );
       
      cab = new RoundedRectangle( xLocation + 13, yLocation + 22 );
      cab.setFillColor( bodyColor.darker() );
      cab.setFrameColor( Color.BLACK );
      cab.setSize( 37, 44 );
      
      steeringwheel = new Ellipse( xLocation + 18, yLocation + 28 );
      steeringwheel.setFillColor( bodyColor.darker() );
      steeringwheel.setFrameColor( Color.BLACK );
      steeringwheel.setSize( 10, 5 );
      
      leftSeat = new RoundedRectangle( xLocation + 16, yLocation + 37 );
      leftSeat.setFillColor( Color.YELLOW );
      leftSeat.setFrameColor( Color.BLACK );
      leftSeat.setSize( seatX, seatY );
        
      rightSeat = new RoundedRectangle( xLocation + 33, yLocation + 37 );
      rightSeat.setFillColor( Color.YELLOW );
      rightSeat.setFrameColor( Color.BLACK );
      rightSeat.setSize( seatX, seatY );
      
      rollbar = new Rectangle( xLocation + 11, yLocation + 57 );
      rollbar.setFillColor( bodyColor );
      rollbar.setFrameColor( Color.BLACK );
      rollbar.setSize( 42, 4 );
       
      bumper1 = new Line( xLocation + 18, yLocation + 2,
                          xLocation + 46, yLocation + 2 );
      bumper1.setThickness( 3 );
      bumper1.setColor( lightgray );
      
      bumper2 = new Line( xLocation + 16, yLocation + 81,
                          xLocation + 47, yLocation + 81 );
      bumper2.setThickness( 3 );
      bumper2.setColor( lightgray );
       
      leftLight = new Ellipse( xLocation + 16, yLocation );
      leftLight.setFillColor( Color.YELLOW );
      leftLight.setFrameColor( Color.BLACK );
      leftLight.setSize( lightX, lightY );
      
      rightLight = new Ellipse( xLocation + 40, yLocation );
      rightLight.setFillColor( Color.YELLOW );
      rightLight.setFrameColor( Color.BLACK );
      rightLight.setSize( lightX, lightY );
      
      this.add(wheel1);
      this.add(wheel2);
      this.add(wheel3);
      this.add(wheel4);
      this.add(body);
      this.add(cab);
      this.add(steeringwheel);
      this.add(leftSeat);
      this.add(rightSeat);
      this.add(rollbar);
      this.add(bumper1);
      this.add(bumper2);
      this.add(leftLight);
      this.add(rightLight);
   } 
     
   // ------------------------ mutators ------------------------------------
   /**
    * setColor( Color c )
    *     This method changes the main components of the buggy to the 
    *     color given in the parameters.
    * c: defines the new desired color for the main components
    */
   public void setColor( Color c )
   {
      bodyColor = c;
      body.setFillColor( bodyColor );
      cab.setFillColor( bodyColor.darker() );
      steeringwheel.setFillColor( bodyColor.darker() );
      rollbar.setFillColor( bodyColor );
   }
   
   /**
    * mousePressed( )
    *      This method changes the color of all components of the
    *      buggy to gray with a press of the mouse.
    */
   public void mousePressed( MouseEvent e )
   {
      tempColorSave = this.getColor( );
      this.setColor( Color.GRAY );
      leftSeat.setFillColor( lightgray );
      rightSeat.setFillColor( lightgray );
      leftLight.setFillColor( lightgray );
      rightLight.setFillColor( lightgray );
      bodyColor = tempColorSave;
   }
   
   /**
    * mouseReleased( )
    *     After a buggy has been turned gray by a mouse press, the
    *     release of a mouse returns the buggy to its original colors
    *     with this method.
    */
   public void mouseReleased( MouseEvent e )
   {
      this.setColor( bodyColor );
      leftSeat.setFillColor( Color.YELLOW );
      rightSeat.setFillColor( Color.YELLOW );
      leftLight.setFillColor( Color.YELLOW );
      rightLight.setFillColor( Color.YELLOW );
   }
   
   public void showComponent( )
   {
      // Nothing happens here!  (This is so even a plain buggy can have
      // a corresponding button.)
   }
   
   // ------------------------ accessors -----------------------------------
   /** get Color getColor( )
    *     This method gets the color of the main component of the buggy.
    * returns: bodyColor
    */
   public Color getColor( )
   {
      return bodyColor;
   }
    
   /**
    * getXLocation( )
    *     This method gets the x-location of the buggy's screen coordinates.
    * returns: xLocation
    */
   public int getXLocation( )
   {
      return xLocation;
   }

   /**
    * getYLocation( )
    *     This method gets the y-location of the buggy's screen coordinates.
    * returns: yLocation
    */
   public int getYLocation( )
   {
      return yLocation;
   }
     
   // ----------------------------------------------------------------------
   /** main program just invokes the class constructor.
    */
   public static void main(String[] args)
   {
      Frame f = new Frame();
      Buggy app = new Buggy( );
     
      Buggy test1 = new Buggy( 100, 100 );
      Buggy test2 = new Buggy( Color.YELLOW );
      app.setColor( Color.GREEN );
      app.setLocation( 400, 150 );
   }
}//End of Class Buggy