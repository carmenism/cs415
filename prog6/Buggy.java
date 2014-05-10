/** 
 * Buggy.java
 *   This class creates dune buggies to race in Program6.
 *   Methods:
 *    - Mutators: setColor, setLocation, setWeight, setHP, setName
 *    - Accessors: getColor, getXLocation, getYLocation, getWeight, getHP, getName
 *    - Show HP and Weight: mousePressed
 *    - Hide HP and Weight: mouseReleased
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, March 4, 2008
 * 
 * History:
 *   23 February 2008 - created for Program5
 *   1 March 2008 - edited for use with Program6
 */

//----------------------- imports -----------------------------------------------------
import wheelsunh.users.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;

public class Buggy extends ShapeGroup implements Racer
{  
   //------------------------- instance variables -------------------------------------
   protected Rectangle rollbar;                   // rollbar of buggy
   protected RoundedRectangle body, cab, leftSeat, rightSeat;
                                                  // body and cab of buggy and seats
   protected RoundedRectangle wheel1, wheel2, wheel3, wheel4; // wheels
   protected Ellipse steeringwheel, leftLight, rightLight;
                                                  // steering wheel and headlights
   protected Line bumper1, bumper2;               // front and rear bumpers
   protected int xLocation, yLocation;            // ( x, y ) location
   protected Color bodyColor, tempColorSave;      // color of main component
   protected Color lightgray = Color.GRAY.brighter( );  // light gray
   protected int buggyWeight = 0, buggyHP = 0;    // weight and HP intialized to zero
   protected String buggyName = "00";             // name intialized to zero
   protected TextBox nameBox, infoBox;            // box for name, box for weight & HP
   
   //----------------------------------------------------------------------------------
   //------------------------- constructor --------------------------------------------
   
   /**
    * Buggy( )
    *     This constructor accepts no parameters to create a buggy at default location
    *     ( 0, 0 ) with default color blue.
    */
   public Buggy( )
   {  
      this( 0, 0, Color.BLUE );
   }

   //----------------------------------------------------------------------------------
   
   /**
    * Buggy( Color c )
    *     This constructor creates a buggy at default location ( 0, 0 ) with the color
    *     specified in the parameter.
    * c: defines the desired color of the main component of the buggy
    */
   public Buggy( Color c )
   {
      this( 0, 0, c );
   }
   
   //----------------------------------------------------------------------------------
   
   /**
    * Buggy( int x, int y )
    *     This constructor creates a buggy at default location ( x, y ) with default
    *     color blue.
    * x, y: define the desired location in screen coordinates
    */
   public Buggy( int x, int y )
   {
      this( x, y, Color.BLUE );
   }
   
   //----------------------------------------------------------------------------------
   
   /**
    * Buggy( int x, int y, Color c )
    *     This constructor creates a buggy at the location ( x, y ) as specified in the
    *     parameters with the specified color.
    * x, y: define the desired location in screen coordinates
    * c: desired color of main portion of buggy
    */
   public Buggy( int x, int y, Color c )
   {
      xLocation = x;
      yLocation = y;
      bodyColor = c;
      
      wheel1 = new RoundedRectangle( xLocation, yLocation + 10 );
      wheel1.setColor( Color.BLACK );
      wheel1.setSize( 10, 20 );
       
      wheel2 = new RoundedRectangle( xLocation + 54, yLocation + 10 );
      wheel2.setColor( Color.BLACK );
      wheel2.setSize( 10, 20 );
       
      wheel3 = new RoundedRectangle( xLocation, yLocation + 55 );
      wheel3.setColor( Color.BLACK );
      wheel3.setSize( 10, 20 );
       
      wheel4 = new RoundedRectangle( xLocation + 54, yLocation + 55 );
      wheel4.setColor( Color.BLACK );
      wheel4.setSize( 10, 20 );
       
      body = new RoundedRectangle( xLocation + 7, yLocation + 2 );
      body.setFillColor( bodyColor );
      body.setFrameColor( Color.BLACK );
      body.setSize( 50, 79 );
       
      cab = new RoundedRectangle( xLocation + 13, yLocation + 24 );
      cab.setFillColor( bodyColor.darker() );
      cab.setFrameColor( Color.BLACK );
      cab.setSize( 37, 44 );
      
      steeringwheel = new Ellipse( xLocation + 17, yLocation + 30 );
      steeringwheel.setFillColor( bodyColor.darker() );
      steeringwheel.setFrameColor( Color.BLACK );
      steeringwheel.setSize( 10, 5 );
      
      leftSeat = new RoundedRectangle( xLocation + 15, yLocation + 39 );
      leftSeat.setFillColor( Color.YELLOW );
      leftSeat.setFrameColor( Color.BLACK );
      leftSeat.setSize( 15, 14 );
       
      rightSeat = new RoundedRectangle( xLocation + 33, yLocation + 39 );
      rightSeat.setFillColor( Color.YELLOW );
      rightSeat.setFrameColor( Color.BLACK );
      rightSeat.setSize( 15, 14 );
      
      rollbar = new Rectangle( xLocation + 11, yLocation + 59 );
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
      leftLight.setSize( 8, 5 );
      
      rightLight = new Ellipse( xLocation + 40, yLocation );
      rightLight.setFillColor( Color.YELLOW );
      rightLight.setFrameColor( Color.BLACK );
      rightLight.setSize( 8, 5 );
      
      nameBox = new TextBox( buggyName );
      nameBox.setLocation( xLocation + 23, yLocation + 6 );
      nameBox.setBorderWidth( 1 );
      nameBox.setSize( new Dimension(18, 23) );
      
      infoBox = new TextBox( "HP " + buggyHP + "\nWeight " + buggyWeight );
      infoBox.setLocation( xLocation + 70, yLocation );
      infoBox.setBorderWidth( 1 );
      infoBox.setSize( new Dimension(70, 40) );
      infoBox.hide();
      
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
      this.add( nameBox );
      this.add( infoBox );
   }
   
