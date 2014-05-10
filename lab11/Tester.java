import wheelsunh.users.*;

public class Tester extends Frame
{
   
 public Tester()  
 {{
    TextBox t1 = new TextBox(
    "constant NORMAL is (98.6)::   "+ MyFunctions.NORMAL +"\n" +
    "sphereVolume(2.5) is ( 65.44984694978736)::   " + MyFunctions.sphereVolume(2.5) +"\n"+
    "hasFever( 98.6 ) is (false)::   " + MyFunctions.hasFever( 98.5) + "\n"+                          
       
    "hasFever( 98.7 ) is (true)::   " + MyFunctions.hasFever( 98.7) + "\n"+   
     "isEven( 12345 ) is (false)::   " + MyFunctions.isEven( 12345 ) + "\n"+ 
   "isEven( 1234 ) is (true)::   " + MyFunctions.hasFever( 1234 ) + "\n"+ 
       "ellipseC( 1.23, 4.34 ) is (27.26902423315941 )::   " + MyFunctions.ellipseC( 1.23, 4.34 ) + "\n"+                       
         "color( 20, 60 , 120) is ( color( 120, 60, 20)::   " + MyFunctions.switchRedBlue(new java.awt.Color( 20,60,120) ) + "\n"
                                
                                );
    
    t1.setSize(600,200);
             
   new Rectangle( MyFunctions.switchRedBlue( java.awt.Color.RED) );
    
 }}
   
   public static void main(String a[])
   {
      
      
    new Tester();  
   }
   
   
   
   
   
}