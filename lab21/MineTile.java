import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class MineTile extends Rectangle
{
   //------------------------ instance variables --------------------------
   private TextBox t;
   private int count, i, j, size;
   private Lab21 mines;
   private boolean uncovered;
   
//------------------------- Constructors -------------------------------
   public MineTile( int i, int j, int size , Lab21 m)
   {
      super(  );
      setLocation( j  *size, i * size );
      setFillColor( Color.BLACK);
      setFrameColor( Color.GRAY );
      setSize( size, size );
      this.i = i;
      this.j = j;
      this.size = size;
      mines = m;
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
     uncover();
      if( count == 0)
         mines.notify( i, j );
     
          
   }
   
   //-------------------------------------------------------------------
   public void uncover()
   {
      hide(); 
      t = new TextBox( );
      t.setLocation( j * size, i * size );
      t.setFillColor( Color.WHITE);
      t.setFrameColor( Color.GRAY );
      t .setSize( size, size );
      t.setText("" + count ); 
      uncovered = true;     
   }
   
   //-------------------------------------------------------------------
   public int getI()
   {
      return i;  
   }
   
   //-------------------------------------------------------------------
   public int getJ()
   {
      return j;  
   }
   
   
   //-------------------------------------------------------------------
   public int getCount()
   {
      return count;  
   }
   
   //-------------------------------------------------------------------
   public boolean isUncovered()
   {
      return uncovered;  
   }
   
   
   
} 
