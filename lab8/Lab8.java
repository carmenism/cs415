/** 
 *  Lab8.java: Test program for interface exercises. CS415, Fall 2007
 *  
 * @author CS 415 
 */

import wheelsunh.users.Frame;
import java.awt.Color;
import java.util.*;

public class Lab8 extends Frame 
{        
    //------------------ constructors ---------------------------------------------
    public Lab8() 
    {  
       // Add code here to create Piano and Comet objects
       Piano p1 = new Piano( 100, 100 );
       Piano p2 = new Piano( 200, 300 );
       p2.setFallIncrement( 100 );
       Comet c1 = new Comet( 400, 100 );
       Comet c2 = new Comet( 200, 200 );
       c1.setFallIncrement( 20 );
    }
    
    //---------------------------- main -----------------------------------------
    public static void main(String[] args) 
    {
        Lab8 app = new Lab8();
    }
}