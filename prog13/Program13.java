/**
 * Program13.java 
 * 
 * @author mlb
 * sp 08
 */
import wheelsunh.users.*;
import java.awt.Color;

public class Program13 extends Frame
{
    private MapPanel background;
    private MarkerGroup selectedMarkerGroup;
    private ColorButton colorButton;
    private TypeButton sizeButton;
    private ClearButton clearButton;
    private MarkerSpecifications specHolder;
    private LastMarker lastMarker;   
    
   //--------------------------------------------------
   /**
    * Program13
    * 
    */
    public Program13(  )                                        
    {
        specHolder = new MarkerSpecifications( );      
        lastMarker = new LastMarker( );
        selectedMarkerGroup = new MarkerGroup( lastMarker ); 
       
        background = new MapPanel( selectedMarkerGroup , specHolder, lastMarker ); 
        colorButton = new ColorButton( 220, 470, specHolder, lastMarker );     
        clearButton = new ClearButton( 320, 470,  selectedMarkerGroup );
        sizeButton = new TypeButton( 420, 470, specHolder, lastMarker );        
    }
    
    //------------------------ main --------------------------
    public static void main( String[ ] args )
    {
        Program13 map = new Program13(  );
    }
}
