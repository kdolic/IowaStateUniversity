package homework4.pkg31;

import java.util.Scanner;

/**
 *
 * @author kdolic
 */
public class Homework431 
{
    public static void main(String[] args) 
    {
        final int MAXIMUM_PEOPLE = 100;
        int currentPeople = 0;
        
        Scanner in = new Scanner(System.in);
        
        do
        {
            System.out.println("Size of group entering: ");
            int enteringPeople = in.nextInt();
            
            if(currentPeople + enteringPeople <= MAXIMUM_PEOPLE)
            {
                System.out.println("Welcome!");
                currentPeople += enteringPeople;
            }
            else
            {
                System.out.println("Group of people exceeds capacity of the bar.");
            }
            
            System.out.println("Current number of people: " + currentPeople);
        }
        
        while(currentPeople <= MAXIMUM_PEOPLE);
        in.close();
        System.out.print("Bar is at capacity");
            
        }
        
}


