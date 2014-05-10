/** 
 * Lab1.java:
 * Carmen St. Jean
 * Displays a blue box, a green rounded rectangle, a yellow ellipse,
 *     and a line.
 *
 * @author cs415
 * Created 1/19/08
 * 
 */
public class Lab1 extends wheelsunh.users.Frame
{
    //---------------- instance variables ------------------------------
    private wheelsunh.users.Rectangle box;
    private wheelsunh.users.RoundedRectangle rounded;
    private wheelsunh.users.Ellipse ellipse;
    private wheelsunh.users.Line line;
    
    // -----------------------------------------------------------------
    /** Constructor for the Lab1 class.
     */
    public Lab1( )
    {
        box = new wheelsunh.users.Rectangle(java.awt.Color.blue);
        box.setLocation(300, 100);
        rounded = new wheelsunh.users.RoundedRectangle(java.awt.Color.green);
        rounded.setLocation(500, 300);
        ellipse = new wheelsunh.users.Ellipse(java.awt.Color.yellow);
        ellipse.setLocation(100, 300);
        line = new wheelsunh.users.Line(10, 20, 400, 400);
    } 

    // -----------------------------------------------------------------
    /** main program just invokes the class constructor.
     */
    public static void main(String[] args)
    {
        Lab1 app = new Lab1();
    }
}//End of Class Lab1