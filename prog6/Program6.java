/** 
 * Program6.java:
 *  Starts a race with three racers
 *mlb 2/2008
 */

import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;
import javax.swing.JOptionPane;

public class Program6 extends Frame
{  
   private Random rg;
   private int speedA, speedB, speedC; 
   private Racer a,b,c;
   
   //---------------------------------------------------------
   public Program6( )
   {
      rg = new Random( );
      
      // Three racers
      a = new Buggy( 100, 350 , Color.BLUE );
      b = new Buggy( 200, 350, Color.PINK );
      c = new Buggy( 300, 350, Color.ORANGE );
      
      // Starting Line
      Line start = new Line( 50, 348, 450, 348 );
      start.setColor( Color.BLACK );
      start.setThickness( 2 );
      
      //  Sets the racers to random number, weight and HP
      setRandom( a );
      setRandom( b );
      setRandom( c );
      
      // calculates the speed of a racer based on weight and HP
      speedA = a.getHP( ) * 10 / a.getWeight( );
      speedB = b.getHP( ) * 10 / b.getWeight( );
      speedC = c.getHP( ) * 10 / c.getWeight( );
      
      
      // Let's Race!
      JOptionPane.showMessageDialog( null, "Are you ready to race?" ); 
      
      Racer leader = getLeader( ); 
      while( leader.getYLocation() > 0 )
      {
         a.setLocation( a.getXLocation( ), a.getYLocation( ) - speedA );
         b.setLocation( b.getXLocation( ), b.getYLocation( ) - speedB );
         c.setLocation( c.getXLocation( ), c.getYLocation( ) - speedC );
         sleep( 50 );          
         leader = getLeader( );
      }      
      JOptionPane.showMessageDialog( null, "And the winner is \n car number "
                                       + leader.getName( ) + "!" );     
   }
   
   
   //---------------------------------------------------------
   // Find the leader
   public Racer getLeader(  )
   {
      if( a.getYLocation() < b.getYLocation() )
      {
         if ( c.getYLocation() < a.getYLocation())
            return c;
         else
            return a;
      }
      else 
      {
         if ( c.getYLocation() < b.getYLocation())
            return c;
         else
            return b;
      }       
   }
   
   //---------------------------------------------------------
   // sleep
   public static void sleep( int milliseconds ) 
   {
      try
      {
         Thread.sleep( milliseconds );
      }
      catch ( java.lang.InterruptedException e ) 
      {  }
   }
   
   
   //---------------------------------------------------------
   //  give the racer random stats
   public void setRandom( Racer r )
   {
      int n = rg.nextInt( 99 );
      
      if( n < 10 )
         r.setName( "0" + Integer.toString( n ) );
      else
         r.setName( Integer.toString( n ) );
      
      n = rg.nextInt( 160 );
      r.setWeight( 290 + n );
      
      n = rg.nextInt( 105 );
      r.setHP( 90 + n ); 
   }
   
   //---------------------------------------------------------
   public static void main( String[ ] args )
   {
      new Program6( ); 
   }  
}//End of Class Program6