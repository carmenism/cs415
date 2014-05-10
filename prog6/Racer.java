/** 
 * Racer.java:
 * 
 */
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.*;

public interface Racer
{  
   //---------------mutators------------------------
   public void setLocation( int x, int y );
   public void setWeight( int weight );
   public void setHP( int hp );
   public void setName( String n );
   
   //---------------accessors------------------------
   public int getWeight( );   
   public int getHP( );
   public String getName( );
   public int getXLocation( );
   public int getYLocation( );
   
   //-----------------------------------------------
   //  Show HP and Weight
   public void mousePressed( MouseEvent e);
   
   //-----------------------------------------------
   //  Hide HP and Weight
   public void mouseReleased( MouseEvent e);
}