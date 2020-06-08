/**
 * Code for E6.2
 * @Kenan Dolic
 */
public class Sums {

	public static void main(String[] args) {

		// COMPLETE EACH PROBLEM BELOW //
		
		//////  E6.2(a)  //////
		int sum_a = 0;
	    // The sum of all even numbers between 2 and 100
	    
		for(int i = 2; i <= 100; i = i + 2)
		{
			sum_a = sum_a + i;
		}
		
		
	    // Output the result for E6.2(a)
	    System.out.println("The sum is " + sum_a);
	    
	    
        //////  E6.2(b)  //////
	    int sum_b = 0;
	    // The sum of all squares between 1 and 100
	 
	    
	    for(int i = 1; i <= 100; i++)
	    {
	    	sum_b += (int) Math.pow(i, 2);
	    }
	    
	    // Output the result for E6.2(b)
	    System.out.println("The sum is " + sum_b);

	}

}

