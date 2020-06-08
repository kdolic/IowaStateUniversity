package homework5;

import java.util.Scanner;

/**
 * @author kdolic
 * MIS207
 */
public class Homework5 
{
    public static void main(String[] args) 
    {
        double householdIncome = 0;
        double refundAmount;
        int numberOfChildren;
    
       Scanner in = new Scanner(System.in);
      
        while(householdIncome != -1)
        {
          System.out.println("Enter household income (-1 to quit): ");
          householdIncome = in.nextDouble();
            
            if(householdIncome != -1)
            {
               System.out.println("Enter the number of children in your household: ");
               numberOfChildren = in.nextInt();
               
               refundAmount = finAssist(householdIncome, numberOfChildren);
               System.out.printf("You are eligible for a refund amount: $" + refundAmount);
               System.out.println();
            }
        }
    }
    
    public static double finAssist(double householdIncome, int numberOfChildren)
    {
        double refundAmount = 0;
        
        if(householdIncome > 40000)
        {
            refundAmount = 0;
        }
        else if(householdIncome >= 30000 && numberOfChildren >= 3)
        {
            refundAmount = (1000 * numberOfChildren);
        }
        else if(householdIncome >= 20000 && numberOfChildren >= 2)
        {
            refundAmount = (1500 * numberOfChildren);
        }
        else if(householdIncome < 20000)
        {
            refundAmount = (2000 * numberOfChildren);
        }
        return refundAmount;
    }
}


