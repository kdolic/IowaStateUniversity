package homework6;
import java.util.Scanner;

/**
 *
 * @author kdolic
 */
public class Homework6 
{
    public static void discount(double[] prices, boolean[] isPet, int nItems)
    {
        if(nItems >= 5)
        {
            boolean pets = false;
            for(int i = 0; i<isPet.length; i++)
            {
                if(isPet[i] == true)
                {
                    pets = true;
                    break;
                }
            }
            for(int i = 0; i<isPet.length; i++)
            {
                if(isPet[i] == false)
                {
                    prices[i] = prices[i] * 0.8;
                }
            }
        }
    }

    public static void main(String args[]) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total items: ");
        int num = scanner.nextInt();
        
        double price[] = new double[num];
        boolean isPet[] = new boolean[num];
        String current;
        
        for(int i = 0; i<num; i++)
        {
            System.out.println("Enter price of item: ");
            price[i] = scanner.nextDouble();
            
            System.out.print("Is it a pet? (Y/N): ");
            current = scanner.next();
            
            if(current.charAt(0) == 'Y')
            {
                isPet[i] = true;
            }
            else
            {
                isPet[i] = false;
            }
        }
        
        discount(price,isPet,num);
        for(int i = 0; i<num; i++)
        {
            System.out.println(price[i]);
        }

    }
}

