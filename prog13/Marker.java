/**
 * Marker.java 
 * 
 * @author mlb
 * sp08
 */
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;

public class Marker extends ShapeGroup implements MarkerInterface, Draggable
{ 
   //-------------- instance variables -----------------
   private Point lastMousePosition;
   private Color myColor = Color.WHITE;
   private int mySize = 50;
   private int myX, myY;
   private int myType = 0;
   private boolean inGroup;
   private MarkerGroup myGroup;
   private MarkerSpecifications specs;
   private Rectangle myR;
   private Ellipse myE;
   
   
   
   //-------------------------------------------------------------------
   /**
    * Marker
    * 
    */ 
   public Marker( int x, int y, MarkerSpecifications s, MarkerGroup g )
   {
      specs = s;
      if  ( s != null )
      {
         myColor = s.getColor( );
         myType = s.getType();
      }
      
      myE = new Ellipse( );   
      myE.setSize( mySize, mySize);
      add( myE);
      
      myR = new Rectangle( );   
      setColor( myColor );
      myR.setSize( mySize, mySize);
      add( myR);
      
      setLocation(x, y);
      
      if( myType == 0 )
      {
         myE.hide( ); 
         myR.show( );
      }
      else
      {
         myR.hide(  ); 
         myE.show(  );
      }
      
      myGroup = g;
      inGroup = false;
   }
   
   
   //------------------------------------------------------------------------
   /**
    * set color  semi transparent
    */
   public void setColor( Color newColor )
   {
      myR.setColor( new 
           Color(  newColor.getRed( ), newColor.getGreen( ), newColor.getBlue( ), 60 ) );
      
      myR.setFrameColor( Color.WHITE );
      
      myE.setColor( new 
         Color(  newColor.getRed( ), newColor.getGreen( ), newColor.getBlue( ), 60  ) );
      
      myE.setFrameColor( Color.WHITE );
   }
   
   
   //------------------------------------------------------------------------
   /**
    * toggle type of marker
    */
   public void toggleType(  )
   {
      if( myType == 1)
      {    
         myE.hide( ); 
         myR.show( );
         myType = 0;
      }
      else
      {
         myR.hide(  ); 
         myE.show(  );
         myType = 1;
      }
   }    
   
   
   
   //--------------------------------------------------
   /**
    * clear 
    */
   public void clear()
   {
      inGroup = false;
   }
   
   
   //--------------------------------------------------
   /**
    * mouseClicked -- 
    *       no modifiers:  add marker to group
    *       ctrl:          shrink 2 pixels
    *       shift:         grow 2 pixels
    * 
    */
   public void mouseClicked( MouseEvent me )
   { 
      String mod = me.getMouseModifiersText( me.getModifiers( ) );
      
      if( mod.equals( "Ctrl+Button1" ) )
      {
         if ( mySize >= 4 )
         {
            mySize -= 2;
            myR.setSize( mySize, mySize );
            myE.setSize( mySize, mySize );
            setLocation( myX, myY );
         }
      }
      else if( mod.equals("Shift+Button1") )
      {
         mySize += 2;
         myR.setSize( mySize, mySize );
         myE.setSize( mySize, mySize);
         setLocation( myX, myY );
      }
      
      else if ( !inGroup && myGroup != null )
      {
         myGroup.addMarker( this );
         inGroup = true;
      }
   }
   
   //-------------------------------------------------------------------
   public void setLocation( int x, int y )
   {
      
      myX =  x ;
      myY =  y ;
      myE.setLocation( myX - mySize / 2, myY - mySize / 2 );  
      myR.setLocation( myX - mySize / 2, myY - mySize / 2 );  
   }
   
   //-------------------------------------------------------------------
   public int getXLocation( )
   {   
      return myX;   
   }
   
   //-------------------------------------------------------------------
   public Point getLocation( )
   {      
      return new Point(myX,myY);       
   }
   
   //-------------------------------------------------------------------
   public int getYLocation( )
   {    
      return myY;       
   }
   
   //-------------------------------------------------------------------
   public int getSize( )
   {      
      return mySize;     
   }  
   
   //-------------------------------------------------------------------
   public int getHeight( )
   {      
      return mySize;     
   }  
   
   //-------------------------------------------------------------------
   public int getWidth( )
   {      
      return mySize;     
   }  
}