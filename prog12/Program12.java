/**
 * Program12.java
 *    Solves mazes.
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, April 29, 2008
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;
import java.io.*;
import java.awt.Dimension;

public class Program12 extends Frame
{
   //------------------------- instance variables ------------------------------
   private File mazeFile;
   private int sleepTime, row, col, size, startI, startJ, goalI, goalJ;
   private int [][] theMaze;
   private Tile [][] theMazeDisplay;
   private Scanner scanFile;
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------
   
   /**
    * Program12(File f, int s)
    *    This takes the file and sleep time given by the main arguments, reads
    *    the file and creates a maze, then uses a seeker to solve the maze.
    */
   public Program12(File f, int s) throws Exception
   {
      mazeFile = f;
      sleepTime = s;
      
      scanFile = new Scanner(mazeFile);
      
      try
      {
         row = scanFile.nextInt();
         col = scanFile.nextInt();
      }
      catch(Exception e)
      {
         System.out.println("Improper file data. Goodbye.");
         sleep(70);
         System.exit(0);
      }
      
      theMaze = new int[row][col];
      theMazeDisplay = new Tile[row][col];
      
      try
      {
         size = scanFile.nextInt();
         startI = scanFile.nextInt();
         startJ = scanFile.nextInt();
         goalI = scanFile.nextInt();
         goalJ = scanFile.nextInt();
         
         for (int i = 0; i < row; i++)
         {
            for (int j = 0; j < col; j++)
            {
               theMaze[i][j] = scanFile.nextInt();
               theMazeDisplay[i][j] = new Tile(i,j,size,theMaze[i][j]);
            }
         }
      }
      catch(Exception e)
      {
         System.out.println("Improper file data. Goodbye.");
         sleep(70);
         System.exit(0);
      }
      
      Seeker seeker = new Seeker(theMazeDisplay, size, sleepTime,
                                 startI, startJ,
                                 goalI, goalJ);
   }

   
   //------------------------- static methods ----------------------------------

   /**
    * static void sleep(int milliseconds)
    *    This will cause the program to "sleep" for the provided number of
    *    milliseconds.
    */
   public static void sleep(int milliseconds)
   {
      try
      {
      Thread.sleep(milliseconds);
      }
      catch(InterruptedException e)
      { }
   }
   
   //---------------------------------------------------------------------------
   //------------------------- main method -------------------------------------

   public static void main(String [] args) throws Exception
   {  
      File file = null;
      int speed = 0;
      
      try
      {
         file = new File(args[0]);
         if ( !(file.exists()) )
         {
            System.out.println("File does not exist. Goodbye.");
            sleep(70);
            System.exit(0);
         }
         speed = Integer.parseInt(args[1]);
      }
      catch(ArrayIndexOutOfBoundsException oob)
      {
         System.out.println("No command line arguments provided. Goodbye.");
         sleep(70);
         System.exit(0);
      }
      catch(NumberFormatException nfe)
      {
         System.out.println("No integer provided for speed. Goodbye.");
         sleep(70);
         System.exit(0);
      }
      catch(NoSuchElementException nse)
      {
         System.out.println("Command line argument missing. Goodbye.");
         sleep(70);
         System.exit(0);
      }
      
      Program12 app = new Program12(file, speed);
   }
}
