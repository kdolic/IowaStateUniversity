package homework4.pkg29;

import java.util.Scanner;

/**
 *
 * @author kdolic
 */
public class Homework429 
{
    public static void main(String[] args) 
    {
        double target;
        double current;
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter target stock price: ");
        target = in.nextDouble();
        
        while(true)
        {
            System.out.println("Enter current stock price: ");
            current = in.nextDouble();
            
            if(current >= target)
            {
                System.out.println("Stock price is equal to or exceeds target price.");
                break;
            }
        }
    }
    
}
