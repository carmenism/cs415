/** 
 * Buggy.java creates dune buggies.  The mutator methods can change
 *   the buggy's color, change its location, move it forward or in
 *   reverse, put it into stealth mode, and put it back into normal
 *   mode.  The accessor methods can get the buggy's color, x-location
 *   and y-location.  For use in Program4.java.
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, February 19, 2008
 */

// --------------- imports ------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;

public class Buggy 
{  
    // ----- instance variables -------------------------------------
    Rectangle rollbar;              //rollbar of buggy
    RoundedRectangle body, cab;     //body and cab of buggy
    RoundedRectangle leftSeat, rightSeat; //seats
    RoundedRectangle wheel1, wheel2, wheel3, wheel4;  //wheels
    Ellipse steeringwheel;          //steering wheel
    Ellipse leftLight, rightLight;  //headlights
    Line bumper1, bumper2;          //front and rear bumpers
    int  xLocation, yLocation;              // ( x, y ) location
    int padX = 75, padY = 100;              //pad dimensions
    int wheelX = 10, wheelY = 20;           //wheel dimensions
    int lightX = 8, lightY = 5;             //headlight dimensions
    int seatX = 15, seatY = 14;             //seat dimension
    Color bodyColor, tempColorSave;         //color of main component
    
    // ----- contructor for the Buggy class -------------------------
    /**
     * Buggy( )
     *     This constructor accepts no parameters and passes along both the
     *     default location ( 0, 0 ) and default color, blue, to the makeBuggy
     *     method.
     */
    public Buggy( )
    {   
       xLocation = 0;              // default location
       yLocation = 0;
       bodyColor = Color.BLUE;     // default color
       makeBuggy( xLocation, yLocation, bodyColor );
    }

    /**
     * Buggy( int x, int y )
     *     This constructor has ( x, y ) parameters, which is passes along
     *     the makeBuggy method to set the location of the buggy.  It also
     *     passes the default color, blue.
     * x, y: define the desired location in screen coordinates
     */
    public Buggy( int x, int y )
    {
       xLocation = x;
       yLocation = y;
       bodyColor = Color.BLUE;     // default color
       makeBuggy( xLocation, yLocation, bodyColor );
    }
    
    /**
     * Buggy( Color c )
     *     This constructor accepts a color for a parameter and passes
     *     it along to the makeBuggy method.  It uses the default location
     *     at ( 0, 0 ).
     * c: defines the desired color of the main component of the buggy
     */
    public Buggy( Color c )
    {  
       xLocation = 0;              // default location
       yLocation = 0;
       bodyColor = c;
       makeBuggy( xLocation, yLocation, bodyColor );
    }
    
    /**
     * makeBuggy( int x, int y, Color c )
     *     A private method only used by the constructors in the Buggy class
     *     to create a buggy at the given location with the given color.
     * x, y: define the desired location in screen coordinates
     * c: defines the desired color of the main component of the buggy
     */
    private void makeBuggy( int x, int y, Color c )
    {      
       xLocation = x;         // default location
       yLocation = y;
       bodyColor = c;
      
       wheel1 = new RoundedRectangle ( xLocation + 5, yLocation + 20 );
       wheel1.setColor( Color.BLACK );
       wheel1.setSize( wheelX, wheelY );
        
       wheel2 = new RoundedRectangle ( xLocation + 59, yLocation + 20 );
       wheel2.setColor( Color.BLACK );
       wheel2.setSize( wheelX, wheelY );
        
       wheel3 = new RoundedRectangle ( xLocation + 5, yLocation + 65 );
       wheel3.setColor( Color.BLACK );
       wheel3.setSize( wheelX, wheelY );
        
       wheel4 = new RoundedRectangle ( xLocation + 59, yLocation + 65 );
       wheel4.setColor( Color.BLACK );
       wheel4.setSize( wheelX, wheelY );
        
       body = new RoundedRectangle( xLocation + 12, yLocation + 12 );
       body.setFillColor( bodyColor );
       body.setFrameColor( Color.BLACK );
       body.setSize( 50, 79 );
        
       cab = new RoundedRectangle( xLocation + 18, yLocation + 32 );
       cab.setFillColor( bodyColor.darker() );
       cab.setFrameColor( Color.BLACK );
       cab.setSize( 37, 44 );
       
       steeringwheel = new Ellipse( xLocation + 23, yLocation + 38 );
       steeringwheel.setFillColor( bodyColor.darker() );
       steeringwheel.setFrameColor( Color.BLACK );
       steeringwheel.setSize( 10, 5 );
       
       leftSeat = new RoundedRectangle( xLocation + 21, yLocation + 47 );
       leftSeat.setFillColor( Color.YELLOW );
       leftSeat.setFrameColor( Color.BLACK );
       leftSeat.setSize( seatX, seatY );
        
       rightSeat = new RoundedRectangle( xLocation + 38, yLocation + 47 );
       rightSeat.setFillColor( Color.YELLOW );
       rightSeat.setFrameColor( Color.BLACK );
       rightSeat.setSize( seatX, seatY );
       
       rollbar = new Rectangle( xLocation + 16, yLocation + 67 );
       rollbar.setFillColor( bodyColor );
       rollbar.setFrameColor( Color.BLACK );
       rollbar.setSize( 42, 4 );
        
       bumper1 = new Line( xLocation + 23, yLocation + 12,
                           xLocation + 51, yLocation + 12 );
       bumper1.setThickness( 3 );
       bumper1.setColor( Color.GRAY );
       
       bumper2 = new Line( xLocation + 21, yLocation + 90,
                           xLocation + 52, yLocation + 90 );
       bumper2.setThickness( 3 );
       bumper2.setColor( Color.GRAY );
        
       leftLight = new Ellipse( xLocation + 21, yLocation + 10 );
       leftLight.setFillColor( Color.YELLOW );
       leftLight.setFrameColor( Color.BLACK );
       leftLight.setSize( lightX, lightY );
       
       rightLight = new Ellipse( xLocation + 45, yLocation + 10 );
       rightLight.setFillColor( Color.YELLOW );
       rightLight.setFrameColor( Color.BLACK );
       rightLight.setSize( lightX, lightY );
    }
    
