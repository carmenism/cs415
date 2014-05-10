/**
 * Carmen St. Jean
 * CS 415, Spring 2008
 * 
 * Program2.java:
 * Displays 2 rectangles containing identical dune buggies.
 *
 * CS415 program 2
 * 
 */

import wheelsunh.users.*;
import java.awt.Color;

public class Program2 extends wheelsunh.users.Frame
{
    //---------------- instance variables ------------------------------
    private Rectangle pad1, pad2;           //pads to place buggies in
    private Rectangle rollbar;              //rollbar of buggy
    private RoundedRectangle body, cab;     //body and cab of buggy
    private RoundedRectangle leftSeat, rightSeat; //seats
    private RoundedRectangle wheel1, wheel2, wheel3, wheel4;  //wheels
    private Ellipse steeringwheel;          //steering wheel
    private Ellipse leftLight, rightLight;  //headlights
    private Line bumper1, bumper2;          //front and rear bumpers
    int x1 = 200, y1 = 200, x2 = 400, y2 = 200;  //positioning variables
    int padX = 75, padY = 100;              //pad dimensions
    int wheelX = 10, wheelY = 20;           //wheel dimensions
    int lightX = 8, lightY = 5;             //headlight dimensions
    int seatX = 15, seatY = 14;             //seat dimension
    
