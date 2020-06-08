import java.util.Scanner;


/**
 * Code for P7.12
 * @Kenan Dolic
 */
public class SeatingChart
{
   /**
      Prints the price of seats in a grid like pattern.
      @param seats a 2D array of prices
   */
   public void printSeats(int[][] seats)
   {
	   System.out.print("    ");
	   for (int j = 0; j < seats[0].length; j++)
       {
          System.out.print("s" + (j+1) + " ");
       }
	   System.out.println();
	   
      for (int i = 0; i < seats.length; i++)
      {
    	  System.out.print("r" + (seats.length-i) + ":");
         for (int j = 0; j < seats[i].length; j++)
         {
            System.out.printf("%3d", seats[i][j]);
         }
         System.out.println();
      }
   }

   /**
      Marks a seat with the price given to 0. 
      If there is no seat with the price, print an error message.
      @param seats: the array of seat prices
      @param price: the price to mark to zero
   */
   public void sellSeatByPrice(int[][] seats, int price)
   {
	  boolean availableSeat = false;
	  
	  for(int i = 0; i < seats.length; i++)
	  {
		  for(int j = 0; j < seats[i].length; j++)
		  {
			if(seats[i][j] == price)
			{
			  if(seats[i][j] != 0)
			  {
				 availableSeat = true;
				 
				 seats[i][j] = 0;
			  }
			}
		  }
	  }
	  
	  if(!availableSeat)
	  {
		  System.out.println("Sorry, no seat found with that price."); 
	  }
	  else
	  {
		  System.out.println("There is a seat available for you!");
	  }
	  
   }

   /**
      Marks a seat based on a given row and seat number from input.
      If seat or row numbers are invalid, print error messages.
      If the seat is already occupied, print error message.
      @param seats: the array of seat prices
      @param rownum: row number
      @param seatnum: seat number
   */
   public void sellSeatByNumber(int[][] seats, int rownum, int seatnum)
   {
	  
      
	   
	  if(seats[rownum][seatnum] == 0)
	  {
		  System.out.println("Sorry, seat already occupied.");
	  }
	  else if(seatnum >= seats[0].length)
	  {
		  System.out.println("Sorry, invalid seat number.");
	  }
	  else if(rownum >= seats.length)
	  {
		  System.out.println("Sorry, invalid row.");
	  }
	  else
	  {
		  System.out.println("There is a seat available for you!");
	  }
   }

   public static void main(String[] args)
   {
      // initial values come from problem description
      int[][] seats = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
            { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
            { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
            { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
            { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
            { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
            { 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 },
            { 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
            { 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };

      SeatingChart seating = new SeatingChart();
      seating.printSeats(seats);

      System.out.println("Pick by <s>eat or <p>rice or <q> to quit: ");
      Scanner in = new Scanner(System.in);
      String choice = in.next();
      while (!choice.equals("q"))
      {
         if (choice.equals("s"))
         {
        	 System.out.println("Enter the row number you want: ");
             int rownum = in.nextInt();
             System.out.println("Enter the seat number you want: ");
             int seatnum = in.nextInt();
            seating.sellSeatByNumber(seats, rownum, seatnum);
         }
         else
         {
            // pick by price
            System.out.println("What price do you want to buy?");
            int price = in.nextInt();
            seating.sellSeatByPrice(seats, price);
         }
         seating.printSeats(seats);
         System.out.println("Pick by <s>eat or <p>rice or <q> to quit: ");
         choice = in.next();
      }
      
      in.close();
   }
}
