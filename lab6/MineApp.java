import wheelsunh.users.Frame;
import java.awt.Color;
import java.util.*;


/** 
 * MineApp.java:
 *   Displays a 2D array of Tiles
 *  most are SafeTiles, a few are MinedTiles
 */
public class MineApp extends Frame 
{ 
    private Tile [][] board;
    int offset;
    int boardSize;
    Random generator;
        
    //------------------ constructors ---------------------------------------------
    public MineApp() 
    {     
        boardSize = 8;
        offset = 25;
        board = new Tile[ boardSize ][ boardSize ];
        generator = new Random(  19580427 );
        
        for( int i = 0 ; i < boardSize ; i++)
        {
            for( int j = 0; j < boardSize ; j++)    
            {
                if( generator.nextInt(boardSize) == 0)
                     board[i][j] = new MinedTile( offset*i, offset*j ) ;   
                else
                     board[i][j] = new SafeTile( offset*i, offset*j ) ; 
            }
        }
    }
    
    //---------------------------- main -----------------------------------------
    public static void main(String[] args) 
    {
        MineApp app = new MineApp();
    }
}