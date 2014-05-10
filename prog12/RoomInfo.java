/**
 * RoomInfo.java
 *    For Program12.
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, April 29, 2008
 */

//----------------------- imports ----------------------------------------------
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class RoomInfo
{
   //------------------------- instance variables ------------------------------
   private Tile [][] maze;
   private int currentI, currentJ, previousI, previousJ, row, col;
   private boolean [] visitableTiles; // = new boolean[4];
   private static final int NORTH = 0;
   private static final int EAST  = 1;
   private static final int SOUTH = 2;
   private static final int WEST  = 3;
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------

   public RoomInfo(Tile [][] arr, int prvI, int prvJ, int curI, int curJ)
   {
      visitableTiles = new boolean[4];
      row = arr.length;
      col = arr[0].length;
      maze = new Tile[row][col];
      for (int i = 0; i < row; i++)
         for (int j = 0; j < col; j++)
             maze[i][j] = arr[i][j];
      
      currentI = curI;
      currentJ = curJ;     
      previousI = prvI;
      previousJ = prvJ;
      
      if(maze[currentI][currentJ].beenVisitedBefore())
         visitableTiles = maze[currentI][currentJ].getInfo();
      else{
         if (valid(previousI, previousJ)) // aka if current is not start
         {
            if(maze[currentI - 1][currentJ].canVisit() &&
               (currentI - 1 != previousI || currentJ != previousJ))// north
            {
               visitableTiles[NORTH] = true;
            }
            if (maze[currentI][currentJ + 1].canVisit() &&
                (currentI != previousI || currentJ + 1 != previousJ)) // east
            {
               visitableTiles[EAST] = true;
            }
            
            if (maze[currentI + 1][currentJ].canVisit() &&
                (currentI + 1 != previousI || currentJ != previousJ)) // south
            {
               visitableTiles[SOUTH] = true;
            }
            if (maze[currentI][currentJ - 1].canVisit() &&
                (currentI != previousI || currentJ - 1 != previousJ)) // west
            {
               visitableTiles[WEST] = true;
            }
            maze[currentI][currentJ].tellInfo(visitableTiles);
         }
         else //  if the current is start
         {
            if (valid(currentI - 1, currentJ))
            {
               if (maze[currentI - 1][currentJ].canVisit())// north
               {
                  visitableTiles[NORTH] = true;
               }
            }
            if (valid(currentI, currentJ + 1))
            {
               if (maze[currentI][currentJ + 1].canVisit()) // east
               {
                  visitableTiles[EAST] = true;
               }
            }
            if (valid(currentI + 1, currentJ))
            {
               if (maze[currentI + 1][currentJ].canVisit()) // south
               {
                  visitableTiles[SOUTH] = true;
               }
            }
            if (valid(currentI, currentJ - 1))
            {
               if (maze[currentI][currentJ - 1].canVisit()) // west
               {
                  visitableTiles[WEST] = true;
               }
            }
            maze[currentI][currentJ].tellInfo(visitableTiles);
         }
      }
   }
   
   public Tile getNext()
   {
      for (int i = 0; i < 4; i++) // checks n, e, s, w
      {
         if (visitableTiles[i])
         {
            if (i == NORTH)
            {
               visitableTiles[NORTH] = false;
               maze[currentI][currentJ].tellInfo(visitableTiles);
               return maze[currentI - 1][currentJ];
            }
            else if (i == EAST)
            {
               visitableTiles[EAST] = false;
               maze[currentI][currentJ].tellInfo(visitableTiles);
               return maze[currentI][currentJ + 1];
            }
            else if (i == SOUTH)
            {
               visitableTiles[SOUTH] = false;
               maze[currentI][currentJ].tellInfo(visitableTiles);
               return maze[currentI + 1][currentJ];
            }
            else if (i == WEST)
            {
               visitableTiles[WEST] = false;
               maze[currentI][currentJ].tellInfo(visitableTiles);
               return maze[currentI][currentJ - 1];
            }
         }
      }
      return null;
   }
   
   //---------------------------------------------------------------------------
   //------------------------- accessors ---------------------------------------

   /**
    * int getI()
    *    Returns the i-"coordinate" of current room.
    */
   public int getI()
   {
      return currentI;
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * int getJ()
    *    Returns the j-"coordinate" of current room.
    */
   public int getJ()
   {
      return currentJ;
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * boolean valid(int i, int j)
    *    Checks to see if given room is a valid part of the maze (makes
    *    sure it is not out of bounds).
    */
   public boolean valid(int i, int j)
   {
      return (i >= 0 && i < row && j >= 0 && j < col);
   }
}
