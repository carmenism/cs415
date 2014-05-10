/**
 * MarkerSpecifications.java
 *    For Program13.
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, May 6, 2008
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.*;

public class MarkerSpecifications implements MarkerInterface
{
   //------------------------- instance variables ------------------------------
   private Color myColor;
   private int myType;

   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------

   /**
    * MarkerSpecifications()
    *    This no-argument constructor saves the default values for color (black)
    *    and type (square).
    */
   public MarkerSpecifications()
   {
       myColor = new Color(0,0,0);
       myType = 0;
   }

   //---------------------------------------------------------------------------
   //------------------------- accessors ---------------------------------------

   /**
    * Color getColor()
    *    Gets the current color.
    */
   public Color getColor()
   {
      return myColor;
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * int getType()
    *    Gets the current type.  (0 for rectangle, 1 for circle.)
    */
   public int getType()
   {
      return myType;
   }
   
   //---------------------------------------------------------------------------
   //------------------------- mutators ----------------------------------------

   /**
    * void setColor(Color c)
    *    Sets the color to the specified color c.
    */
   public void setColor(Color c)
   {
      myColor = c;
   }
  
   //---------------------------------------------------------------------------
   
   /**
    * void toggleType()
    *    Changes the type from rectangle to circle or circle to rectangle.
    */
   public void toggleType()
   {
      if (myType == 0)
         myType = 1;
      else
         myType = 0;
   }
}