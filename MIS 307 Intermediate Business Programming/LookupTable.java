import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Code for HW6
 * @ Kenan Dolic 
 */
/**
   A table for lookups and reverse lookups
*/
public class LookupTable
{ 
   private ArrayList<Item> Zip_key;
   private ArrayList<Item> CityState_key;

   /**
      Constructs a LookupTable object.
   */
   public LookupTable()
   {
	   // Two array lists are created.
	   Zip_key = new ArrayList<Item>();       // Zip is the key in this array list
	   CityState_key = new ArrayList<Item>(); // City&State is the key in this array list
   }
   
   /**
      Reads key/value pairs.
      @param in the scanner for reading the input
   */
   public void read(Scanner in) 
   { 
      while (in.hasNextLine())
      {
    	  String zip = in.nextLine();
    	  String city = in.nextLine();
    	  Zip_key.add(new Item(zip,city));
      }
	  
	 in.close();
   }
   
   /**
      Looks up an item in the table.
      @param zip: the zip code to find
      @return the city and state names for the given key, or null if no such item was found.
   */
   public String lookup_by_zip(String zip)
   { 
      String cityAndState = "";
      
      for(Item key : Zip_key)
      {
    	  if(key.getKey().equalsIgnoreCase(zip))
    	  {
    		  cityAndState = key.getValue();
    	  }
      }
	  
      return cityAndState;
	  
   }

   /**
      Looks up an item in the table.
      @param city: city name to find
      @param state: state name to find 
      @return the zip code with the given city and state names, or null if no such item was found.
   */
   public String lookup_by_city_state(String city, String state)
   { 
	  String zipCode = "";
	  
	  for(Item key : Zip_key)
	  {
		  if(key.getValue().equalsIgnoreCase(city + " " + state))
		  {
			  zipCode = key.getKey();
		  }
	  }
	  
	  return zipCode;

   }
}
