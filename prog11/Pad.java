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
   
   public Pad(String padName) throws Exception
   {
      padFileName = padName;
      try
      {
         scanIn = new Scanner(new File(padName));
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Pad file not found.  " +
                            "Please enter a valid pad file name.");
         scanIn = new Scanner(new File(padName));
      }
   }
   
   //---------------------------------------------------------------------------
   //------------------------- accessors ---------------------------------------

   public boolean hasNext()
   {
      return scanIn.hasNext();
   }

   
   //---------------------------------------------------------------------------
   //------------------------- mutators ----------------------------------------

   public void reset() throws Exception
   {
      scanIn = new Scanner(new File(padFileName));
   }

   //---------------------------------------------------------------------------
   
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