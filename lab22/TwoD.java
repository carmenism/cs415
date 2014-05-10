/**
 * TwoD.java -- utilities for 2D arrays
 */

public class TwoD
{
   //-------------------- sumRows( double[][] ) ----------------------------
   /**
    * compute the sums of all rows and return as an array
    */
   public static double[] sumRows( double[][] vals )
   {
      double[] arr = new double[vals.length];
      for (int i = 0; i < vals.length; i++)
      {
         for (int j = 0; j < vals[i].length; j++)
         {
            arr[i] += vals[i][j];
         }
      }
      return arr;
//      return new double[ 0 ];  // just to get by the compiler
   }
   



   
    //-------------------- maxCols( double[][] ) --------------------
   /**
    * compute the max of all columns and return as an array 
    */
   public static double[] maxCols( double[][] vals )
   {
      double[] maxOfCol = new double[vals[0].length];
      for (int j = 0; j < vals[0].length; j++)
      {
         maxOfCol[j] = vals[0][j];
         for (int i = 0; i < vals.length; i++)
         {
            if (vals[i][j] > maxOfCol[j])
            {
               maxOfCol[j] = vals[i][j];
            }
         }
      }
      return maxOfCol;

//    return new double[ 0 ];  // just to get by the compiler  
   }
   
  }