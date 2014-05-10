/**
 * Program9.java
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, April 8, 2008
 */

//----------------------- imports ----------------------------------------------
import wheelsunh.users.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;

public class Program9 extends Frame
{  
   //------------------------- instance variables ------------------------------
   private BouncingBall ball;
   private Paddle leftPaddle, rightPaddle;
   private TextBox lScoreBoard, rScoreBoard, winnerBox;
   private Rectangle background;
   private Line separator;
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------

   /**
    * Program9( )
    *    This constructor starts the program which is a pong game.
    */
   public Program9( )
   {
      background = new Rectangle( 0, 0 );
      background.setSize( 700, 500 );
      background.setColor( Color.BLACK );
      
      separator = new Line( 349, 0, 349, 500 );
      separator.setColor( Color.WHITE );
      separator.setThickness( 4 );
      
      leftPaddle = new Paddle( 13, 237 );
      rightPaddle = new Paddle( 675, 237 );
      
      lScoreBoard = new TextBox( "Computer: " + leftPaddle.getScore() );
      lScoreBoard.setLocation( 220, 10 );
      lScoreBoard.setBorderWidth( 0 );
      lScoreBoard.setSize( new Dimension(80, 20) );
      
      rScoreBoard = new TextBox( "You: " + rightPaddle.getScore() );
      rScoreBoard.setLocation( 400, 10 );
      rScoreBoard.setBorderWidth( 0 );
      rScoreBoard.setSize( new Dimension(80, 20) );
      
      ball = new BouncingBall( leftPaddle, rightPaddle );
      ball.setLocation( 340, 237 );
      
      Utilities.sleep( 200 );
      ball.move( );
      
      while ( leftPaddle.getScore() != 10 && rightPaddle.getScore() != 10 )
      {
         lScoreBoard.setText( "Computer: " + leftPaddle.getScore() );
         rScoreBoard.setText( "You: " + rightPaddle.getScore() );
         ball.move( );
      }
      
      lScoreBoard.setText( "Computer: " + leftPaddle.getScore() );
      rScoreBoard.setText( "You: " + rightPaddle.getScore() );
      
      if ( leftPaddle.getScore() == 10 )
      {
         winnerBox = new TextBox( "The computer has won!" );
         winnerBox.setColor( Color.WHITE );
         winnerBox.setLocation( 250, 300 );
      }
      else
      {
         winnerBox = new TextBox( "You have won!" );
         winnerBox.setColor( Color.WHITE );
         winnerBox.setLocation( 250, 300 );
      }
   }
   
   //---------------------------------------------------------------------------
   // main method
   public static void main(String[] args)
   {
      Program9 p = new Program9( );
   }
}