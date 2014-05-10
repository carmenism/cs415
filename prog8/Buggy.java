/** 
 * Buggy.java
 *   This class creates dune buggies to race in Program6.
 *   Methods:
 *    - Mutators: driveTo, driveHome, setLocation
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, March 31, 2008
 * 
 * History:
 *   23 February 2008 - created for Program5
 *   1 March 2008 - edited for use with Program6
 *   10 March 2008 - edited for use with Program7
 *   30 March 2008 - edited for use with Program8
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

public class Buggy
{  
   //------------------------- instance variables ------------------------------
   private Rectangle rollbar;
   private RoundedRectangle body, cab, leftSeat, rightSeat;
   private RoundedRectangle wheel1, wheel2, wheel3, wheel4;
   private Ellipse steeringwheel, leftLight, rightLight;
   private Line bumper1, bumper2, blueLine;
   private int count, tempX, tempY, speed, pointCount = 0;
   private Color bodyColor, lightgray = Color.GRAY.brighter( );  //light gray
   private double distance;
   private Point lastPoint, currentPoint, tempPoint;
   private ArrayList<Point> pointsVisited;
   
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
      currentPoint = new Point( x, y );
      pointsVisited = new ArrayList<Point>();
      pointsVisited.add( pointCount, currentPoint );
      pointCount++;
      lastPoint = new Point( x, y ); 
      bodyColor = Color.BLUE;
      
      Utilities.drawPoint( currentPoint );
      
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
   }
   
   //---------------------------------------------------------------------------
   //------------------------- mutators ----------------------------------------
   
   /**
    * driveTo( Point p, int speed )
    *    Creates a small red cross at the new point and a line connecting this
    *    to the last point.  The buggy then moves to this point at the given
    *    speed.  Stores the new location in an array of all points visited.
    * p: the next desired location of the buggy
    * speed: speed at which the buggy will move 
    */
   public void driveTo( Point p, int speed )
   {
      lastPoint = currentPoint;
      currentPoint = p;
      pointsVisited.add( pointCount, currentPoint );
      pointCount++;
      
      Utilities.drawPoint( currentPoint );
      blueLine = new Line( lastPoint.x, lastPoint.y,
                            currentPoint.x, currentPoint.y );
      blueLine.setColor( Color.BLUE );
      
      distance = Math.sqrt( Math.pow( ( lastPoint.x - currentPoint.x ), 2 ) +
                            Math.pow( ( lastPoint.y - currentPoint.y ), 2 )  );
      count = (int)( distance / speed );
      
      for( int i = 0; i < count; i++ )
      {
         tempX =
           lastPoint.x + (int)( (currentPoint.x-lastPoint.x)* (i + 1) / count );
         tempY =
           lastPoint.y + (int)( (currentPoint.y-lastPoint.y)* (i + 1) / count );
         tempPoint = new Point( tempX, tempY );
         this.setLocation( tempPoint.x, tempPoint.y );
         Utilities.frame();
      }
  
      if( ( (int)distance % speed ) != 0 )
      {
         this.setLocation( currentPoint.x, currentPoint.y );
         Utilities.frame();
      }
   }

   //---------------------------------------------------------------------------

   /**
    * driveHome( )
    *    Uses the array of points visited to go in reverse towards home at a 
    *    speed of 10.
    */
   public void driveHome( )
   {
      speed = 10;
      for( int i = pointsVisited.size(); i > 1; i-- )
      {
         lastPoint = pointsVisited.get( i - 1 );
         currentPoint = pointsVisited.get( i - 2 );
         
         distance =
            Math.sqrt( Math.pow( ( lastPoint.x - currentPoint.x ), 2 ) +
                       Math.pow( ( lastPoint.y - currentPoint.y ), 2 )  );
         count = (int)( distance / speed );
         
         for( int j = 0; j < count; j++ )
         {
            tempX =
              lastPoint.x + (int)((currentPoint.x-lastPoint.x)*(j + 1)/count);
            tempY =
              lastPoint.y + (int)((currentPoint.y-lastPoint.y)*(j + 1)/count);
            tempPoint = new Point( tempX, tempY );
            this.setLocation( tempPoint.x, tempPoint.y );
            Utilities.frame();
         }
  
         if( ( (int)distance % speed ) != 0 )
         {
            this.setLocation( currentPoint.x, currentPoint.y );
            Utilities.frame();
         }
      }
   }
   
   //---------------------------------------------------------------------------
 
   /**
    * void setLocation( int x, int y )
    *     This method sets the location of the buggy to ( x, y ).
    * x, y: desired location in screen coordinates
    */
   public void setLocation( int x, int y )
   {
      wheel1.setLocation( x, y + 10 );
      wheel2.setLocation( x + 54, y + 10 );
      wheel3.setLocation( x, y + 55 );
      wheel4.setLocation( x + 54, y + 55 );
      body.setLocation( x + 7, y + 2 );
      cab.setLocation( x + 13, y + 24 );
      steeringwheel.setLocation( x + 17, y + 30 );
      leftSeat.setLocation( x + 15, y + 39 );
      rightSeat.setLocation( x + 33, y + 39 );
      rollbar.setLocation( x + 11, y + 59 );
      bumper1.setLocation( x + 18, y + 2 );
      bumper2.setLocation( x + 16, y + 81 );
      leftLight.setLocation( x + 16, y );
      rightLight.setLocation( x + 40, y );
   }
   
   //---------------------------------------------------------------------------
   // main method for testing
   public static void main(String[] args)
   {
      Frame f = new wheelsunh.users.Frame();
      Point p1 = new Point( 0, 300 );
      Point p2 = new Point( 400, 300 );
      Point p3 = new Point( 400, 200 );
      Buggy car = new Buggy( 0, 0 );
      car.driveTo( p2, 10 );
      car.driveTo( p1, 10 );
      car.driveTo( p3, 10 );
      car.driveHome();
   }
}// End of Class Buggy
//---- 80 characters wide ------------------------------------------------------