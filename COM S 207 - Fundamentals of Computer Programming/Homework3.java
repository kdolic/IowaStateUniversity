/*
 *Write a program that computes taxes for following schedule.
 */
package homework3;

import java.util.Scanner;

/**
 * @author kdolic
 */
public class Homework3 
{
    public static void main(String[] args) 
    {
        double income;
        double tax = 0.0;
        String status;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter martial status(Single or Married): ");
        status = in.next();
        
        System.out.println("Enter Income: ");
        income = in.nextDouble();
        
        if(status.equals("Single"))
        {
            if(income > 0 && income <= 8000)
            {
                tax = 0.1 * income;
            }
            else if(income > 8000 && income <= 32000)
            {
                tax = 800 + (0.15 * income);
            }
            else
            {
                tax = 4400 + (0.25 * income);
            }
        }
        
        if(status.equals("Married"))
        {
            if(income > 0 && income <= 16000)
            {
                tax = 0.1 * income;
            }
            else if(income > 16000 && income <= 64000)
            {
                tax = 1600 + (0.15 * income);
            }
            else
            {
                tax = 8800 + (0.25 * income);
            }
        }
        
        System.out.println("Tax: $" + tax);
    }
    
}
