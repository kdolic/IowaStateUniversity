/**
 * Code for HW8
   A rectangle with integer dimensions.
   @Kenan Dolic
*/
public class Rectangle
{
   private int width;
   private int height;

   /**
      Constructs a new rectangle with integer dimensions.
      @param w width
      @param h height
   */
   public Rectangle(int w, int h)
   {
      width = w;
      height = h;
   }

   /**
      Computes the area of the rectangle.
       @return the area
   */
   public int getArea()
   {
	 if(this.width == 1)
	 {
		 return height;
	 } 
	 else 
	 {
		 Rectangle rectangle = new Rectangle(this.width - 1, this.height);
		 return this.height + rectangle.getArea();
	 }
	   
	   
   }
}
