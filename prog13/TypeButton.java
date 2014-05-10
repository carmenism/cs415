/**
 * TypeButton.java 
 * 
 * @author mlb
 * Sp 08
 */
import wheelsunh.users.*;
import java.awt.event.*;

public class TypeButton extends Image
{ 
    MarkerSpecifications holder;
    LastMarker last;
    
    //--------------------------------------------------
    /**
     * TypeButton
     * 
     */
    public TypeButton( int x, int y,  MarkerSpecifications ch, LastMarker l )
    {
        super( "type.jpg" );
        setLocation( x, y );  
        
        setSize( 80, 25 );  
        
        holder = ch;
        last = l;
    }
    
    //--------------------------------------------------
    /**
     * mouseClicked
     * 
     */
    public void mouseClicked( MouseEvent me )
    {            
        if ( holder != null )
            holder.toggleType( );
        if ( last != null )
            last.toggleType(  ); 
    } 
}