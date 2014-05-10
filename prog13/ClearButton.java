/**
 * ClearButton.java 
 * 
 * @author mlb
 * sp 08
 */
import wheelsunh.users.*;
import java.awt.event.*;

public class ClearButton extends Image
{ 
    MarkerGroup myMarkerGroup;
    
    //-------------------------------------------------------
    /**
     * ClearButton 
     * 
     */
    public ClearButton( int x, int y,  MarkerGroup g )
    {
        super( "ungroup.jpg" );
        setLocation( x, y );  
        setSize( 80, 25 );  
        myMarkerGroup = g;
    }
    
    //-------------------------------------------------------
    /**
     * mouseClicked 
     * 
     */
    public void mouseClicked( MouseEvent me )
    {
        if( myMarkerGroup != null)
            myMarkerGroup.clear( );
    }
}