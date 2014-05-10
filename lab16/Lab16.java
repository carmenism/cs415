/**
 * Lab9.java 
 * 
 * @author rdb
 * 11/04/07
 */
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Lab16 extends Frame
{
   //------------------ class variables ------------------------- 
   
   //------------------ instance variables -----------------------
   private LineReader rdr = null;
   private Random     rng;         // random number generator for  positions.
   private Color      curColor;
   private int minSize = 10;    // minimum size for rectangles and ellipses
   private int maxSize = 70;    // maximum size for rectangles and ellipses
   private int maxX    = 450;   // max X position
   private int maxY    = 400;   // max Y position
   
   //------------------ Constructors       -----------------------
   public Lab16( String[] args )
   {
      rng = new Random( 1 );  // set up random number generator
      
      curColor = Color.BLUE;
      
      String fileName = null;
      
      if ( args.length > 0 )
         fileName = args[ 0 ];
      
      rdr = new LineReader( fileName );
      
      String line = rdr.readLine();
      
      while ( line != null )
      {
         line = line.trim( );
      
         System.out.println( line );
         if ( line.length() > 0 )
            parse( line );
         
         line = rdr.readLine();
         
      }      
      rdr.close();  // clean up after ourselves
   }
   //------------------ parse ----------------------------
   /**
    * parse the input line
    */
   private void parse( String line )
   {
      String lowerCaseLine = line.toLowerCase( );
      
      if ( lowerCaseLine.startsWith( "#" ) )
      {
         System.out.println( "Comment found along the input line." );
      }
      else if ( lowerCaseLine.startsWith( "b" ) )
      {
         this.doB( line );
      }
      else if ( lowerCaseLine.startsWith( "c" ) )
      {
         this.doC( line );
      }
      else if ( lowerCaseLine.startsWith( "d" ) )
      {
         this.doD( line );
      }
      else if ( lowerCaseLine.startsWith( "r" ) )
      {
         this.doR( line );
      }
      else if ( lowerCaseLine.startsWith( "e" ) )
      {
         this.doE( line );
      }
      else
      {
         System.out.println( "The command is not recognized along the input line." );
      }
   }
   //----------------- doB ------------------------
   /**
    *
    */
   private void doB( String line )
   {
      System.out.println( "The command called was B." );
   }
   
   //----------------- doC ------------------------
   /**
    * This will become a color definition command
    */
   private void doC( String line )
   {
      System.out.println( "The command called was C." );
      
      int spaceLoc = line.indexOf( ' ' );
      String sub = ( line.substring( spaceLoc ) ).trim( );
      
      // The following declaration defines an array of 4 Strings and initializes 
      // the elements of the array to the specified values.
      String colors[] = { "red", "blue", "black", "green" };
           
      // We can use this initialization syntax for any array. The next declaration
      // defines an array of awt Color constants that corresponds to the strings
      // in the "colors" array above
      Color  awtColors[] = { Color.RED, Color.BLUE, Color.BLACK, Color.GREEN };
      
      for ( int i = 0; i < 4; i++ )
      {
         if ( sub.equalsIgnoreCase( colors[ i ] ) )
         {
            curColor = awtColors[ i ];
         }
      }
   }
   
   //----------------- doD ------------------------
   /**
    * 
    * 
    */
   private void doD( String line )
   {
      System.out.println( "The command called was D." );
      JOptionPane window = new JOptionPane( );
      parse( window.showInputDialog( null, "Please enter a command." ) );
   }

   //----------------- doE ------------------------
   /**
    * draw a wheels ellipse at a random position and size
    */
   private void doE( String line )
   {
      Ellipse e = new Ellipse( );
      int xLoc = rng.nextInt( maxX );
      int yLoc = rng.nextInt( maxY );
      e.setLocation( xLoc, yLoc );
      int w    = minSize + rng.nextInt( maxSize ); 
      int h    = minSize + rng.nextInt( maxSize );
      e.setSize( w, h );
      e.setColor( curColor );
   }
   
   //----------------- doR ------------------------
   /**
    * draw a wheels rectangle at a random position and size
    */
   private void doR( String line )
   {
      Rectangle r = new Rectangle( );
      int xLoc = rng.nextInt( maxX );
      int yLoc = rng.nextInt( maxY );
      r.setLocation( xLoc, yLoc );
      int w    = minSize + rng.nextInt( maxSize ); 
      int h    = minSize + rng.nextInt( maxSize );
      r.setSize( w, h );
      r.setColor( curColor );
   }
   
   //------------------------ main --------------------------
   public static void main( String[] args )
   {
      Lab16 lab16 = new Lab16( args );
   }
}
