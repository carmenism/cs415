/**
 * Pad.java
 *    Opens pad files for Program11 or quits if they are invalid.
 *    Methods: - hasNext
 *             - next
 *             - reset
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, April 22, 2008
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;
import java.io.*;

public class Pad
{
   //------------------------- instance variables ------------------------------
   private Scanner scanIn;
   private String padFileName;
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------
   
   /**
    * Pad(String padName)
    *    This constructor uses the pad name given to try to open the pad file
    *    or quit if this file does not exist.
    */
   public Pad(String padName) throws Exception
   {
      padFileName = padName;
      try
      {
         scanIn = new Scanner(new File(padName));
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Pad file not found. Goodbye.");
         System.exit(0);
      }
   }
   
   //---------------------------------------------------------------------------
   //------------------------- accessors ---------------------------------------

   /**
     * boolean hasNext()
     *    Checks to see if there is an next integer to the pad file.
     */
   public boolean hasNext()
   {
      return scanIn.hasNext();
   }

   
   //---------------------------------------------------------------------------
   //------------------------- mutators ----------------------------------------

   /**
    * void reset()
    *    Resets the scanner to scan at the beginning of the pad file.
    */
   public void reset() throws Exception
   {
      scanIn = new Scanner(new File(padFileName));
   }

   //---------------------------------------------------------------------------
   
   /**
    * int next()
    *    Returns the next integer of the pad file.
    */
   public int next()
   {
      return scanIn.nextInt();
   }

   //---------------------------------------------------------------------------
   //------------------------- main method -------------------------------------

   public static void main(String [] args) throws Exception
   {
      Pad app = new Pad(args[0]);
   }
}