/** 
 * Bin.java - encapsulate static methods to help binning 1-D data
 */

public class Bin
{

   //---------------- defineBinBounds( double, double, int ) ------------------
   /**
    * Define an array that encapsulates the bin boundaries
    * This method can only define bin boundaries that are of equal size, but the
    * rest of the code doesn't care if this is true or not.
    */
   public static double[] defineBinBounds( double min, double max, int nBins )
   {
      double[] arr = new double[nBins + 1];
      double binSize;
      if (max <= min || nBins <= 0)
         return null;
      else
      {
         binSize = (max - min)/nBins;
         for (int i = 0; i < nBins + 1; i++)
         {
            arr[i] = i * binSize + min;
         }
         return arr;
      }
   }
   
   //------------------ binUpdate( double, double[], int[]  ) --------------------------
   /**
    *  Find the correct bin index "i" for "val' and increment that index in "binCounts".
    * Return 0 is the index is found and return 1 if "val" is out of range 
    */
   public static int binUpdate( double val, double[] binBounds, int[] binCounts )
   {
      int returnVal = 1;
      if (binCounts.length == binBounds.length - 1 &&
          binBounds[0] <= val && binBounds[binBounds.length - 1] > val)
      {
         for (int i = 0; i < binCounts.length; i++)
         {
            if (val >= binBounds[i] && val < binBounds[i + 1])
            {
               binCounts[i]++;
               returnVal = 0;
            }
         }
         return returnVal;
      }
      else
         return 1;
   }
   
   
      
   //------------------- main ---------------------------------------------------
   /**
    * empty main code; you do not need to add anything here, but if you want to
    * have some unit tests, you can put them here.
    * 
    * You do not need to construct an instance of the class -- everything is done
    * in static methods.
    */
   public static void main( String[] args )
   {
      defineBinBounds(0, 100, 10);
   }
   
}
   
