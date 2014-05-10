/**
 * MarkerGroup.java
 *    For Program13.
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, May 6, 2008
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Point;
import java.util.*;

public class MarkerGroup extends Rectangle implements MarkerInterface, Draggable
{
   //------------------------- instance variables ------------------------------
   private Vector<Marker> myMarkers = new Vector<Marker>();
   private Point lastMousePosition;
   private LastMarker lastMarker;
   private boolean hidden;
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------

   /**
    * MarkerGroup(LastMarker last)
    *    This constructor takes a last marker to create the marker group.
    *    The group itself is indicated by a transparent rectangle with a red
    *    outline.
    */
   public MarkerGroup(LastMarker last)
   {
      super(0,0);
      setFillColor(new Color(0, 0, 0, 0));
      setFrameColor(Color.RED);
      lastMarker = last;
      this.hide();
      hidden = true;
   }
   
   //---------------------------------------------------------------------------
   //------------------------- mutators ----------------------------------------

   /**
    * void clear()
    *    This method clears all markers from the group and hides the red outline
    *    of the rectangle.
    */
   public void clear()
   {
      myMarkers.clear();
      this.hide();
      hidden = true;
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * void addMarker(Marker m)
    *    This method adds a marker to the group.  The minimum and maximum
    *    boundaries for the group will be recalculated and updated.
    */
   public void addMarker(Marker m)
   {
      myMarkers.add(m);
      if (hidden)
      {
         this.show();
         hidden = true;
      }
      int minX = 800, minY = 800, maxX = -1, maxY = -1;
      Iterator<Marker> iter = myMarkers.iterator();
      while (iter.hasNext())
      {
         Marker next = iter.next();
         if (next.getXLocation() - next.getSize()/2 < minX)
            minX = next.getXLocation() - next.getSize()/2;
         if (next.getYLocation() - next.getSize()/2 < minY)
            minY = next.getYLocation() - next.getSize()/2;   
         if (next.getXLocation() + next.getSize()/2 >= maxX)
            maxX = next.getXLocation() + next.getSize()/2;
         if (next.getYLocation() + next.getSize()/2 >= maxY)
            maxY = next.getYLocation() + next.getSize()/2;
      }
      this.setLocation(minX - 3, minY - 3);
      this.setSize(maxX - minX + 6, maxY - minY + 6);
      lastMarker.set(this);
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * void toggleType()
    *    Sends messages to all markers in the group to toggle the type.
    */
   public void toggleType()
   {
      if (myMarkers == null || myMarkers.size() == 0)
         return;
      else
      {
         for (int i = 0; i < myMarkers.size(); i++)
            if (myMarkers.get(i) != null)
               (myMarkers.get(i)).toggleType();
      }
   }
   
   //---------------------------------------------------------------------------
  
   /**
    * void setColor(Color c)
    *    Sends messages to all markers in the group to change to the specified
    *    color.
    */
   public void setColor(Color c)
   {
      if (myMarkers == null || myMarkers.size() == 0)
         return;
      else
      {
         for (int i = 0; i < myMarkers.size(); i++)
            if (myMarkers.get(i) != null)
               (myMarkers.get(i)).setColor(c);
      }
   }
   
   //---------------------------------------------------------------------------
   //------------------------- mouse methods -----------------------------------
   
   /**
    * void mousePressed(java.awt.event.MouseEvent e)
    *    Saves the mouse position for use in the mouseDragged method.
    */
   public void mousePressed(java.awt.event.MouseEvent e)
   {
      lastMousePosition = e.getPoint();
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * void mouseDragged(java.awt.event.MouseEvent e)
    *    Calculates how much each marker in the group should move as the mouse
    *    is dragged.
    */
   public void mouseDragged(java.awt.event.MouseEvent e)
   {
      Point currentPoint = e.getPoint();
      int dX = currentPoint.x - lastMousePosition.x;
      int dY = currentPoint.y - lastMousePosition.y;
      setLocation(getLocation().x + dX, getLocation().y + dY);
      for (int i = 0; i < myMarkers.size(); i++)
         (myMarkers.elementAt(i)).setLocation(
                                    myMarkers.elementAt(i).getXLocation() + dX,
                                    myMarkers.elementAt(i).getYLocation() + dY);
      lastMousePosition = currentPoint;
   }
   
   //---------------------------------------------------------------------------
   //------------------------- main method -------------------------------------
   
   public static void main(String [] args)
   {
      Frame f = new Frame();
      MarkerSpecifications ms = new MarkerSpecifications();
      LastMarker ls = new LastMarker();
      MarkerGroup mg = new MarkerGroup(ls);
      Marker marker1 = new Marker(100, 200, ms, mg);
      Marker marker2 = new Marker(200, 100, ms, mg);
      mg.addMarker(marker1);
      mg.addMarker(marker2);
      mg.toggleType();
      mg.setColor(Color.BLUE);
   }
}