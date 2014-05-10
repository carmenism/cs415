/**
 * Tile.java
 *    For Program12.
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, April 29, 2008
 */

//----------------------- imports ----------------------------------------------
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class Tile extends Rectangle
{
   //------------------------- instance variables ------------------------------
   private int visitCount, i, j, size;
   private boolean visitAbility, visitedBefore = false;
   private boolean [] visitableTiles;
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------
   
   /**
    * public Tile(int i, int j, int s, int status)
    *    This constructor creates a tile at the specified position with the
    *    specificed size.  A status of zero indicates it is a wall; a status of
    *    1 indicates it is an open passage-way.
    */
   public Tile(int i, int j, int s, int status)
   {
      super(  );
      size = s;
      this.i = i;
      this.j = j;
      setLocation( j * size, i * size );
      if (status == 0)
      {
         setFillColor(Color.BLACK);
         visitAbility = false;
      }
      else if (status == 1)
      {
         setFillColor(Color.WHITE);
         visitAbility = true;
      }
      setFrameColor( Color.GRAY );
      setSize( size, size );
      visitableTiles = new boolean[4];
   }
   
   //---------------------------------------------------------------------------
   //------------------------- mutators ----------------------------------------
   
   /**
    * void setRed()
    *    Sets the fill color of the tile to green.
    */
   public void setGreen()
   {
      setFillColor(Color.GREEN);
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * void setYellow()
    *    Sets the fill color of the tile to yellow.
    */
   public void setYellow()
   {
      setFillColor(Color.YELLOW);
      visitAbility = false;
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * void setRed()
    *    Sets the fill color of the tile to red.
    */
   public void setRed()
   {
      setFillColor(Color.RED);
   }
   
   //---------------------------------------------------------------------------
   //------------------------- accessors ---------------------------------------

   /**
    * int getI()
    *    Returns the i-"coordinate" of the tile (what row it is in).
    */
   public int getI()
   {
      return i;  
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * int getJ()
    *    Returns the j-"coordinate" of the tile (what column it is in).
    */
   public int getJ()
   {
      return j;  
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * void tellInfo(boolean [] arr)
    *    Copies in the information about the surround rooms (their
    *    "visitability").
    */
   public void tellInfo(boolean [] arr)
   {
      for (int i = 0; i < 4; i++)
         visitableTiles[i] = arr[i];
      visitedBefore = true;
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * boolean canVisit()
    *    Tells the RoomInfo class if it is possible to visit this room.
    */
   public boolean canVisit()
   {   
      return visitAbility;  
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * boolean beenVisitedBefore()
    *    Tells the RoomInfo class if this room has been visited before.
    */
   public boolean beenVisitedBefore()
   {
      return visitedBefore;
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * boolean [] getInfo()
    *    Gets the array of booleans containing information about the tiles
    *    surrounding this tile.
    */
   public boolean [] getInfo()
   {
      return visitableTiles;
   }
} 
