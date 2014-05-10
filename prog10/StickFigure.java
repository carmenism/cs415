/**
 * StickFigure.java
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, April 15, 2008
 * 
 * For use with Program10.java
 */

import wheelsunh.users.*;
import java.awt.Color;

public class StickFigure
{
   //------------------------- instance variables ------------------------------
   private Ellipse head, eye1, eye2;
   private RoundedRectangle tongue;
   private Rectangle white;
   private Line leftArm, rightArm, torso, leftLeg, rightLeg,
                noose, topBeam, sideBeam, baseBeam;
   private int xLocation, yLocation;
   private Color brown = new Color( 100,  75, 10 );
   private Color tan   = new Color( 200, 170, 50 );
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------

   /**
    * StickFigure( int x, int y )
    *    Draws gallows and stick figured at the desired location.  The stick
    *    figure itself is hidden.
    * x, y: desired location in screen coordinates.
    */
   public StickFigure( int x, int y )
   {
      xLocation = x;
      yLocation = y;
      
      noose = new Line( xLocation + 85, yLocation,
                        xLocation + 85, yLocation + 40 );
      noose.setColor( tan );
      noose.setThickness( 3 );
      
      topBeam = new Line( xLocation + 85,  yLocation,
                          xLocation + 185, yLocation );
      topBeam.setColor( brown );
      topBeam.setThickness( 4 );
      
      sideBeam = new Line( xLocation + 185, yLocation,
                           xLocation + 185, yLocation + 270 );
      sideBeam.setColor( brown );
      sideBeam.setThickness( 4 );
      
      baseBeam = new Line( xLocation + 20,  yLocation + 270,
                           xLocation + 225, yLocation + 270 );
      baseBeam.setColor( brown );
      baseBeam.setThickness( 4 );
      
      head = new Ellipse( xLocation + 60, yLocation + 40 );
      head.setSize( 50, 50 );
      head.setFillColor( Color.WHITE );
      head.setFrameColor( Color.BLACK );
      head.hide( );
      
      eye1 = new Ellipse( xLocation + 68, yLocation + 54 );
      eye1.setSize( 8, 8 );
      eye1.setFillColor( Color.WHITE );
      eye1.setFrameColor( Color.BLACK );
      eye1.hide( );
      
      eye2 = new Ellipse( xLocation + 93, yLocation + 54 );
      eye2.setSize( 8, 8 );
      eye2.setFillColor( Color.WHITE );
      eye2.setFrameColor( Color.BLACK );
      eye2.hide( );
      
      torso = new Line( xLocation + 85, yLocation + 50 + 40,
                        xLocation + 85 , yLocation + 125 + 40);
      torso.setColor( Color.BLACK );
      torso.setThickness( 1 );
      torso.hide( );
      
      leftArm = new Line( xLocation + 85, yLocation + 65 + 40,
                          xLocation + 65, yLocation + 100 + 40);
      leftArm.setColor( Color.BLACK );
      leftArm.setThickness( 1 );
      leftArm.hide( );
      
      rightArm = new Line( xLocation + 85,  yLocation + 65 + 40,
                           xLocation + 105, yLocation + 100 + 40);
      rightArm.setColor( Color.BLACK );
      rightArm.setThickness( 1 );
      rightArm.hide( );
      
      leftLeg = new Line( xLocation + 85, yLocation + 125 + 40,
                          xLocation + 65, yLocation + 190 + 40 );
      leftLeg.setColor( Color.BLACK );
      leftLeg.setThickness( 1 );
      leftLeg.hide( );
      
      rightLeg = new Line( xLocation + 85,  yLocation + 125 + 40,
                           xLocation + 105, yLocation + 190 + 40 );
      rightLeg.setColor( Color.BLACK );
      rightLeg.setThickness( 1 );
      rightLeg.hide( );
   }

   //---------------------------------------------------------------------------
   //------------------------- mutators ----------------------------------------

   /**
    * void reveal( int count )
    *    Will reveal a certain body part of the stickfigure.  The part revealed
    *    depends on the number passed in (a value from 1 to 6).
    * count: determines body part to be revealed.
    */   
   public void reveal( int count )
   {
      if ( count == 1 )
      {
         head.show( );
         eye1.show( );
         eye2.show( );
         
         Line mouth = new Line( xLocation + 65,  yLocation + 68,
                                xLocation + 105, yLocation + 68 );
         mouth.setColor( Color.BLACK );
      }
      
      if ( count == 2 )
         torso.show( );
      
      if ( count == 3 )
         leftArm.show( );
      
      if ( count == 4 )
         rightArm.show( );
      
      if ( count == 5 )
         leftLeg.show( );
      
      if ( count == 6 )
      {
         rightLeg.show( );
         eye1.hide( );
         eye2.hide( );
         
         tongue = new RoundedRectangle( xLocation + 90, yLocation + 59 );
         tongue.setSize( 10, 20 );
         tongue.setFrameColor( Color.BLACK );
         tongue.setFillColor( Color.RED );
         white = new Rectangle( xLocation + 89, yLocation + 58 );
         white.setSize( 12, 10 );
         white.setColor( Color.WHITE );
         
         this.drawDeadEye( xLocation + 68, yLocation + 54 );
         this.drawDeadEye( xLocation + 93, yLocation + 54 );
         
         Line mouth = new Line( xLocation + 65,  yLocation + 68,
                                xLocation + 105, yLocation + 68 );
         mouth.setColor( Color.BLACK );
      }
   }
   
   //---------------------------------------------------------------------------

   /**
    * void drawDeadEye( int x, int y )
    *    Draws an X-shaped "dead" eye at the desired location.
    * x, y: desired location in screen coordinates.
    */
   public void drawDeadEye( int x, int y)
   {
      Line line1 = new Line( x, y,    
                             x + 8, y + 8 );
      line1.setColor( Color.BLACK );
      Line line2 = new Line( x + 8, y,
                             x,     y + 8 );
      line2.setColor( Color.BLACK );
   }
      
   //---------------------------------------------------------------------------
   // main method for testing this class
   public static void main( String args[ ] )
   {
      Frame f = new Frame( );
      StickFigure s = new StickFigure( 10, 10 );
   }
}