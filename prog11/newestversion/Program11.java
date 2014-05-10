/**
 * Program11.java
 *    Encrypts and decrypts text files.
 *    Methods: - encrypt
 *             - decrypt
 *             - sleep
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, April 22, 2008
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;
import java.io.*;
import java.awt.Dimension;

public class Program11 extends Frame
{
   //------------------------- instance variables ------------------------------
   private Scanner scanIn;
   private String command, sourceName, outputName;
   private File padFile, sourceFile, outputFile;
   private Pad pad = null;
   private BufferedReader input;
   private TextBox sourceTB, outputTB;
      
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------

   /**
    * Program11(String padfile)
    *   This constructor takes the name of the pad file from the main command
    *   line and passes it to the Pad class.
    */
   public Program11(String padfile) throws Exception
   {  
      pad = new Pad(padfile);
      sourceTB = new TextBox("");
      sourceTB.setLocation(0, 0);
      sourceTB.setSize(new Dimension(350,500));
      outputTB = new TextBox("");
      outputTB.setLocation(349, 0);
      outputTB.setSize(new Dimension(350,500));
   }
   
   //---------------------------------------------------------------------------
   //------------------------- encrypt -----------------------------------------
   
   /**
    * void encrypt(String source, String destination)
    *    The encrypt method will take the source file and encrypt to the
    *    given destination file with the pad.
    */
   public void encrypt(String source, String destination) throws Exception
   {
      pad.reset();
      input = new BufferedReader(new FileReader(source));
      PrintWriter pw = new PrintWriter(destination);
    
      String sourceText = "Source File (" + source + "):\n";
      sourceTB.setText(sourceText);
      sourceTB.setFillColor(new Color(140,200,240)); // blue
      String outputText = "Encrypted File (" + destination + "):\n";
      outputTB.setText(outputText);
      outputTB.setFillColor(new Color(240,210,140)); // orange
      
      int i = input.read();
      
      while (i != -1)
      {
         char cypherChar;
         sourceText += (char) i;
         if(pad.hasNext())
         {
            cypherChar = (char)((i + pad.next()) % 128);
         }
         else
         {
            pad.reset();
            cypherChar = (char)((i + pad.next()) % 128);
         }
         pw.print(cypherChar);
         outputText += cypherChar;
         sleep(50);
         sourceTB.setText(sourceText);
         outputTB.setText(outputText);
         i = input.read();
      }
      pw.close();
   }

   //---------------------------------------------------------------------------
   //------------------------- decrypt -----------------------------------------

   /**
    * void decrypt(String source, String destination)
    *    The decrypt method will take the source file and decrypt to the
    *    given destination file with the pad.
    */
   public void decrypt(String source, String destination) throws Exception
   {
      pad.reset();
      input = new BufferedReader(new FileReader(source));
      PrintWriter pw = new PrintWriter(destination);
      
      String sourceText = "Source File (" + source + "):\n";
      sourceTB.setText(sourceText);
      sourceTB.setFillColor(new Color(240,210,140)); // orange
      String outputText = "Decrypted File (" + destination + "):\n";
      outputTB.setText(outputText);
      outputTB.setFillColor(new Color(140,200,240)); // blue
      
      int i = input.read();
      
      while (i != -1)
      {
         char plainChar;
         sourceText += (char) i;
         if(pad.hasNext())
         {
            plainChar = (char)((i - pad.next() + 128) % 128);
         }
         else
         {
            pad.reset();
            plainChar = (char)((i - pad.next() + 128) % 128);
         }
         pw.print(plainChar);
         outputText += plainChar;
         sleep(50);
         sourceTB.setText(sourceText);
         outputTB.setText(outputText);
         i = input.read();
      }
      pw.close();
   }
 
   //---------------------------------------------------------------------------
   //------------------------- static methods ----------------------------------

   /**
    * static void sleep(int milliseconds)
    *    This will cause the program to "sleep" for the provided number of
    *    milliseconds, to allow the encrypt and decrypt messages to print
    *    each character in the textboxes one by one.
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
      String mainArgs = null;
      
      try
      {
         mainArgs = args[0];
      }
      catch(ArrayIndexOutOfBoundsException a)
      {
         System.out.println("No pad file provided. Goodbye.");
         System.exit(0);
      }
      
      Program11 app = new Program11(mainArgs);
      
      System.out.println("Enter command (encrypt/decrypt), source name," +
                         " and name for output file OR quit.");
      Scanner scanIn = new Scanner(System.in);
      String command = "", sourceName = "", outputName = "";
      Scanner ss = new Scanner(scanIn.nextLine());
      
      while (ss.hasNextLine())
      {
         
         if (ss.hasNext())
         {
            command = ss.next();
            if (command.equals("quit"))
               System.exit(0);
         }
         if (ss.hasNext())
            sourceName = ss.next();
         if (ss.hasNext())
            outputName = ss.next();
         
         try
         {
            File test = new File(sourceName);
            if (command.equals("encrypt") && !(sourceName.equals("")) &&
                !(outputName.equals("")))
            {
               System.out.println("***** " + sourceName + " will now be " +
                                  "encrypted into " + outputName +" *****");
               app.encrypt(sourceName, outputName);

            }
            else if(command.equals("decrypt") && !(sourceName.equals("")) &&
                    !(outputName.equals("")))
            {
               System.out.println("***** " + sourceName + " will now be " +
                                  "decrypted into " + outputName +" *****");
               app.decrypt(sourceName, outputName);
            }
            else
            {
               System.out.println("Error with command! Try again.");
            } 
         }
         catch (FileNotFoundException f)
         {
            System.out.println("Error with source file! Try again.");
         }
         
         System.out.println("\nEnter command (encrypt/decrypt), source " +
                            "name, and name for output file OR quit.");
         scanIn = new Scanner(System.in);
         ss = new Scanner(scanIn.nextLine());
         command = "";
         sourceName = "";
         outputName = "";
      }
   }
}
