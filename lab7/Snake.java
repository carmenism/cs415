/**
 * Snake.java -- 
 *
 */
import wheelsunh.users.*;
import java.awt.Point;


public class Snake 
{
    //-------------------- instance variables ------------------------------
    private int direction;
    private Point last,next;
 
    
    //---------------------- Constructor -------------------------------------
    /**
     * initialize with a cursor location and a location for the widget that
     * shows the current length feedback menus.
     */
    public Snake ( int locX, int locY) 
    {
        last = new Point(locX,locY);
        
        direction = 0;
    }
    
    //---------------------------------------------------------
    public void turnLeft( ) 
    {
        if( direction == 0)
            direction = 3;
        else
            direction = (direction -1);
    }
    
    //---------------------------------------------------------
    public void turnRight( ) 
    {
        direction = (direction +1 ) %4;
    }
    
    //---------------- setLocation -----------------------------------------
    public void move( int  inc) 
    {      
        if (direction == 0)//right
        {
            next = new Point( last.x + inc, last.y );
        }
        else if (direction == 1)//down
        {
            next = new Point( last.x , last.y + inc );
        }
        else if (direction == 2)//left
        {
            next = new Point( last.x -inc , last.y );
        }
        else //up
        {
            next = new Point( last.x  , last.y-inc );
        }
        
        new Line(last,next);      
        last = next;      
    }

    
    //---------------- getLocation ------------------------------------------
    public static void main(String a[])
    {
        Frame f = new Frame();
        Snake s = new Snake( 100,100);
        s.move(12);
        s.turnLeft();
        s.move(12);
    }
    
}