    // ----- mutators for the Buggy class ---------------------------
    
    /**
     * setLocation( int x, int y )
     *     This method moves the given buggy to the coordinates specified
     *     in the given parameters.
     * x, y: define the new desired location in screen coordinates
     */
    public void setLocation( int x, int y )
    {
       xLocation = x;
       yLocation = y;
       wheel1.setLocation( xLocation + 5, yLocation + 20 );
       wheel2.setLocation( xLocation + 59, yLocation + 20 );
       wheel3.setLocation( xLocation + 5, yLocation + 65 );
       wheel4.setLocation( xLocation + 59, yLocation + 65 );
       body.setLocation( xLocation + 12, yLocation + 12 );
       cab.setLocation( xLocation + 18, yLocation + 32 );
       steeringwheel.setLocation( xLocation + 23, yLocation + 38 );
       leftSeat.setLocation( xLocation + 21, yLocation + 47 );
       rightSeat.setLocation( xLocation + 38, yLocation + 47 );
       rollbar.setLocation( xLocation + 16, yLocation + 67 );
       bumper1.setLocation( xLocation + 23, yLocation + 12 );
       bumper2.setLocation( xLocation + 21, yLocation + 90 );
       leftLight.setLocation( xLocation + 21, yLocation + 10 );
       rightLight.setLocation( xLocation + 45, yLocation + 10 );
    }
    
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
     * moveForward( int moveAmount )
     *     This method moves the buggy with the amount specified in the parameter.
     *     A positive value will move the buggy forward; a negative value will move
     *     the buggy in reverse.
     * moveAmount: defines the desired distance the buggy will be moved
     */
    public void moveForward( int moveAmount )
    {
       yLocation -= moveAmount;
       this.setLocation( xLocation, yLocation );
    }
    
    /**
     * steathOn( )
     *      This method changes the color of the main components of the buggy to
     *      gray.  This action can be "undone" by the stealthOff method.
     */
    public void stealthOn( )
    {
       tempColorSave = this.getColor( );
       this.setColor( Color.GRAY );
       bodyColor = tempColorSave;
    }
    
    /**
     * steathOff( )
     *     After a buggy has been turned grey by the stealthOn method, this method
     *     changes the main components of the buggy to its original color.
     */
    public void stealthOff( )
    {
       this.setColor( bodyColor );
    }
    
    // ----- accessors for the Buggy class --------------------------
    
    /** getColor( )
      *     This method gets the color of the main component of the buggy.
      * returns: Color bodyColor
      */
    public Color getColor( )
    {
       return bodyColor;
    }
    
    /**
     * getXLocation( )
     *     This method gets the x-location of the buggy's screen coordinates.
     * returns: int xLocation
     */
    public int getXLocation( )
    {
       return xLocation;
    }

    /**
     * getYLocation( )
     *     This method gets the y-location of the buggy's screen coordinates.
     * returns: int yLocation
     */
    public int getYLocation( )
    {
       return yLocation;
    }
    
    // --------------------------------------------------------------
    /** main program just invokes the class constructor.
     */
    public static void main(String[] args)
    {
        // Frame f = new Frame();
        Buggy app = new Buggy( );
      /*
        Buggy test1 = new Buggy( 100, 100 );
        Buggy test2 = new Buggy( Color.YELLOW );
        app.setColor( Color.GREEN );
        app.setLocation( 400, 150 );
        app.moveForward( 150 );
        app.moveForward( -200 );
        app.stealthOn( );
        app.stealthOff( ); */
    }
}//End of Class Buggy


      
