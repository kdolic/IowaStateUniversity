package homework.pkg2;

import java.util.Scanner;

/**
 *
 * @author Kenan Dolic
 * MIS207
 */

/**
 * The following pseudocode describes how to turn a string containing a
 * ten-digit phone number (such as "4155551212") into a more readable
 * string with parentheses and dashes, like this: "(415) 555-1212".
 *      Take the substring consisting of the first three characters and
 *          surround it with "(" and ") ". This is the area code.
 *      Concatenate the area code, the substring consisting of the next three
 *          characters, a hyphen, and the substring consisting of the last four
 *          characters. This is the formatted number.
 * Translate this pseudocode into a Java program that reads a telephone number
 * into a string variable, computes the formatted number, and prints it.
 */
public class Homework2 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a ten-digit number: ");
        String num = in.next();
        
        String areaCode = "(" + num.substring(0,3) + ") ";
        String formattedNum = areaCode + num.substring(3,6) + "-" + num.substring(6,10);
        System.out.println("Formatted Number: " + formattedNum);
        
    }
    
}
