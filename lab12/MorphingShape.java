/* Edited by Carmen St. Jean for CS 415 (Spring 2008) Lab 12
 *  March 25, 2008
 */

import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;


/** 
 *  MorphingShape.java:
 *  
 */
public class MorphingShape extends ShapeGroup
{ 
   //----------------- instance variables --------------------------------------

   private Rectangle r;
   private RoundedRectangle rr;
   private Ellipse e;
   private Boolean rShowing, rrShowing, eShowing;
   
   //------------------ constructors ---------------------------------------------
   public MorphingShape(int x, int y ) 
   {        
        r = new Rectangle( x, y );
        add( r );
        r.setColor( Color.GREEN );
        
        rr = new RoundedRectangle( x, y );
        add( rr );
        rr.setColor( Color.RED );
        
        e = new Ellipse( x, y );
        add( e );
        e.setColor( Color.BLUE );
        
        // hide all but one shape and remember which one is showing
        
        r.show( );
        rShowing = true;
        
        rr.hide( );
        rrShowing = false;
        
        e.hide( );
        eShowing = false;
   }
    

   //-----------------------------------------------------------------------------
   public void mouseClicked( MouseEvent me )
   {
         // change rectangle showing to rounded rectangle showing 
         // or rounded rectangle showing to ellipse showing 
         // or showing ellipse to rectangle showing 
      
         if ( rShowing )
         { 
            r.hide( );
            rShowing = false;
            rr.show( );
            rrShowing = true;
         }
         else if ( rrShowing )
         {
            rr.hide( );
            rrShowing = false;
            e.show( );
            eShowing = true;
         }
         else
         {
            e.hide( );
            eShowing = false;
            r.show( );
            rShowing = true;
         }    
   }
     
   
   //---------------------------- main -----------------------------------------
   public static void main( String[ ] args )      
   {
      Frame f = new Frame( );

      MorphingShape p = new MorphingShape( 400, 30 );
   }
}