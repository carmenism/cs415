/**
 * Carmen St. Jean
 * CS 415, Spring 2008
 * February 12, 2008
 * 
 * Program3.java:
 * With the makeBuggy method, displays four dune buggies
 * with four different colors at different locations.
 */

import wheelsunh.users.*;
import java.awt.Color;

public class Program3 extends wheelsunh.users.Frame
{
  
    // -----------------------------------------------------------------
    /** Constructor for the Program3 class.
     */
   public Program3( )
   {
      makeBuggy( 100, 100, Color.CYAN );
      makeBuggy( 400, 100, Color.RED );
      makeBuggy( 100, 300, Color.GREEN );
      makeBuggy( 400, 300, Color.PINK );
   }
    
   /**
    * makeBuggy( int x, int y, Color newColor )
    *     Displays a pad containing a car of the specified color
    *     at the location given in the parameters.
    * x, y: define the desired location in screen coordinates
    * newColor: color for the major component of the car
    */
   public void makeBuggy( int x, int y, Color newColor )
   {
      //------instance variables---------------------------------------
      Rectangle pad;                 //pads to place buggies in
      Rectangle rollbar;              //rollbar of buggy
      RoundedRectangle body, cab;     //body and cab of buggy
      RoundedRectangle leftSeat, rightSeat; //seats
      RoundedRectangle wheel1, wheel2, wheel3, wheel4;  //wheels
      Ellipse steeringwheel;          //steering wheel
      Ellipse leftLight, rightLight;  //headlights
      Line bumper1, bumper2;          //front and rear bumpers
      int padX = 75, padY = 100;              //pad dimensions
      int wheelX = 10, wheelY = 20;           //wheel dimensions
      int lightX = 8, lightY = 5;             //headlight dimensions
      int seatX = 15, seatY = 14;             //seat dimension
      
      //------pad------------------------------------------------------
      pad = new Rectangle( x, y );
      pad.setFillColor( Color.WHITE );
      pad.setFrameColor( Color.BLACK );
      pad.setSize( padX, padY );
      
      //------car------------------------------------------------------
      wheel1 = new RoundedRectangle ( x + 5, y + 20 );
      wheel1.setColor( Color.BLACK );
      wheel1.setSize( wheelX, wheelY );
        
      wheel2 = new RoundedRectangle ( x + 59, y + 20 );
      wheel2.setColor( Color.BLACK );
      wheel2.setSize( wheelX, wheelY );
        
      wheel3 = new RoundedRectangle ( x + 5, y + 65 );
      wheel3.setColor( Color.BLACK );
      wheel3.setSize( wheelX, wheelY );
        
      wheel4 = new RoundedRectangle ( x + 59, y + 65 );
      wheel4.setColor( Color.BLACK );
      wheel4.setSize( wheelX, wheelY );
        
      body = new RoundedRectangle( x + 12, y + 12 );
      body.setFillColor( newColor );
      body.setFrameColor( Color.BLACK );
      body.setSize( 50, 79 );
        
      cab = new RoundedRectangle( x + 18, y + 32 );
      cab.setFillColor( newColor.darker() );
      cab.setFrameColor( Color.BLACK );
      cab.setSize( 37, 44 );
       
      steeringwheel = new Ellipse( x + 23, y + 38 );
      steeringwheel.setFillColor( newColor.darker() );
      steeringwheel.setFrameColor( Color.BLACK );
      steeringwheel.setSize( 10, 5 );
       
      leftSeat = new RoundedRectangle( x + 21, y + 47 );
      leftSeat.setFillColor( Color.YELLOW );
      leftSeat.setFrameColor( Color.BLACK );
      leftSeat.setSize( seatX, seatY );
       
      rightSeat = new RoundedRectangle( x + 38, y + 47 );
      rightSeat.setFillColor( Color.YELLOW );
      rightSeat.setFrameColor( Color.BLACK );
      rightSeat.setSize( seatX, seatY );
       
      rollbar = new Rectangle( x + 16, y + 67 );
      rollbar.setFillColor( newColor );
      rollbar.setFrameColor( Color.BLACK );
      rollbar.setSize( 42, 4 );
        
      bumper1 = new Line( x + 23, y + 12, x + 51, y + 12 );
      bumper1.setThickness( 3 );
      bumper1.setColor( Color.GRAY );
       
      bumper2 = new Line( x + 21, y + 90, x + 52, y + 90 );
      bumper2.setThickness( 3 );
      bumper2.setColor( Color.GRAY );
        
      leftLight = new Ellipse( x + 21, y + 10 );
      leftLight.setFillColor( Color.YELLOW );
      leftLight.setFrameColor( Color.BLACK );
      leftLight.setSize( lightX, lightY );
       
      rightLight = new Ellipse( x + 45, y + 10 );
      rightLight.setFillColor( Color.YELLOW );
      rightLight.setFrameColor( Color.BLACK );
      rightLight.setSize( lightX, lightY );
   }    
   // -----------------------------------------------------------------
   /** main program just invokes the class constructor.
    */
   public static void main(String[] args)
   {
      Program3 app = new Program3();
   }
}//End of Class Program3