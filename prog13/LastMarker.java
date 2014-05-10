/**
 * LastMarker.java
 *    For Program13.
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, May 6, 2008
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.*;

public class LastMarker implements MarkerInterface
{
   //------------------------- instance variables ------------------------------
   private int myType;
   private MarkerInterface target;

   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------

   /**
    * LastMarker()
    *    This no-argument constructor initializes the last marker target as
    *    null.
    */
   public LastMarker()
   {
      target = null;
   }

   //---------------------------------------------------------------------------
   //------------------------- mutators ----------------------------------------

   /**
    * void set(MarkerInterface aMarker)
    *    Sets the target of the last marker to be the specified marker (or
    *    marker group).
    */
   public void set(MarkerInterface aMarker)
   {
      target = aMarker;   
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * void toggleType()
    *    Changes the type of the last marker from rectangle to circle or circle
    *    to rectangle.
    */
   public void toggleType()
   {
      if (myType == 0)
         myType = 1;
      else
         myType = 0;
      target.toggleType();
   }
   
   //---------------------------------------------------------------------------
  
   /**
    * void setColor(Color c)
    *    Sends a message to the last marker to change to the specified color.
    */
   public void setColor(Color c)
   {
      target.setColor( c );
   }

   //---------------------------------------------------------------------------
   //------------------------- accessors ---------------------------------------

   /**
    * MarkerInterface get()
    *    Returns the current last marker.
    */
   public MarkerInterface get()
   {
      return target;
   }
}