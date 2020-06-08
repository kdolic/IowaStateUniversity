import java.util.Scanner;

/**
 * Code for P5.2
 * @Kenan Dolic
 */
public class CalculateTax
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      System.out.print("Enter your status (Single or Married):");
      String status = in.next();

      System.out.print("Enter your taxable income:");
      double income = in.nextDouble();

      double tax = 0.0;

      
      // Your work starts here. Do not change the codes above.
      
      if(status.equals("Single"))
      {
    	  if(income > 0 && income <= 8000)
    	  {
    		  tax = (income * .10);
    	  }
    	  else if(income > 8000 && income <= 32000)
    	  {
    		  tax = (income * .15) + 800;
    	  }
    	  else
    	  {
    		  tax = (income * .25) + 4400;
    	  }
      }
      
      
      if(status.equals("Married"))
      {
    	  if(income > 0 && income <= 16000)
    	  {
    		  tax = (income * .10);
    	  }
    	  else if(income > 16000 && income <= 64000)
    	  {
    		  tax = (income * .15) + 800;
    	  }
    	  else
    	  {
    		  tax = (income * .25) + 4400;
    	  }
      }
      
      
      // Your work ends here. Do not change the codes below.
      
      System.out.printf("You owe $%.2f in tax.\n", tax);
      
      in.close();
   }
}
