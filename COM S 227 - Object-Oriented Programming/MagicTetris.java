/*
 * @author Kenan Dolic
 */
package hw4;

import java.util.ArrayList;
import java.util.List;
import api.AbstractGame;
import api.Position;

/**
 * MagicTetris implementation.
 */
public class MagicTetris extends AbstractGame
{
	/**
	 * The current score of the game.
	 * The magic of the game (initialized as false)
	 */
	private int result = 0;
	private boolean magic;
	
  /**
   * Constructs a game with the given width (columns) and height (rows).
   * This game will use a new instance of BasicGenerator to 
   * generate new shapes.
   * @param width
   *   width of the game grid (number of columns)
   * @param height
   *   height of the game grid (number of rows)
   */
	
	
  public MagicTetris(int width, int height)
  {
    super(width, height, new BasicGenerator());
    magic = false;
  }

  @Override
  public List<Position> determinePositionsToCollapse()
  {
	  List<Position> score = new ArrayList<Position>();
    
    int current = 1;  //current value of position
    int count; //counter for the score/magic
    
    if(magic)
    {
    	magic = false;
    	
    	for(int col = 0; col < getWidth(); col++)
    	{
    		for(int row = 0; row < getHeight(); row++)
    		{
    			if(getBlock(row, col) == null) // when block is empty
    			{
    				for(int j = row; j >= 0; j--)
    				{
    					if(getBlock(j, col) != null) // when block not empty
    					{
    						score.add(new Position(row, col)); //increases score of game and collapses blocks/position
    						break;
    				}
    			}
    		}
    	}
    }
  } else {
	  
	  for(int row = 0; row < getHeight(); row++)
	  {
		  current = 1;
		  for(int col = 0; col < getWidth(); col++)
		  {
			  if(getBlock(row, col) == null) //when block is empty
			  {
				  current = 0; //blocks/position collapse 
				  break;
			  }
		  }
		  
		  if (current == 1)
		  {
			  count = 0;
			  
			  for(int k = 0; k < getWidth(); k++)
			  {
				  score.add(new Position(row, k)); //adds score to game for next set of blocks/positions
				  
				  if(getBlock(row, k).isMagic())
				  {
					  count++;
				  }
				  
				  if(count >= 3)
				  {
					  magic = true; //when 3 or more magic blocks align
				  }
			  }
			  result += Math.pow(2, count); //the points from the aligned magic blocks
		  }
	  }
  }
  return score;
}

  @Override
  protected int determineScore()
  {
    return result;
  }

}
