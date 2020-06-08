/*
 * @author Kenan Dolic
 */
package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;

public class SZShape extends AbstractShape{

	public SZShape(Position position, boolean magic)
	{
		super(position, magic, Color.GREEN);
		
		position = getPos();
		Position p = new Position(position.row(), position.col()); //creates the positions of the shape based on coordinates
		Position p1 = new Position(position.row()+1, position.col());
		Position p2 = new Position(position.row()+1, position.col()+1);
		Position p3 = new Position(position.row()+2, position.col()+1);
		
		Cell[] cells = new Cell[4];
		
		cells[0] = new Cell(new Block(Color.GREEN,magic), p); //creates each cell/block along with color of shape, 1st block is magic
		cells[1] = new Cell(new Block(Color.GREEN,false), p1);
		cells[2] = new Cell(new Block(Color.GREEN,false), p2);
		cells[3] = new Cell(new Block(Color.GREEN,false), p3);
		
	}
	//comments in interface
	@Override
	public Cell[] getCells() 
	{
		return super.getCells();
	}
	
	@Override
	public void shiftDown() 
	{
		super.shiftDown();
	}
	
	@Override
	public void shiftLeft() 
	{
		super.shiftLeft();
	}
	
	@Override
	public void shiftRight() 
	{
		super.shiftRight();
	}
	
	@Override
	 public Shape clone()
	  {
		return super.clone();
	  }
	
	@Override
	public void transform()
	{
		//cannot figure out
		
	}
	
	@Override
	public void cycle()
	{
		super.cycle();
		
	}
		
}