   //----------------------------------------------------------------------------------
   //------------------------- mutators -----------------------------------------------

   /**
    * setColor( Color c )
    *     This method changes the main components of the buggy to the color given in
    *     the parameters.
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
   
   //----------------------------------------------------------------------------------
   //------------------------- accessors ----------------------------------------------
     
   /** Color getColor( )
    *     This method gets the color of the main component of the buggy.
    * returns: bodyColor
    */
   public Color getColor( )
   {
      return bodyColor;
   }
    
   //----------------------------------------------------------------------------------
   //--------------- mutators from the Racer interface --------------------------------
   
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
      nameBox.setLocation( xLocation + 23, yLocation + 6 );
      infoBox.setLocation( xLocation + 70, yLocation );
   }
   
   //----------------------------------------------------------------------------------
   
   /**
    * void setWeight( int weight )
    *     Changes the buggy's weight to a new weight (a value
    *     between 290 and 450).
    * weight: desired weight
    */
   public void setWeight( int weight )
   {
      buggyWeight = weight;
      infoBox.setText( "HP " + buggyHP + "\nWeight " + buggyWeight );
   }
   
   //----------------------------------------------------------------------------------
   
   /**
    * void setHP( int hp )
    *     Changes the buggy's HP to a new HP (a value between
    *     90 and 195).
    * hp: desired HP
    */
   public void setHP( int hp )
   {
      buggyHP = hp;
      infoBox.setText( "HP " + buggyHP + "\nWeight " + buggyWeight );
   }
   
   //----------------------------------------------------------------------------------
   
   /**
    * void setName( String n )
    *     Changes the buggy's name to a new name (a integer 00
    *     to 99 stored in a string).
    * n: desired name as a string
    */
   public void setName( String n )
   {
      buggyName = n;
      nameBox.setText( buggyName );
   }
   
   //----------------------------------------------------------------------------------
   //--------------- accessors from the Racer interface -------------------------------
   
   /**
    * int getWeight( )
    *     Returns the weight of the buggy.
    * returns: buggyWeight
    */
   public int getWeight( )
   {
      return buggyWeight;
   }
   
   //----------------------------------------------------------------------------------
   
   /**
    * int getHP( )
    *     Returns the HP of the buggy.
    * returns: buggyHP
    */
   public int getHP( )
   {
      return buggyHP;
   }
   
   //----------------------------------------------------------------------------------
   
   /**
    * String getHP( )
    *     Returns the name of the buggy.
    * returns: buggyName
    */
   public String getName( )
   {
      return buggyName;
   }
   
   //----------------------------------------------------------------------------------
   
   /**
    * getXLocation( )
    *     Gets the x-location of the buggy's screen coordinates.
    * returns: xLocation
    */
   public int getXLocation( )
   {
      return xLocation;
   }
   
   //----------------------------------------------------------------------------------
   
   /**
    * getYLocation( )
    *     Gets the y-location of the buggy's screen coordinates.
    * returns: yLocation
    */
   public int getYLocation( )
   {
      return yLocation;
   }
   
   //----------------------------------------------------------------------------------
   //------------------ Show HP and Weight --------------------------------------------
      
   /*
    * void mousePressed( MouseEvent e )
    *     Shows a text box containing the HP and weight of the buggy.
    */
   public void mousePressed( MouseEvent e)
   {
      infoBox.show( );
   }
   
   //----------------------------------------------------------------------------------
   //------------------ Hide HP and Weight --------------------------------------------

   /*
    * void mouseReleased( MouseEvent e )
    *     Hides the text box containing the HP and weight of the buggy.
    */
   public void mouseReleased( MouseEvent e)
   {
      infoBox.hide( );
   }
   
   //----------------------------------------------------------------------------------
   /** main program just invokes the class constructor.
    */
   public static void main(String[] args)
   {
      Frame f = new Frame();
      Buggy app = new Buggy( );
      app.setName( "15" );
      app.setColor( Color.GREEN );
      app.setLocation( 400, 150 );
      app.setHP( 222 );
      app.setWeight( 250 );
   }
}// End of Class Buggy
//---- 87 characters wide -------------------------------------------------------------