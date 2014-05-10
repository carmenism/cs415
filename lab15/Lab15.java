/**
 * Lab15.java
 * 
 */
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;
import java.util.*;


public class Lab15 extends Ellipse
{
   int myX, myY, count = 0;
   Point lastMouse;
   ArrayList<Point> pointsVisited;
   
   //-----------------------------------------------------------------------------
   //
   public Lab15 ( int ax, int ay )
   {
      super( ax, ay );
      myX = ax;
      myY = ay;    
      setColor( Color.RED );
      pointsVisited = new ArrayList<Point>( );
   }
   
   //------------------ Draggable interface methods -----------------------------
   //
   public void mousePressed( MouseEvent me )
   {
      lastMouse = me.getPoint( );
      // pointsVisited.add( count, lastMouse );
      // count++;
   }
   
   //------------------ Draggable interface methods -----------------------------
   //
   public void mouseDragged( MouseEvent me )
   {
      pointsVisited.add( count, lastMouse );
      count++;
      Point curMouse = me.getPoint( );
      pointsVisited.add( count, curMouse );
      count++;
      myX = myX + curMouse.x - lastMouse.x;
      myY = myY + curMouse.y - lastMouse.y;
      setLocation( myX, myY );
      lastMouse = curMouse;

   }
   
   //------------------ Draggable interface methods -----------------------------
   //
   public void mouseClicked( MouseEvent me )
   {  
      for( int i = 0; i < pointsVisited.size( ) - 1; i++ )
      {
         Line line = new Line( pointsVisited.get( i ), pointsVisited.get( i + 1 ) );
         line.setColor( Color.BLUE );
      }
   }
   
   //-----------------------------------------------------------------------------
   //
   public static void main( String s[ ] )
   {
      Frame f = new Frame( );
      Lab15 b = new Lab15( 600, 200  );    
   }
}
