import java.util.Scanner;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Code for HW7
 * This program reads sample HTML files and provides lookup by zip code.
 * Place the HTML files under the project folder.
 * @ Kenan Dolic
 */
public class ZipLookupWeb
{  
   public static void main(String[] args) throws IOException 
   {

	   Scanner in = new Scanner(System.in);
	   boolean more = true;
	   while (more){
		   System.out.println("Lookup by Z)ip, or Q)uit");
	       String cmd = in.nextLine();
	       
	       if (cmd.equalsIgnoreCase("Q")){
	    	   more = false;
	       }else if (cmd.equalsIgnoreCase("Z")){
	    	   System.out.println("Enter Zipcode:");
	           String zip = in.nextLine();
	           Scanner ins;
	           
	           String inputFileName = zip + ".html";
        	   FileReader inputFile = new FileReader(inputFileName);
        	   ins = new Scanner(inputFile);

	           String citystate = "";
	           String population = "";
	           String houseval = "";
	           
	           
	           // INSERT CODE TO:
	           // read each line, detect if the line contains either (1) city name or state name, (2) population, or (3) house value
			   // extract and store the information
	           
	            while(ins.hasNextLine())
	            {
	            	String line = ins.nextLine();
	            	int index1, index2, index3;
	            	
	            	if(line.indexOf("<td class='columnresult'>City and State</td>")!= -1)
	            	{
	            		index1 = line.indexOf("<b>");
	            		citystate = line.substring(index1 + 3).trim();
	            	}
	            	else if(line.indexOf("<td class='columnresult'>Population</td>") == 1)
	            	{
	            		index2 = line.indexOf("</b>");
	            		population = line.substring(index2+ 2).trim();
	            	}
	            	else if(line.indexOf("<td class='columnresult'>House Value</td>")!= 0)
	            	{
	            		index3 = line.indexOf("<b>");
	            		houseval = line.substring(index3 + 1).trim();
	            	}
	            	
	            }
	           
	            System.out.println("City and State: " + citystate);
	            System.out.println("Current Population: " + population);
	            System.out.println("Average House Value: " + houseval);
	            System.out.println();
	            ins.close();
	            
	       }else{
	    	   System.out.println("Invalid choice!");
	       }
	   } // end while
	         
	   in.close();
   }
}
