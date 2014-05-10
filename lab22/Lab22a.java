/**
 * Lab22a -- Program to test Bin.java
 */

import java.util.*;
   
public class Lab22a
{
   //---------------- instance variables --------------------------------
    
   //------------------------- main -----------------------------------------                          
   public  static void main( String[] args )
   {      
      double[] t1Data = { -10, 0, 8, 12, 23, 34, 45, 56, 78, 79, 80, 100, 110 };
      
      System.out.println( "+++++++++++++++++ test 1 +++++++++++++++++++++++++++" );
      double[ ] fbins = Bin.defineBinBounds( 0, 100, 10 );
                                   
      doTest1( t1Data, fbins );
      
      System.out.println( "+++++++++++++++++ test 2 +++++++++++++++++++++++++++" );
      fbins = Bin.defineBinBounds( 10, 80, 10 );
      doTest2( t1Data, fbins );
   }
   //----------------------- doTest ------------------------------------   
   public static void doTest1( double[] inData, double[] binData )
   {      
      int outOfRange = 0;
      System.out.println( "---------- test: bin bounds array  ------------" );
      
      if ( binData == null )
         System.out.println( "***Error*** defineBinBounds returned null" );
      else
      {
         for ( int i = 0; i < binData.length; i++ )
            System.out.print( binData[ i ] + " " );
         System.out.println( "\nCorrect answer:" );
         System.out.println("0.0 10.0 20.0 30.0 40.0 50.0 60.0 70.0 80.0 90.0 100.0  ");
         
         System.out.println( "---------- test: bin counts array  ------------" );
         
         int[] binCounts  = new int[ binData.length - 1 ];
         
         for ( int i = 0; i < inData.length; i++ )
               outOfRange += Bin.binUpdate( inData[ i ] , binData, binCounts);
                
         for ( int i = 0; i < binCounts.length; i++ )
            System.out.print( binCounts[ i ] + " " );
         System.out.println( "   outOfRange: " 
                               + outOfRange  ); 
         System.out.println( "Correct answer:" );
         System.out.println(" 2 1 1 1 1 1 0 2 1 0  "  + "outOfRange: " + 3);
         System.out.println( "_________________________________________________" );
      }
   }
   
    public static void doTest2( double[] inData, double[] binData )
   {   
       int outOfRange = 0;
      
       System.out.println( "---------- test: bin bounds array  ------------" );
      
      if ( binData == null )
         System.out.println( "***Error*** defineBinBounds returned null" );
      else
      {
         for ( int i = 0; i < binData.length; i++ )
            System.out.print( binData[ i ] + " " );
         System.out.println( "\nCorrect answer:" );
         System.out.println("10.0 17.0 24.0 31.0 38.0 45.0 52.0 59.0 66.0 73.0 80.0  ");
         
         System.out.println( "---------- test: bin counts array  ------------" );
         
         int[] binCounts  = new int[ binData.length - 1 ];

         for ( int i = 0; i < inData.length; i++ )
               outOfRange += Bin.binUpdate( inData[ i ] , binData, binCounts);
         
         for ( int i = 0; i < binCounts.length; i++ )
            System.out.print( binCounts[ i ] + " " );
         System.out.println( "   outOfRange: " 
                               + outOfRange  ); 
         System.out.println( "Correct answer:" );
         System.out.println("1 1 0 1 0 1 1 0 0 2  "  + "outOfRange: " + 6);
         System.out.println( "_________________________________________________" );
      }
   }
   
   
}