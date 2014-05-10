/**
 * Program11.java 
 * 
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

   public Program11(String padfile) throws Exception
   {  
      pad = new Pad(padfile);
      sourceTB = new TextBox("");
      outputTB = new TextBox("");
      sourceTB.hide();
      outputTB.hide();
   }
   
   //---------------------------------------------------------------------------
   //------------------------- encrypt -----------------------------------------
   
   public void encrypt(String source, String destination) throws Exception
   {
      pad.reset();
      input = new BufferedReader(new FileReader(source));
      PrintWriter pw = new PrintWriter(destination);
            
      sourceTB.show();
      String sourceText = "Source File (" + source + "):\n";
//      TextBox sourceTB = new TextBox(sourceText);
      sourceTB.setText(sourceText);
      sourceTB.setLocation(0, 0);
      sourceTB.setSize(new Dimension(350,500));
      sourceTB.setFillColor(new Color(140,200,240)); // blue
      
      outputTB.show();
      String outputText = "Encrypted File (" + destination + "):\n";
//      TextBox outputTB = new TextBox(outputText);
      outputTB.setText(outputText);
      outputTB.setLocation(349, 0);
      outputTB.setSize(new Dimension(350,500));
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

   public void decrypt(String source, String destination) throws Exception
   {
      pad.reset();
      input = new BufferedReader(new FileReader(source));
      PrintWriter pw = new PrintWriter(destination);
      
      sourceTB.show();
      String sourceText = "Source File (" + source + "):\n";
//      TextBox sourceTB = new TextBox(sourceText);
      sourceTB.setText(sourceText);
      sourceTB.setLocation(0, 0);
      sourceTB.setSize(new Dimension(350,500));
      sourceTB.setFillColor(new Color(240,210,140)); // orange
      
      outputTB.show();
      String outputText = "Decrypted File (" + destination + "):\n";
//      TextBox outputTB = new TextBox(outputText);
      outputTB.setText(outputText);
      outputTB.setLocation(349, 0);
      outputTB.setSize(new Dimension(350,500));
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
      Program11 app = new Program11(args[0]);
      
      System.out.println("Enter command, source final name," +
                         " and name for file to be created.");
      Scanner scanIn = new Scanner(System.in);
      String s = "", command = null, sourceName = null, outputName = null;
      Scanner ss = new Scanner(scanIn.nextLine());
      
      while (ss.hasNextLine())
      {
         
         if (ss.hasNext())
         {
            command = ss.next();
            if ( command.equals( "quit" ) )
               System.exit( 0 );
         }
         if (ss.hasNext())
            sourceName = ss.next();
         if (ss.hasNext())
            outputName = ss.next();
         
         if (command.equals("encrypt"))
         {
            app.encrypt(sourceName, outputName);
         }
         else if(command.equals("decrypt"))
         {
            app.decrypt(sourceName, outputName);
         }
         else
         {
            System.out.println("Error with input.  Enter command," +
                               " source final name," +
                               " and name for file to be created.");
         }
         
         scanIn = new Scanner(System.in);
         ss = new Scanner(scanIn.nextLine());
      }  
   }
}
