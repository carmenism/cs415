/**
 * Lab18.java 
 * 
 */

import java.util.*;
import java.io.*;

public class Lab18 
{  
   private  Scanner scanIn, scanFile;
   private BufferedReader bufferedReader;
   private File inputFile, outputFile;
   private  PrintWriter printWriter;
   private String fileName = "";
   
   //------------------------ constructor --------------------------
   public Lab18() throws Exception                     
   { 
      System.out.println( "Enter a filename:" );
      scanIn = new Scanner( System.in );
      inputFile = new File( scanIn.next() );
      scanFile = new Scanner( inputFile );
      
      int i = 1;
      
      while( scanFile.hasNextLine( ) )
      {
         System.out.println( "Line " + i + ": " + scanFile.nextLine( ) );
         i++;
      }
      
      System.out.println( "-----------------" );
      
      scanIn = new Scanner( inputFile );
      
      while( scanIn.hasNext( ) )
      {
         System.out.println( scanIn.next( ) );
      }
      
      System.out.println( "-----------------" );
      
      bufferedReader = new BufferedReader( new FileReader( inputFile ) );
      
      int ch;
      
      while( ( ch = bufferedReader.read( ) ) != -1 )
      {
         System.out.println( (char) ch  + "  " + ch );
      }
      
      System.out.println( "-----------------" );
      
      System.out.println( "Enter a filename for the output:" );
      scanIn = new Scanner( System.in );
      outputFile = new File( scanIn.next() );
           
      PrintWriter pw = new PrintWriter( outputFile );
      
      String s = "";
      scanIn = new Scanner( System.in );
      
      while( scanIn.hasNext() && !( s = scanIn.nextLine()).equals( "quit" ) )
      {
         pw.println( s);
         scanIn = new Scanner( System.in );
      }
      
      pw.close( );     
      
   }
   
   
   //------------------------ main --------------------------
   public static void main( String[ ] args ) throws Exception
   {
      Lab18 app = new Lab18( );
   }
}
