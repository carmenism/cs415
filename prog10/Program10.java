/**
 * Program9.java
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, April 15, 2008
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;
import javax.swing.JOptionPane;
   
public class Program10 extends Frame
{
   //------------------------- instance variables ------------------------------
   private StickFigure stickFig;
   private TextBox secretTB, asteriskTB, guessesTB;
   private String secret, asterisks, guesses, input;
   private int wrongCount = 0;
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------

   /**
    * Program10( String str )
    *    This constructor uses the string passed in from the main method as the
    *    "secret" word.  A dialog message prompts the user for input until the 
    *    user gets the word, makes six incorrect guesses, or clicks cancel.
    * str: the word to be guessed.
    */
   public Program10( String str )
   {
      secret = str.toLowerCase( );
      asterisks = new String( "" );
      guesses = new String( "" );
      
      for( int i = 0; i < str.length(); i++ )
      {
         asterisks += "*";
      }
      
      stickFig = new StickFigure( 225, 100 );
      
      asteriskTB = new TextBox( asterisks );
      asteriskTB.setLocation( 245, 400 );
      
      guessesTB = new TextBox( "Wrong guesses: " + guesses );
      guessesTB.setLocation( 245, 50 );
      
      input = "";
      
      while( input != null && wrongCount < 6 && !asterisks.equals( secret ) )
      {
         input = JOptionPane.showInputDialog( null, "Guess a letter!  " +
                                                    "(Click cancel to quit.)" );
         if ( input != null )
         {
            input = input.toLowerCase( );
         
            if ( input.length() > 1 )
            {
               System.out.println( "Error: " + 
                                   "more than one letter guessed at once." );
            }
            else if ( guesses.contains( input ) )
            {
               System.out.println( "Error: letter already guessed." );
            }
            else if ( secret.contains( input ) )
            {
               System.out.println( "Guessed letter " + input +
                                   " is in the word." );
            
               for ( int i = 0; i < secret.length( ); i++ )
               {
                  String current = secret.substring( i, i + 1 );
                  if ( current.equals( input ) && i == 0 )
                  {
                     asterisks = input+asterisks.substring(1, secret.length() );
                  }
                  else if ( current.equals( input ) && i == secret.length()-1 )
                  {
                     asterisks = asterisks.substring( 0, i ) + input;
                  }
                  else if ( current.equals( input ) )
                  {
                     asterisks = asterisks.substring( 0, i ) + input +
                                 asterisks.substring( i + 1, secret.length() );
                  }
               }
            
               asteriskTB.setText( asterisks );
            }
            else
            {
               System.out.println( "Guessed letter " + input +
                                   " is NOT in the word." );
               guesses += input;
               guessesTB.setText( "Wrong guesses: " + guesses );
               wrongCount++;
               stickFig.reveal( wrongCount );
            }  
         }
         else
            System.exit( 0 );
      }
      
      if ( wrongCount == 6 )
      {
         JOptionPane.showMessageDialog( null, "You lose!!!\nThe word was \""
                                              + secret + ".\"" );
      }
      else if ( asterisks.equals( secret ) )
      {
         JOptionPane.showMessageDialog( null, "Congrats!!!\n"
                                              + "You have won the game!" );
      }
   }
   
   //---------------------------------------------------------------------------
   // main method
   public static void main( String args[ ] )
   {
      Program10 lab;
      if ( args.length >= 1 )
      {
         lab = new Program10( args[ 0 ] );
      }
      else
      {
         System.err.println( "Error: no command line argument." );
         System.exit( 0 );
      }
   }
}