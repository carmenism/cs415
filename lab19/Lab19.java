/**
 * Lab19.java 
 * 
 */
import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;
import java.io.*;

public class Lab19 extends Frame
{
   //------------------ class variables ------------------------- 
   private static Scanner scanIn;
   private static int[ ]   intArgs = null;
   private TextBox box = null;
   private String text = "";
   private Color   curColor    = Color.BLUE;
   
   //------------------ Constructors -----------------------
   /**
    * No argument constructor
    */
   public Lab19( )   throws IOException
   { 
      int red, green, blue;
      
      try
      {
         red       = intArgs[ 0 ];
         green     = intArgs[ 1 ];
         blue      = intArgs[ 2 ];
      }
      catch( ArrayIndexOutOfBoundsException e )
      {
         red       = 255;
         green     = 255;
         blue      = 255;
         System.out.println( "Some of the command line arguments are not present." );
      }
      
      try
      {
         curColor = makeColor( red, green, blue );
      }
      catch ( InvalidColorException e )
      {
         System.out.println( e.getMessage( ) );
      }
      
      box = new TextBox( text );
      box.setSize( 500, 300 );
      box.setLocation( 10, 10 );
      box.setColor( curColor );
      
      while ( scanIn.hasNextLine() )
      {
         text = text + "\n" + scanIn.nextLine( );
         box.setText( text );
         sleep( 1000 );
      }
   }
   
   
   
   //-------------------- makeColor ------------------------
   /**
    * create a Color object from r,g,b components; check components
    * for validity ( 0-255 ). It checks for invalid values and silently 
    * converts them to 0.
    */
   private Color makeColor( int r, int g, int b ) throws InvalidColorException
   {
      
     
      if ( r < 0 || r > 255 ) 
      {
         r = 255;
         throw new InvalidColorException( "Red Error" );
      }
      if ( g < 0 || g > 255 ) 
      {
         g = 255;
         throw new InvalidColorException( "Green Error" );
      }
      if ( b < 0 || b > 255 ) 
      {
         b = 255;
         throw new InvalidColorException( "Blue Error" );
      }
      return new Color( r, g, b );
   }
   
   
   
   //++++++++++++++++++++ static methods +++++++++++++++++++++++++++++
   //--------------------- readArgs -------------------------------------
   /**
    * read command line arguments: filename  r g b
    *    filename - String with name of input file
    *    3 ints that represent initial values for 
    *          red, green, blue    values for initial color
    */
   private static void readArgs( String[ ] args ) throws FileNotFoundException
   {
      // first argument is a file name; rest are integers
      
      scanIn = new Scanner( new FileReader( args[ 0 ] ) );
      
      
      if( args.length > 1 )
         intArgs = new int[ args.length - 1 ];
      
      for ( int i = 1; i < args.length; i++ )
      {
         try
         {
            intArgs[ i - 1 ] = Integer.parseInt( args[ i ] );
         }
         catch ( NumberFormatException e )
         {
            intArgs[ i - 1 ] = 255;
            System.out.println( "Parsing error with the main args." );
         }
      }
   }
   
   //---------------------------------------------------------
   // 
   public static void sleep( int milliseconds ) 
   {
      try
      {
         Thread.sleep( milliseconds );
      }
      catch ( java.lang.InterruptedException e ) 
      {  }
   }
   
   
   
   //------------------------ main --------------------------
   public static void main( String [ ] args ) 
      throws IOException, FileNotFoundException 
   {
      readArgs( args );
      Lab19 app = new Lab19( );
   }
}
