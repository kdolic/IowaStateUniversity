/*
 * @author Kenan Dolic
 */
package hw4;

import java.util.Random;

import api.Generator;
import api.Position;
import api.Shape;

/**
 * Generator for Shape objects in MagicTetris.  All six shapes
 * are equally likely, and the generated shape is magic with
 * 20% probability.
 */
public class BasicGenerator implements Generator
{

/**
 * randNum - initialize new random number
 * ans - randomly takes the next 6 inputs (for each of the shapes)
 * rand - another new random initialized
 * magic - random number up to 100, each shape has up to 20% chance
 */
  @Override
  public Shape getNext(int width)
  {
    Random randNum = new Random();
    int ans = randNum.nextInt(6)+1;
    Random rand = new Random();
    int magic = rand.nextInt(100)+1;
	
    switch (ans)
    {
    case 1:
    {
    	return new LShape(new Position(-1, (width/2) + (1)), magic <= 20);
    }
    case 2:
    {
    	return new TShape(new Position(0, (width/2)), magic <= 20);
    }
    case 3:
    {
    	return new JShape(new Position(-1, (width/2)), magic <= 20);
    }
    case 4:
    {
    	return new IShape(new Position(-2, (width/2)), magic <= 20);
    }
    case 5:
    {
    	return new OShape(new Position(-1, (width/2)), magic <= 20);
    }
    case 6:
    {
    	return new SZShape(new Position(-1, (width/2)), magic <= 20);
    }
    }
    return null; // does not happen
    
  }
}
