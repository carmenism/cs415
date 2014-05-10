/**
 * MapPanel.java 
 * 
 * @author mlb
 * sp08
 */
import wheelsunh.users.*;
import java.awt.Point;
import java.awt.event.*;
import java.util.*;

public class MapPanel extends Image
{  
    Point lastMousePosition;
    MarkerGroup myGroup;
    MarkerSpecifications holder;
    LastMarker last;
    ArrayList< Marker > list;
    
    //----------------------------------------------------------
    /**
     * MapPanel
     * 
     */  
    public MapPanel( MarkerGroup g ,  MarkerSpecifications ch , LastMarker l )
    {
        super( "montreal.jpg" );
        setLocation( 0, 0 );  
        list = new ArrayList<Marker> ( );
        setSize( 700, 450 );
        myGroup = g;
        holder = ch;     
        last = l;
    }
    
    //----------------------------------------------------------
    /**
     * mouseClicked
     * 
     */
    public void mouseClicked( MouseEvent me )
    {
       list.add( new Marker( me.getPoint().x, me.getPoint().y, holder, myGroup ) ); 
       if ( last != null )
           last.set( list.get( list.size( ) - 1 ) );
    }
}