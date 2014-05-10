/** 
 * Buggy.java
 *   This class creates dune buggies to race in Program6.
 *   Methods:
 *    - Mutators: moveTo, setLocation, updateInfo
 *    - Accessors: getLocation
 *    - Mouse methods: mousePressed, mouseReleased
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, March 11, 2008
 * 
 * History:
 *   23 February 2008 - created for Program5
 *   1 March 2008 - edited for use with Program6
 *   10 March 2008 - edited for use with Program7
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class Buggy extends ShapeGroup
{  
   //------------------------- instance variables ------------------------------
   private Rectangle rollbar;
   private RoundedRectangle body, cab, leftSeat, rightSeat;
   private RoundedRectangle wheel1, wheel2, wheel3, wheel4;
   private Ellipse steeringwheel, leftLight, rightLight;
   private Line bumper1, bumper2, blueLine, redLine;
   private int xLocation, yLocation, totalDistance;
   private Color bodyColor, lightgray = Color.GRAY.brighter( );  //light gray
   private double distanceHome;
   private TextBox infoBox;
   private Point lastPoint, currentPoint;
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------
 
   /**
    * Buggy( int x, int y )
    *     This constructor creates a buggy at default location ( x, y ) with
    *     default color blue.
    * x, y: define the desired location in screen coordinates
    */
   public Buggy( int x, int y )
   {
      this( x, y, Color.BLUE );
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * Buggy( int x, int y, Color c )
    *     This constructor creates a buggy at the location ( x, y ) as specified
    *     in the parameters with the specified color.
    * x, y: define the desired location in screen coordinates
    * c: desired color of main portion of buggy
    */
   public Buggy( int x, int y, Color c )
   {
      currentPoint = new Point( x, y );
      lastPoint = new Point( x, y );
      bodyColor = c;
      
      wheel1 = new RoundedRectangle( currentPoint.x, currentPoint.y + 10 );
      wheel1.setColor( Color.BLACK );
      wheel1.setSize( 10, 20 );
       
      wheel2 = new RoundedRectangle( currentPoint.x + 54, currentPoint.y + 10 );
      wheel2.setColor( Color.BLACK );
      wheel2.setSize( 10, 20 );
       
      wheel3 = new RoundedRectangle( currentPoint.x, currentPoint.y + 55 );
      wheel3.setColor( Color.BLACK );
      wheel3.setSize( 10, 20 );
       
      wheel4 = new RoundedRectangle( currentPoint.x + 54, currentPoint.y + 55 );
      wheel4.setColor( Color.BLACK );
      wheel4.setSize( 10, 20 );
       
      body = new RoundedRectangle( currentPoint.x + 7, currentPoint.y + 2 );
      body.setFillColor( bodyColor );
      body.setFrameColor( Color.BLACK );
      body.setSize( 50, 79 );
       
      cab = new RoundedRectangle( currentPoint.x + 13, currentPoint.y + 24 );
      cab.setFillColor( bodyColor.darker() );
      cab.setFrameColor( Color.BLACK );
      cab.setSize( 37, 44 );
      
      steeringwheel = new Ellipse( currentPoint.x + 17, currentPoint.y + 30 );
      steeringwheel.setFillColor( bodyColor.darker() );
      steeringwheel.setFrameColor( Color.BLACK );
      steeringwheel.setSize( 10, 5 );
      
      leftSeat = new RoundedRectangle( currentPoint.x + 15,
                                       currentPoint.y + 39 );
      leftSeat.setFillColor( Color.YELLOW );
      leftSeat.setFrameColor( Color.BLACK );
      leftSeat.setSize( 15, 14 );
       
      rightSeat = new RoundedRectangle( currentPoint.x + 33,
                                        currentPoint.y + 39 );
      rightSeat.setFillColor( Color.YELLOW );
      rightSeat.setFrameColor( Color.BLACK );
      rightSeat.setSize( 15, 14 );
      
      rollbar = new Rectangle( currentPoint.x + 11, currentPoint.y + 59 );
      rollbar.setFillColor( bodyColor );
      rollbar.setFrameColor( Color.BLACK );
      rollbar.setSize( 42, 4 );
       
      bumper1 = new Line( currentPoint.x + 18, currentPoint.y + 2,
                          currentPoint.x + 46, currentPoint.y + 2 );
      bumper1.setThickness( 3 );
      bumper1.setColor( lightgray );
      
      bumper2 = new Line( currentPoint.x + 16, currentPoint.y + 81,
                          currentPoint.x + 47, currentPoint.y + 81 );
      bumper2.setThickness( 3 );
      bumper2.setColor( lightgray );
       
      leftLight = new Ellipse( currentPoint.x + 16, currentPoint.y );
      leftLight.setFillColor( Color.YELLOW );
      leftLight.setFrameColor( Color.BLACK );
      leftLight.setSize( 8, 5 );
      
      rightLight = new Ellipse( currentPoint.x + 40, currentPoint.y );
      rightLight.setFillColor( Color.YELLOW );
      rightLight.setFrameColor( Color.BLACK );
      rightLight.setSize( 8, 5 );
      
      infoBox = new TextBox( "Total Distance: " + totalDistance
                             + "\nDistance Home:\n" + distanceHome );
      infoBox.setLocation( currentPoint.x + 70, currentPoint.y );
      infoBox.setBorderWidth( 1 );
      infoBox.setSize( new Dimension(190, 60) );
      infoBox.hide( );
      
      redLine = new Line( currentPoint, currentPoint );
      redLine.setColor( Color.RED );

      this.add( wheel1 );
      this.add( wheel2 );
      this.add( wheel3 );
      this.add( wheel4 );
      this.add( body );
      this.add( cab );
      this.add( steeringwheel );
      this.add( leftSeat );
      this.add( rightSeat );
      this.add( rollbar );
      this.add( bumper1 );
      this.add( bumper2 );
      this.add( leftLight );
      this.add( rightLight );
      this.add( infoBox );
   }
   
   //---------------------------------------------------------------------------
   //------------------------- mutators ----------------------------------------
   
   /**
    * void moveTo( Point p )
    *     This method sets the location of the buggy to ( x, y ).
    * x, y: desired location in screencoordinates
    */
   public void moveTo( Point p )
   {
      lastPoint = currentPoint;
      currentPoint = p;

      blueLine = new Line( lastPoint, currentPoint );
      blueLine.setColor( Color.BLUE );
      
      if ( redLine != null )
         redLine.setPoints( 0, 0, currentPoint.x, currentPoint.y );
      
      this.updateInfo( );      
      this.setLocation( currentPoint.x, currentPoint.y );
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * void setLocation( int x, int y )
    *     This method sets the location of the buggy to ( x, y ).
    * x, y: desired location in screencoordinates
    */
   public void setLocation( int x, int y )
   {
      xLocation = x;
      yLocation = y;
      wheel1.setLocation( xLocation, yLocation + 10 );
      wheel2.setLocation( xLocation + 54, yLocation + 10 );
      wheel3.setLocation( xLocation, yLocation + 55 );
      wheel4.setLocation( xLocation + 54, yLocation + 55 );
      body.setLocation( xLocation + 7, yLocation + 2 );
      cab.setLocation( xLocation + 13, yLocation + 24 );
      steeringwheel.setLocation( xLocation + 17, yLocation + 30 );
      leftSeat.setLocation( xLocation + 15, yLocation + 39 );
      rightSeat.setLocation( xLocation + 33, yLocation + 39 );
      rollbar.setLocation( xLocation + 11, yLocation + 59 );
      bumper1.setLocation( xLocation + 18, yLocation + 2 );
      bumper2.setLocation( xLocation + 16, yLocation + 81 );
      leftLight.setLocation( xLocation + 16, yLocation );
      rightLight.setLocation( xLocation + 40, yLocation );
      infoBox.setLocation( xLocation + 70, yLocation );
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * void updateInfo( )
    *    If the infoBox is not null, then this method will update the total
    *    distance travelled and the distance home.
    */
   private void updateInfo( )
   {
      totalDistance += Math.sqrt( Math.pow( currentPoint.x - lastPoint.x, 2.0 )
                       + Math.pow( currentPoint.y - lastPoint.y, 2.0 ) );
      
      distanceHome = Math.sqrt( Math.pow( currentPoint.x, 2.0 ) +
                                Math.pow( currentPoint.y, 2.0 ) );

      if ( infoBox != null )
      {
         infoBox.setText( "Total Distance: " + totalDistance
                          + "\nDistance Home:\n" + distanceHome );
      }
   }
   
   //---------------------------------------------------------------------------
   //------------------------- accessors ---------------------------------------
     
   /**
    * Point getLocation( )
    *    This method returns the point where the buggy is located.
    */
   public Point getPoint( )
   {
      return currentPoint;
   }
   
   //---------------------------------------------------------------------------
   //-------------------------- mouse methods ----------------------------------
   
   /*
    * void mousePressed( MouseEvent e )
    *    Shows the text box containing the total distance and the distance home.
    */
   public void mousePressed( MouseEvent e)
   {
      infoBox.show( );
   }
   
   //---------------------------------------------------------------------------
  
   /*
    * void mouseReleased( MouseEvent e )
    *    Hides the text box containing the total distance and the distance home.
    */
   public void mouseReleased( MouseEvent e)
   {
      infoBox.hide( );
   }
   
   //---------------------------------------------------------------------------
   // main method for testing
   public static void main(String[] args)
   {
      Frame f = new Frame();
      Point p1 = new Point( 0, 300 );
      Point p2 = new Point( 400, 300 );
      Point p3 = new Point( 400, 200 );
      Buggy app = new Buggy( 0, 0, Color.GREEN );
      app.moveTo( p1 );
      app.moveTo( p2 );
      app.moveTo( p3 );
   }
}// End of Class Buggy
//---- 80 characters wide ------------------------------------------------------