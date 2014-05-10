/**
 * InvalidColorException
 * 
 * Defines an exception if a color component is outside the valid range
 * ( 0, 255 ).
 * 
 * For most user-defined exceptions, you don't really need to do much of 
 * anything except construct it and usually all you need is a String with
 * a meaningful error message and this is just passed along to the super class.
 */

public class InvalidColorException extends Exception
{
   InvalidColorException( String message )
   {
      super( message );
   }
}