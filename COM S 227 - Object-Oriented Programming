/*
 * The purpose of this assignment is to give you some practice with
 *  the process of implementing a class from a specification and
 *  testing whether your implementation is correct.
 *  For this assignment you will implement one class, called Cab, that
 *  is a simple model of taxicab (or car-for-hire such as Uber). 
 *  
 *  @author Kenan Dolic
 *  
 */

package hw1;
public class Cab 
{
	// Instance Variables

	private double chargedFare; // assigned into the givenBaseFare parameter
	private double milesRate; // assigned into the givenPerMileRate
	private double totalMiles; // total miles from the cab ride
	private double totalFareMoney; // total cash collected from cab
	private double currentRate; // current per-mile rate
	private double meter; // meter shown for cab ride
	private boolean passenger; // if there is a passenger or not
	
/*
 * Constructs a cab that uses parameters of given base fare and given per mile rate
 * variables assigned for the parameters
 * 
 * @param givenBaseFare, givenPerMileRate - base fare charged for any ride, per-mile rate
 *  
*/
	public Cab(double givenBaseFare, double givenPerMileRate)
	{
		chargedFare = givenBaseFare;
		milesRate = givenPerMileRate;
		totalMiles = 0;
		passenger = false;
	}
	
/*
 * Starts a new ride, setting the meter to the base fare and setting the current rate to the per mile charge.
 * 
 */
	public void pickUp()
	{
		meter = chargedFare;
		currentRate = milesRate;
		passenger = true;
	}
	
/*
 * Ends the current ride, updating the total cash collected and resetting the meter and current rate to zero.
 * 
 */
	public void dropOff() 
	{
		currentRate = 0;
		totalFareMoney += meter;
		meter = 0;
		passenger = false;
		
	}
	
/*
 * Drives the cab the given number of miles, updating the total miles and possibly updating the meter.
 * 
 * @param miles - number of miles to drive
 * 
 */
	public void drive(double miles)
	{
		totalMiles += miles;
		meter += miles * currentRate;
	}
	
/*
 * Returns the total miles driven by this cab during its lifetime.
 * 
 * @return total miles driven
 */
	public double getTotalMiles()
	{
		return totalMiles;
	}
	
/*
 * Returns the total cash collected by this cab during its lifetime.
 * 
 * @return total cash collected
 */
	public double getTotalCash()
	{
		return totalFareMoney;
	}
	
/*
 * Returns the amount of money shown on the meter for the current ride
 * 
 * @return amount of money shown on the meter
 */
	public double getMeter()
	{
	
		return meter;
	}
	
/*
 * Returns the current per-mile rate, which is always either zero or the per-mile rate given in the constructor.
 * 
 * @return current per-mile rate
 * 
 */
	public double getCurrentRate()
	{
		return currentRate;
	}
	
/*
 * Determines whether the cab currently has a passenger (i.e., the current rate is nonzero).
 * 
 * @return true if cab has a passenger, false otherwise
 */
	public boolean hasPassenger()
	{
		return passenger;
	}
	
/*
 * Returns the average income earned by this cab per mile driven.
 * 
 * @return average income per mile
 */
	public double getAverageIncomePerMile()
	{
		double avgIncomePerMile = totalFareMoney/totalMiles;
		return avgIncomePerMile;
	}
}
