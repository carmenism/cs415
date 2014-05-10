/**
 * Lab17.java
 * Carmen St. Jean
 * April 10, 2008
 * CS 415
 */

import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;
import javax.swing.JOptionPane;

public class Lab17 extends Frame
{
   
   private TextBox secretTB, asteriskTB, guessesTB;
   private String secret, asterisks, guesses, input;
   
   
   public Lab17( String str )
   {
      secret = str;
      asterisks = new String( "" );
      guesses = new String( "" );
      
      secretTB = new TextBox( secret );
      secretTB.setLocation( 200, 100 );
      
      for( int i = 0; i < str.length(); i++ )
      {
         asterisks += "*";
      }
      
      asteriskTB = new TextBox( asterisks );
      asteriskTB.setLocation( 200, 150 );
      
      guessesTB = new TextBox( guesses );
      guessesTB.setLocation( 200, 200 );
      
      input = JOptionPane.showInputDialog( null, "Guess a letter. (Click cancel to quit.)" );
      
      while( input != null )
      {
         if ( input.length() > 1 )
         {
            System.out.println( "Error: more than one letter guessed at once." );
         }
         else if ( guesses.contains( input ) )
         {
            System.out.println( "Error: letter already guessed." );
         }
         else if ( secret.contains( input ) )
         {
            System.out.println( "Guessed letter " + input + " is in the word." );
         }
         else
         {
            System.out.println( "Guessed letter " + input + " is NOT in the word." );
            guesses += input;
            guessesTB.setText( guesses );
         }
         
         input = JOptionPane.showInputDialog( null, "Guess a letter. (Click cancel to quit.)" );
      }
   }
   
 
   public static void main( String args[ ] )
   {
      Lab17 lab;
      if ( args.length >= 1 )
      {
         lab = new Lab17( args[ 0 ] );
      }
      else
      {
         System.err.println( "Error: no command line argument." );
         System.exit( 0 );
      }
   }
   
   
   
}