    // -----------------------------------------------------------------
    /** Constructor for the Program2 class.
     */
    public Program2( )
    {
        pad1 = new Rectangle( x1, y1 );
        pad1.setFillColor( Color.WHITE );
        pad1.setFrameColor( Color.BLACK );
        pad1.setSize( padX, padY );
       
        pad2 = new Rectangle( x2, y2 );
        pad2.setFillColor( Color.WHITE );
        pad2.setFrameColor( Color.BLACK );
        pad2.setSize( padX, padY );
        
        //--------------------------------------------

        // car in pad1
        wheel1 = new RoundedRectangle ( x1 + 5, y1 + 20 );
        wheel1.setColor( Color.BLACK );
        wheel1.setSize( wheelX, wheelY );
        
        wheel2 = new RoundedRectangle ( x1 + 59, y1 + 20 );
        wheel2.setColor( Color.BLACK );
        wheel2.setSize( wheelX, wheelY );
        
        wheel3 = new RoundedRectangle ( x1 + 5, y1 + 65 );
        wheel3.setColor( Color.BLACK );
        wheel3.setSize( wheelX, wheelY );
        
        wheel4 = new RoundedRectangle ( x1 + 59, y1 + 65 );
        wheel4.setColor( Color.BLACK );
        wheel4.setSize( wheelX, wheelY );
        
        body = new RoundedRectangle( x1 + 12, y1 + 12 );
        body.setFillColor( Color.BLUE );
        body.setFrameColor( Color.BLACK );
        body.setSize( 50, 79 );
        
        cab = new RoundedRectangle( x1 + 18, y1 + 32 );
        cab.setFillColor( Color.GREEN );
        cab.setFrameColor( Color.BLACK );
        cab.setSize( 37, 44 );
        
        steeringwheel = new Ellipse( x1 + 23, y1 + 38 );
        steeringwheel.setFillColor( Color.GREEN );
        steeringwheel.setFrameColor( Color.BLACK );
        steeringwheel.setSize( 10, 5 );
        
        leftSeat = new RoundedRectangle( x1 + 21, y1 + 47 );
        leftSeat.setFillColor( Color.YELLOW );
        leftSeat.setFrameColor( Color.BLACK );
        leftSeat.setSize( seatX, seatY );
        
        rightSeat = new RoundedRectangle( x1 + 38, y1 + 47 );
        rightSeat.setFillColor( Color.YELLOW );
        rightSeat.setFrameColor( Color.BLACK );
        rightSeat.setSize( seatX, seatY );
        
        rollbar = new Rectangle( x1 + 16, y1 + 67 );
        rollbar.setFillColor( Color.RED );
        rollbar.setFrameColor( Color.BLACK );
        rollbar.setSize( 42, 4 );
        
        bumper1 = new Line( x1 + 23, y1 + 12, x1 + 51, y1 + 12 );
        bumper1.setThickness( 3 );
        bumper1.setColor( Color.GRAY );
        
        bumper2 = new Line( x1 + 21, y1 + 90, x1 + 52, y1 + 90 );
        bumper2.setThickness( 3 );
        bumper2.setColor( Color.GRAY );
        
        leftLight = new Ellipse( x1 + 21, y1 + 10 );
        leftLight.setFillColor( Color.YELLOW );
        leftLight.setFrameColor( Color.BLACK );
        leftLight.setSize( lightX, lightY );
        
        rightLight = new Ellipse( x1 + 45, y1 + 10 );
        rightLight.setFillColor( Color.YELLOW );
        rightLight.setFrameColor( Color.BLACK );
        rightLight.setSize( lightX, lightY );
        
        //--------------------------------------------

        // car in pad2
        wheel1 = new RoundedRectangle ( x2 + 5, y2 + 20 );
        wheel1.setColor( Color.BLACK );
        wheel1.setSize( wheelX, wheelY );
        
        wheel2 = new RoundedRectangle ( x2 + 59, y2 + 20 );
        wheel2.setColor( Color.BLACK );
        wheel2.setSize( wheelX, wheelY );
        
        wheel3 = new RoundedRectangle ( x2 + 5, y2 + 65 );
        wheel3.setColor( Color.BLACK );
        wheel3.setSize( wheelX, wheelY );
        
        wheel4 = new RoundedRectangle ( x2 + 59, y2 + 65 );
        wheel4.setColor( Color.BLACK );
        wheel4.setSize( wheelX, wheelY );
        
        body = new RoundedRectangle( x2 + 12, y2 + 12 );
        body.setFillColor( Color.BLUE );
        body.setFrameColor( Color.BLACK );
        body.setSize( 50, 79 );
        
        cab = new RoundedRectangle( x2 + 18, y2 + 32 );
        cab.setFillColor( Color.GREEN );
        cab.setFrameColor( Color.BLACK );
        cab.setSize( 37, 44 );
        
        steeringwheel = new Ellipse( x2 + 23, y2 + 38 );
        steeringwheel.setFillColor( Color.GREEN );
        steeringwheel.setFrameColor( Color.BLACK );
        steeringwheel.setSize( 10, 5 );
        
        leftSeat = new RoundedRectangle( x2 + 21, y2 + 47 );
        leftSeat.setFillColor( Color.YELLOW );
        leftSeat.setFrameColor( Color.BLACK );
        leftSeat.setSize( seatX, seatY );
        
        rightSeat = new RoundedRectangle( x2 + 38, y2 + 47 );
        rightSeat.setFillColor( Color.YELLOW );
        rightSeat.setFrameColor( Color.BLACK );
        rightSeat.setSize( seatX, seatY );
        
        rollbar = new Rectangle( x2 + 16, y2 + 67 );
        rollbar.setFillColor( Color.RED );
        rollbar.setFrameColor( Color.BLACK );
        rollbar.setSize( 42, 4 );
        
        bumper1 = new Line( x2 + 23, y2 + 12, x2 + 51, y2 + 12 );
        bumper1.setThickness( 3 );
        bumper1.setColor( Color.GRAY );
        
        bumper2 = new Line( x2 + 21, y2 + 90, x2 + 52, y2 + 90 );
        bumper2.setThickness( 3 );
        bumper2.setColor( Color.GRAY );
        
        leftLight = new Ellipse( x2 + 21, y2 + 10 );
        leftLight.setFillColor( Color.YELLOW );
        leftLight.setFrameColor( Color.BLACK );
        leftLight.setSize( lightX, lightY );
        
        rightLight = new Ellipse( x2 + 45, y2 + 10 );
        rightLight.setFillColor( Color.YELLOW );
        rightLight.setFrameColor( Color.BLACK );
        rightLight.setSize( lightX, lightY );
    } 
    
    // -----------------------------------------------------------------
    /** main program just invokes the class constructor.
     */
    public static void main(String[] args)
    {
        Program2 app = new Program2();
    }
}//End of Class Program2