import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class Tile extends Rectangle
{
   //------------------------ instance variables --------------------------
   private TextBox t;
   private int count, i, j, size;
   
//------------------------- Constructors -------------------------------
   public Tile( int i, int j, int size )
   {
      super(  );
     
      setFillColor( Color.BLACK);
      setFrameColor( Color.GRAY );
      setSize( size, size );
      this.i = i;
      this.j = j;
      this.size = size;
      
      count = 0;
      
   }
   
   //------------------------------------------------------------------- 
   public void setCount( int c )
   {
      count = c;
   }
 
   //-------------------------------------------------------------------
   public void mouseClicked( MouseEvent e )
   {   
      hide(); 
      t = new TextBox( );
      t.setLocation( j * size, i * size );
      t.setFillColor( Color.WHITE);
      t.setFrameColor( Color.GRAY );
      t .setSize( size, size );
      t.setText("" + count );     
   }
   
   //--------------------------- main -----------------------------------
   public static void main( String args[ ] )
   {
      Frame f = new Frame( );
      Tile  oneTile = new Tile( 10, 8, 8);
   }
   
   
} 
