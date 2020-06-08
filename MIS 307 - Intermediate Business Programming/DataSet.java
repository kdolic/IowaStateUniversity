import java.util.*;


/**
 * Code for Problem 1 of HW2
 * @Kenan Dolic
 */
public class DataSet
{
	private ArrayList<Double> data;
   
   /**
      Constructs an empty data set.
      @param maximumNumberOfValues the maximum this data set can hold
   */
   public DataSet()
   {
	   data = new ArrayList<Double>();
   }

   /**
      Adds a data value to the data set if there is a room in the array.
      @param value a data value
   */
   public void add(double value)
   {
	   data.add(value);
   }

   /**
      Gets the sum of the added data.
      @return sum of the data or 0 if no data has been added
   */
   public double getSum()
   {
	   double sum = 0.0;
	   
	   if(data.size() < 0) 
	   {
		   return 0.0;
	   }
	   
	   for(int i = 0; i < data.size(); i++)
	   {
		   sum = sum + data.get(i);
	   }
	   
	return sum;
   }

   /**
      Gets the average of the added data.
      @return average of the data or 0 if no data has been added
   */
   public double getAverage()
   {
	   if(data.size() < 0)
	   {
		   return 0.0;
	   }
	   
	   return getSum() / data.get(i);
	   //  ??? not sure how to get the average from the data added above
   }

   /**
      Gets the maximum value entered.
      @return maximum value of the data
      NOTE: returns -Double.MAX_VALUE if no values are entered.
   */
   public double getMaximum()
   {
	   double max = data.get(0);
	   
	   if(data.size() < 0)
	   {
		   return Double.MAX_VALUE;
	   }
	   
	   for(int i = 0; i < data.size(); i++)
	   {
		   if(max < data.get(i))
		   {
			   max = data.get(i);
		   }
	   }
	   return max;
   }

}
