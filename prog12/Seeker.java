/**
 * Seeker.java
 *    For Program12.
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, April 29, 2008
 */

//----------------------- imports ----------------------------------------------
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Seeker
{
   //------------------------- instance variables ------------------------------
   private int i, j;
   private boolean finished;
   private Rectangle seeker;
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------

   /**
    * Seeker(Tile [][] maze, int size, int sleepTime, int startI, int startJ,
    *        int goalI, int goalJ)
    *    This creates a seeker which will begin at the start position and end
    *    on the goal.  Then a message will be displayed.  If the goal is not
    *    possible to reach, then a message will say so.
    */
   public Seeker(Tile [][] maze, int size, int sleepTime,
                 int startI, int startJ, int goalI, int goalJ)
   {
      seeker = new Rectangle( startJ * size, startI * size );
      seeker.setFrameColor( Color.GRAY );
      seeker.setFillColor( Color.RED );
      seeker.setSize( size, size );
      Stack<RoomInfo> stack = new Stack<RoomInfo>();
      RoomInfo start = new RoomInfo(maze, -1, -1, startI, startJ);
      stack.push(start);
      finished = false;
      RoomInfo current, next;
      Tile nextTile;
      while (!(stack.empty()) && !finished)
      {  
         current = stack.peek();
         i = current.getI();
         j = current.getJ();
         nextTile = current.getNext();
         if (nextTile != null)
         {
            int nextI = nextTile.getI();
            int nextJ = nextTile.getJ();
            if(nextI != goalI || nextJ != goalJ)
            {
               next = new RoomInfo(maze, i, j, nextI, nextJ);
               maze[i][j].setGreen();
               seeker.setLocation(size * nextJ, size * nextI);
               stack.push(next);
            }
            else /// MAZE FINISHED
            {
               maze[i][j].setGreen();
               seeker.setLocation(size * nextJ, size * nextI);
               JOptionPane.showMessageDialog( null, "Maze solved!" );
               finished = true;
            }
         }
         else
         {
            stack.pop();
            maze[i][j].setYellow();
            seeker.setLocation(size * j, size * i);
         }
         Program12.sleep(sleepTime);
      }
      if(stack.empty())
         JOptionPane.showMessageDialog( null, "No solution." );
   }
} 