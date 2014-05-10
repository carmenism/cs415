/**
 * Lab22b -- Program to test TwoD.java
 */

public class Lab22b
{
   //---------------- instance variables --------------------------------
   
   //------------------- printByRow ------------------------------------
   /**
    * print a 2D array by row
    */
   static void printByRow( double[][] vals )
   {
      for ( int r = 0; r < vals.length; r++ )
      {
         for ( int c = 0; c < vals[ r ].length; c++ )
         {
            System.out.print( vals[ r ][ c ] + "      " );
         }
         System.out.println();
      }      
   }
    
   //------------------------- main -----------------------------------------                          
   public  static void main( String[] args )
   {
      // test  - 2D arrays
      
      int nRows = 4, nCols = 3;
      double[][] vals;
      vals = new double[ nRows ][ nCols ];
      for ( int r = 0; r < nRows; r++ )
      {
         for ( int c = 0; c < nCols; c++ )
         {
            vals[ r ][ c ] = (( r + 1 )) * 6 % 22 - (2 * c ) %3;
         }
      }  
      
      vals[ nRows -1][0] += 16;
      /****/
      System.out.println( "--------------- data --------------" );
      printByRow( vals );
      System.out.println( "-----------------------------------" );
      /****/
      double[] sums = TwoD.sumRows( vals );
      
      System.out.print( "Row sums:  " );
      for ( int i = 0; i < sums.length; i++ )
         System.out.print( sums[ i ] + " " );
      System.out.println();
      System.out.println( "--------------" );
      /****/
      double[] max = TwoD.maxCols( vals );
      
      System.out.print( "Column Maxs:  " );
      for ( int i = 0; i < max.length; i++ )
         System.out.print( max[ i ] + " " );
      System.out.println();
      System.out.println( "--------------" );
      
      
      
   }
}