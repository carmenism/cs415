/* Carmen St. Jean - Lab20.java */

import java.io.*;
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;
import java.util.*;

public class Lab20 extends ShapeGroup
{
   private final int   SIZE = 26; // tile size
  
   
   //-------------------------------------------------------------------
   private int [ ][ ] theLab20;
   private Tile [ ][ ] theView;
   private int [ ] [ ] theCounts;
   private int row, col;
   private  int  percent;
    
   //-------------------------------------------------------------------
   public Lab20(int r, int c, int seed, int pc) 
   {
      row = r;
      col = c;
      percent = pc;
      
      theView = new Tile[r][c];   
      theLab20 = new int[r][c]; 
      theCounts = new int[r][c];
      
      layLab20( seed , percent );
      getCounts( );
      
      Tile temp;
      for(int i = 0; i< r; i++)
         for(int j = 0; j < c; j++)
         {
            temp=  new Tile( i, j, SIZE );
            temp.setCount( theCounts[ i ][ j ] );  
            // Need to set location
            temp.setLocation( j * SIZE, i * SIZE );
            
            theView[i][j] = temp;
            sleep(20);
         }
        
      System.out.println( this );
   }
   
  
   
   //-------------------------------------------------------------------
   public void getCounts( )
   {
      for ( int r = 0; r < row; r++ )
      {
         for ( int c = 0; c < col; c++ )
         {
            if ( theLab20[r][c] == 1 )
            {
               theCounts[r][c] = 9;
            }
            else
            {
               for ( int i = -1; i <= 1; i++ )
                  for ( int j = -1; j <= 1; j++ )
                  {
                     if ( r+i >= 0 && r+i < row && c+j >= 0 && c+j < col )
                        theCounts[r][c] += theLab20[r+i][c+j];
                  }
            }
         }
      }
   }
   
   
   //-------------------------------------------------------------------
   public void layLab20 ( int n , int pc)
   { 
      Random generator = new Random( n );
      
      for ( int r = 0 ; r < row ; r++ )
         for ( int c = 0; c < col ; c++ )    
            if ( generator.nextInt( 100 ) < pc )
               theLab20[ r ][ c ] = 1;               
            else
               theLab20[ r ][ c ] = 0;
   }
   
   
   //-------------------------------------------------------------------
   public String toString( )
   { 
      String s="The Lab20\n ";
      for ( int r = 0; r < row; r++ )
      {
         for ( int c = 0; c < col ; c++ )
            s = s + theLab20[ r ][ c ] + " ";
         s = s + " \n " ;
      }
      s += "\nThe Counts\n ";
      for ( int r = 0; r < row; r++ )
      {
         for ( int c = 0; c < col ; c++ )
            if( theCounts[ r ][ c ] == 9 )
               s = s + "X" + " ";
            else
               s = s + theCounts[ r ][ c ] + " ";
         s = s + " \n " ;
      }    
      return( s );
   }
   
   
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   public static void sleep( int milliseconds ) 
   {
      try
      {
         Thread.sleep( milliseconds );
      }
      catch ( java.lang.InterruptedException e ) 
      {  }
   }

   

   //-------------------------------------------------------------------
   public static void main(String arg[])
   {
      int seed = 1;
      int percent = 10;
      try
      {
         seed = Integer.parseInt( arg[ 0 ] );  
      }
      catch ( Exception e)
      {
         System.out.println( "Using default seed ");
      }
      try
      {
         percent = Integer.parseInt( arg[ 1 ] );  
      }
      catch ( Exception e)
      {
         System.out.println( "Using default percent");
      }
      
      
      new Frame( );
      new Lab20( 10, 8, seed, percent );
   }
}
