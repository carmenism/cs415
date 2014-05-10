import java.io.*;
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;
import java.util.*;

public class Lab21 extends ShapeGroup
{
   private final int   SIZE = 26; // tile size
  
   
   //-------------------------------------------------------------------
   private int [ ][ ] theLab21;
   private MineTile [ ][ ] theView;
   private int [ ] [ ] theCounts;
   private int row, col;
   private  int  percent;
    
   //-------------------------------------------------------------------
   public Lab21(int r, int c, int seed, int pc) 
   {
      row = r;
      col = c;
      percent = pc;
      
      theView = new MineTile[r][c];   
      theLab21 = new int[r][c]; 
      theCounts = new int[r][c];
      
      layLab21( seed , percent );
      getCounts( );
      
      for(int i = 0; i< r; i++)
         for(int j = 0; j < c; j++)
         {
            theView[i][j] = new MineTile( i , j,  SIZE , this);
            theView[i][j].setCount(theCounts[i][j]);        
         }
        
      System.out.println( this );
   }
   
   //-------------------------------------------------------------------
   public boolean valid( int i, int j )
   {
      return i >= 0 && i < row && j >= 0 && j < col ;   
   }
   
   //-------------------------------------------------------------------
   public void count( int theI, int theJ )
   {
      for( int i= -1; i<= 1; i++ )  
         for( int j = -1; j <= 1; j++ )
             if( valid( theI + i, theJ + j ) )
                  theCounts[ theI ][ theJ ] += 
                               theLab21[ theI + i][ theJ + j ];
      
   }
   
   //-------------------------------------------------------------------
   public void getCounts( )
   {
      for( int i = 0; i< row; i++ )
         for( int j = 0; j < col; j++ )
             if( theLab21[ i ][ j ] == 1 )
                 theCounts[ i ] [ j ] = 9;
             else
                 count( i, j );    
   }
   
   
   //-------------------------------------------------------------------
   public void layLab21 ( int n , int pc)
   { 
      Random generator = new Random( n );
      
      for ( int r = 0 ; r < row ; r++ )
         for ( int c = 0; c < col ; c++ )    
            if ( generator.nextInt( 100 ) < pc )
               theLab21[ r ][ c ] = 1;               
            else
               theLab21[ r ][ c ] = 0;
   }
   
   
    //-------------------------------------------------------------------
   public void notify ( int i , int j)
   { 
   //   MineTile current = null, next = null;
      Stack< MineTile> stack= new Stack<MineTile>();
      stack.push( theView[i][j] );
      while ( !(stack.empty()) )
      {
         MineTile current = stack.pop();
         i = current.getI();
         j = current.getJ();
         for ( int incI = i - 1; incI <= i + 1; incI++ )
         {
            for ( int incJ = j - 1; incJ <= j + 1; incJ++ )
            {
               if ( this.valid( incI, incJ ) )
               {
                  MineTile next = theView[incI][incJ];
                  if( !(next.isUncovered()) && next.getCount() == 0 )
                  {
                     stack.push( next );
                     
                  }
                  next.uncover();
               }
            }
         }
      }   
   }
   
   //-------------------------------------------------------------------
   public String toString( )
   { 
      String s="The Lab21\n ";
      for ( int r = 0; r < row; r++ )
      {
         for ( int c = 0; c < col ; c++ )
            s = s + theLab21[ r ][ c ] + " ";
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
         System.out.println( "Using default seed and percent");
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
      new Lab21( 16, 20, seed, percent );
   }
}
