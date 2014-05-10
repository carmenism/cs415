/** 
 * BouncingBall.java
 *  Adapted from Section 7.4 of "Objected-Oriented Programming in Java" by
 *  Kathryn E. Sanders & Andries van Dam.
 * 
 * @author Carmen St. Jean
 *         CS 415 - Spring 2008, April 8, 2008
 * 
 * For Program9
 */

//----------------------- imports ----------------------------------------------
import java.awt.Color;
import wheelsunh.users.*;
import java.util.*;

public class BouncingBall extends Ellipse
{
   //------------------------- instance variables ------------------------------
   private int deltaX, deltaY, frameTime = 40, i = 0;
   private Paddle rightPaddle, leftPaddle;
   private Random rg;
   
   //---------------------------------------------------------------------------
   //------------------------- constructor -------------------------------------

   /**
    * BouncingBall( Paddle l, Paddle r )
    *    This constructor passes in the paddles so the ball will know their
    *    locations.  Creates a ball.
    */
   public BouncingBall( Paddle l, Paddle r )
   {
      super( );
      this.setSize( 16, 16 );
      this.setColor( Color.WHITE );
      rg = new Random( );
      deltaX = (int)Math.pow( -1, rg.nextInt( 2 ) ) * ( 5 + rg.nextInt( 2 ) );
      deltaY = (int)Math.pow( -1, rg.nextInt( 2 ) ) * ( 5 + rg.nextInt( 2 ) );
      leftPaddle = l;
      rightPaddle = r;
   }
   
   //---------------------------------------------------------------------------
   //------------------------- mutators ----------------------------------------

   /**
    * void speedup( )
    *    Will speed the ball up gradually over time.
    */
   private void speedUp( )
   {
      if ( i % 60 == 0 && frameTime > 15 )
      {
         frameTime -= 1;
      }
      i++;
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * void move( )
    *    Will move the ball about until one player misses the ball.  It also
    *    controls the left paddle to follow the ball.
    */
   public void move( )
   {     
      frameTime = 40;
      Boolean keepMoving = true;
      while ( keepMoving )
      {
         int nextX = (int)this.getXLocation() + deltaX;
         int nextY = (int)this.getYLocation() + deltaY;
         
         if ( nextX <= 0 ) 
         {
            // left paddle misses
            rightPaddle.gainPoint( );
            keepMoving = false;
         }
         else if ( nextX >= 684 ) 
         {
            // right paddle misses
            leftPaddle.gainPoint( );
            keepMoving = false;
         }
         else if ( ( nextX + 16 >= rightPaddle.getXLocation() ) && 
              ( nextY >= rightPaddle.getYLocation() - 8 &&
                nextY < rightPaddle.getYLocation() + 58 ) )
         {
            // hits left paddle
            deltaX *= -1;
            nextX = rightPaddle.getXLocation() - 16;
         }
         else if ( ( nextX <= leftPaddle.getXLocation() + 12 ) && 
              ( nextY >= leftPaddle.getYLocation() - 8 &&
                nextY < leftPaddle.getYLocation() + 58 ) )
         {
            // hits right paddle
            deltaX *= -1;
            nextX = leftPaddle.getXLocation() + 12;
         }
         else if ( nextY <= 0 ) 
         {
            // hits the top of frame
            deltaY *= -1;
            nextY = 0;
         }
         else if ( nextY > 484 )
         {
            // hits bottom of frame
            deltaY *= -1;
            nextY = 484;
         }
      
         Utilities.sleep( frameTime );
         this.setLocation( nextX, nextY );
         this.speedUp( );
         leftPaddle.setLocation( leftPaddle.getXLocation(), nextY - 17 );   
      }

      this.hide( );
      Utilities.sleep( 3 * frameTime );
      this.setLocation( 340, 237 );
      this.show( );
   }
}