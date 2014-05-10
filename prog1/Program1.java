/** 
 * Carmen St. Jean
 * CS 415 Spring 2008
 * 
 * Homework 1, due January 29
 * 
 * Program1.java:
 * Displays a rectangle with a dunebuggy from an aerial view inside.
 * 
 */
public class Program1 extends wheelsunh.users.Frame
{
    //---------------- instance variables ------------------------------
    private wheelsunh.users.Rectangle pad, rollbar;
    private wheelsunh.users.RoundedRectangle body, cab, leftSeat, rightSeat, bumper2;
    private wheelsunh.users.RoundedRectangle wheel1, wheel2, wheel3, wheel4;
    private wheelsunh.users.Ellipse steeringwheel, leftLight, rightLight;
    private wheelsunh.users.Ellipse bumper1;
    
    // -----------------------------------------------------------------
    /** Constructor for the Program1 class.
     */
    public Program1 ( )
    {
        pad = new wheelsunh.users.Rectangle( 200, 200 );
        pad.setFillColor( java.awt.Color.WHITE );
        pad.setFrameColor( java.awt.Color.BLACK );
        pad.setSize( 75, 100 );
        //--------------------------------------------
        // add your code starting here
        wheel1 = new wheelsunh.users.RoundedRectangle ( 205, 220 );
        wheel1.setColor( java.awt.Color.BLACK );
        wheel1.setSize( 10, 20 );
        wheel2 = new wheelsunh.users.RoundedRectangle ( 259, 220 );
        wheel2.setColor( java.awt.Color.BLACK );
        wheel2.setSize( 10, 20 );
        wheel3 = new wheelsunh.users.RoundedRectangle ( 205, 265 );
        wheel3.setColor( java.awt.Color.BLACK );
        wheel3.setSize( 10, 20 );
        wheel4 = new wheelsunh.users.RoundedRectangle ( 259, 265 );
        wheel4.setColor( java.awt.Color.BLACK );
        wheel4.setSize( 10, 20 );
        body = new wheelsunh.users.RoundedRectangle( 212, 212 );
        body.setFillColor( java.awt.Color.BLUE );
        body.setFrameColor( java.awt.Color.BLACK );
        body.setSize( 50, 79 );        
        cab = new wheelsunh.users.RoundedRectangle( 218, 232 );
        cab.setFillColor( java.awt.Color.GREEN );
        cab.setFrameColor( java.awt.Color.BLACK );
        cab.setSize( 37, 44 );
        steeringwheel = new wheelsunh.users.Ellipse( 223, 238 );
        steeringwheel.setFillColor( java.awt.Color.GREEN );
        steeringwheel.setFrameColor( java.awt.Color.BLACK );
        steeringwheel.setSize( 10, 5 );
        leftSeat = new wheelsunh.users.RoundedRectangle( 221, 247 );
        leftSeat.setFillColor( java.awt.Color.YELLOW );
        leftSeat.setFrameColor( java.awt.Color.BLACK );
        leftSeat.setSize( 15, 14 );
        rightSeat = new wheelsunh.users.RoundedRectangle( 238, 247 );
        rightSeat.setFillColor( java.awt.Color.YELLOW );
        rightSeat.setFrameColor( java.awt.Color.BLACK );
        rightSeat.setSize( 15, 14 );
        rollbar = new wheelsunh.users.Rectangle( 216, 267 );
        rollbar.setFillColor( java.awt.Color.RED );
        rollbar.setFrameColor( java.awt.Color.BLACK );
        rollbar.setSize( 42, 4 );
        bumper1 = new wheelsunh.users.Ellipse( 221, 211 );
        bumper1.setSize( 32, 3 );
        bumper1.setFillColor( java.awt.Color.GRAY );
        bumper1.setFrameColor( java.awt.Color.BLACK );
        bumper2 = new wheelsunh.users.RoundedRectangle( 221, 290 );
        bumper2.setSize( 31, 3 );
        bumper2.setFillColor( java.awt.Color.GRAY );
        bumper2.setFrameColor( java.awt.Color.BLACK );
        leftLight = new wheelsunh.users.Ellipse( 221, 210 );
        leftLight.setFillColor( java.awt.Color.YELLOW );
        leftLight.setFrameColor( java.awt.Color.BLACK );
        leftLight.setSize( 8, 5 );
        rightLight = new wheelsunh.users.Ellipse( 245, 210 );
        rightLight.setFillColor( java.awt.Color.YELLOW );
        rightLight.setFrameColor( java.awt.Color.BLACK );
        rightLight.setSize( 8, 5 );
    } 
    
    // -----------------------------------------------------------------
    /** main program just invokes the class constructor.
     */
    public static void main(String[] args)
    {
        Program1 app = new Program1();
    }
}//End of Class Program1
