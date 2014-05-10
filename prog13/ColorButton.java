/**
 * ColorButton.java 
 * 
 * @author mlb
 * sp08
 */
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JColorChooser;

public class ColorButton extends Image
{
    private JColorChooser choose;
    private MarkerSpecifications holder;
    private LastMarker last;
    
    //-----------------------------------------------------
    /**
     * ColorButton
     * 
     */
    public ColorButton( int x, int y,  MarkerSpecifications ch, LastMarker l)
    {
        super("color.jpg" );
        setLocation( x, y);  
        
        setSize( 80, 25 );  
        choose = new JColorChooser( );
        
        holder = ch;
        last = l;
    }
    
    
    //-----------------------------------------------------
    /**
     * mouseClicked
     * 
     */
    public void mouseClicked( MouseEvent me )
    {
        Color c = choose.showDialog( null, "Choose the shape color", Color.RED );
        
        if( c != null )
        {
            if( holder != null )
                holder.setColor( c );
            if( last != null )
                last.setColor( c );
        }
    }  
}