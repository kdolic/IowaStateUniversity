import java.util.Scanner;

/**
 * Code for P6.13
 * @Kenan Dolic
 */
public class BarEntrance
{
   public static void main(String[] args)
   {
      final int MAX_PEOPLE = 100;
      int totalPeople = 0; // Initially empty

      Scanner input = new Scanner(System.in);
      boolean done = false; // This variable becomes true when totalPeople reaches MAX_PEOPLE
      while (!done)
      {
         System.out.println("People entering or leaving: ");
         int change = input.nextInt();
         
         // Your work starts here. Do not change the codes above.
         
         if(totalPeople + change <= MAX_PEOPLE)
         {
        	System.out.println("Come in! We are not at capacity yet!");
        	totalPeople += change;
        	
        	if(totalPeople == MAX_PEOPLE) {
        		done = true;
        		
        	}
         }
         
         // Your work ends here. Do not change the codes below.

         System.out.println("People in bar: " + totalPeople);
      }
      System.out.println("Bar is full");
      input.close();
   }
}