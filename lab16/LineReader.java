/**
 * LineReader - a class that only supports reading lines from a text file.
 *              it uses Scanner.
 * 
 *  LineReader( String fileName )
 *          if fileName is null or the null string, open standard input; 
 *          Otherwise if fileName does not exist, give error msg and open 
 *          System.in
 *  String readLine()             
 *          return next line of input; null => eof
 *  void pauseOnInput( boolean )
 *          if parameter is true and current input is not System.in, read a 
 *          character from System.in before each file read. This causes program 
 *          to pause and let's the user see more clearly what is happening -- 
 *          it is a good debugging feature.
 */
import java.io.*;
import java.util.Scanner;

public class LineReader
{
   //------------------ instance variables -----------------
      private Scanner scanner;
      
      // if you want to pause as you read each input line to wait for user to
      //  hit a return, set the line below to true. This can be handy for debugging.
      // Can also invoke the public method pauseOnInput( boolean ) to set the flag
      private boolean pauseOnInput = true;      
 
   //---------------- constructor ------------------------
   /**
    *  String fileName -- contains name of file to open
    *        null or empty string opens System.in
    *        if specified file does not exist, give an error to System.err 
    *            and open System.in
    */
   public LineReader( String fileName )
   {
      try
      {
         if ( fileName == null || fileName.length() == 0 )
         {
            scanner = new Scanner( new InputStreamReader( System.in) );
            pauseOnInput = false; // no need to pause
         }
         else
            scanner = new Scanner( new FileReader( fileName ));
      }
      catch ( IOException ioe )
      {
         System.err.println( "***Error -- file does not exist: " + fileName );
         System.err.println( "        opening System.in." );
         scanner = new Scanner( new InputStreamReader( System.in) );
         pauseOnInput = false; // no need to pause
      }
   }
   //------------------------- readLine() ---------------------------
   /**
    * Read and return the next line of input from the file.
    * If the eof has been reached or any other exception occurs, 
    *    return null.
    */
   public String readLine()
   {
      try
      {
         if ( pauseOnInput )
         {
            System.out.print( "Hit return to continue> " );
            int ch = System.in.read();
         }
         if ( scanner.hasNextLine() )
            return scanner.nextLine();
         else 
            return null;
      }
      catch ( IOException ioe )
      {
         return null;
      }
   }
   //----------------------- pauseOnInput() -----------------------------
   /**
    * Set mode to pause on input 
    */
   public void pauseOnInput( boolean pause )
   {
      pauseOnInput = pause;
   }
    //----------------------- close() -----------------------------
   /**
    * close the scanner
    */
   public void close()
   {
      scanner.close();
   }
}
