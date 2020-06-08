import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;


/**
 * Code for HW4
 * This class process amesrestaurants.txt
 * @Kenan Dolic
 */
public class AmesRestaurants {

	public static void main(String[] args) throws Exception {

		System.out.println("###################################################");
		System.out.println("########     Restaurants Search Program    ########");
		System.out.println("###################################################");
		Scanner console = new Scanner(System.in);
		boolean continueProgram = true;
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Double> ratings = new ArrayList<Double>();
		ArrayList<Integer> numreviews = new ArrayList<Integer>();
		ArrayList<Integer> dollars = new ArrayList<Integer>();
		ArrayList<String> categories = new ArrayList<String>();
		
		System.out.print("Reading data file \"amesrestaurants.txt\"...  ");

		// Insert code to read amesrestaurants.txt and store the information into the array lists.
		
		
		BufferedReader reader;
		reader = new BufferedReader(new FileReader("amesrestaurants.txt"));
		String line = reader.readLine();
		
		while(line != null)
		{
			names.add(line);
			line = reader.readLine();
			ratings.add(Double.parseDouble(line));
			line = reader.readLine();
			numreviews.add(Integer.parseInt(line));
			line = reader.readLine();
			dollars.add(Integer.parseInt(line));
			line = reader.readLine();
			categories.add(line);
			line = reader.readLine();
		}
		
		reader.close();
		}






	private Scanner console;
		
		
		
		
}		
		System.out.println("data file loaded! \n\n");

		
		while(continueProgram) {
			System.out.println("-------------------------------------------");
			System.out.println("(W)rite text files for restaurant names"); // Type "W" for write option
			System.out.println("(P)rint all restaurants with rating > X");
			System.out.println("(S)earch by category");
			System.out.println("(Q)uit program"); // Type "Q" to quit the program
			System.out.println("-------------------------------------------");
			System.out.print("Select menu: ");
			
			String option = console.next();
			
			if(option.equals("W")) { 
				// Complete W option to write outputnames.txt
				
				BufferedWriter writer;
				writer = new BufferedWriter(new OutputStreamWriter("outputnames.txt"));
				
				
				for(String name : names)
				{
					writer.write(name + "\n");
				}
				
				writer.close();
				
				
				System.out.println();
			}else if(option.equals("P")) {
				// Complete P option. You can assume that the user will provide a double number.
				
				System.out.println("Enter X: ");
				double x = console.nextDouble();
				
				System.out.println("[Message] Printing....");
				
				ArrayList<String> ratings;
				for(int i = 0; i < ratings.size(); i++)
				{
					if(ratings.get(i) > x)
					{
						
						ArrayList<String> names;
						System.out.println(names.get(i));
					}
				}
				
				
				
				System.out.println("[Message] Output names printed. \n");
				System.out.println();
				System.out.println();
			}else if(option.equals("S")){
				// Complete S option. You can assume that the user will provide a single character.
				
				System.out.println("Enter Category: ");
				String category = console.next();
				
				System.out.println("[Message] Printing....");
				
				ArrayList<String> categories;
				for(int i = 0; i < categories.size(); i++)
				{
					if(categories.get(i).equals(category))
					{
						ArrayList<String> names;
						System.out.println(names.get(i));
					}
				}
				
				
				
				
				System.out.println("[Message] Output names printed. \n");
				System.out.println();
				System.out.println();
			}else if(option.equals("Q")){
				// Complete Q option. 
				System.out.println("[Message] Terminating program. \n\n");
				System.out.println();
				System.out.println();
				boolean continueProgram = false;
			}
		}
		
		console.close();
	}


