import java.awt.Color;

public class MyFunctions
{
   public static final double NORMAL = 98.6;  
   
   public static double sphereVolume( double r )
   {
      return ( 4 * Math.PI * Math.pow( r, 3 ) / 3 );      
   }
   
   public static boolean isEven( int n )
   {
      if( n % 2 == 0 )
         return true;
      else
         return false;
   }
   
   public static boolean hasFever( double t )
   {
      if( t > NORMAL )
         return true;
      else
         return false;
   }
   
   public static double ellipseC( double h, double w )
   {
      return ( Math.PI * ( 3 * ( h + w ) - Math.sqrt( Math.pow( ( 3 * h + w ), 2 ) ) ) );
   }
   
   public static Color switchRedBlue( Color c )
   {
      int r = c.getRed( );
      int g = c.getGreen( );
      int b = c.getBlue( );
      return new Color( b, g, r );
   }
}