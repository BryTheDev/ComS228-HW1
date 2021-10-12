package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Bryan Pope
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {
	
	/**
	 * This specifies the number of months you want the simulation to run
	 */
	private static int NUM_MONTHS = 12;
	/**
	 * This states how much profit a casual user earns the ISP
	 */
	private static int CASUAL_PROFIT = 1;
	
	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		int i,j;
		int[] census = new int[5];
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		for(i=0;i<tOld.getLength();i++) {
			for(j=0;j<tOld.getWidth();j++) {
				tOld.grid[i][j].census(census);
				
				//Any cell that (1) is not a Reseller or Outage and (2) and has (Number of Empty +Number of Outage neighbors less than or equal to 1)converts to Reseller
				if((tOld.grid[i][j].who() != State.RESELLER && tOld.grid[i][j].who() != State.OUTAGE) && census[3]+census[1] < 2) {
					Reseller r = new Reseller(tNew,tOld.grid[i][j].row,tOld.grid[i][j].col);
					tNew.grid[i][j] = r;
					continue;
				}
				//Type-specificUpdates
				tNew.grid[i][j] = tOld.grid[i][j].next(tNew);
				
				//If none of the above rules apply, any cell with 5 or more casual neighbors becomes a Streamer.
				if(tOld.grid[i][j].who() == tNew.grid[i][j].who() && census[2] >= 5) {
					Streamer s = new Streamer(tNew,tOld.grid[i][j].row,tOld.grid[i][j].col);
					tNew.grid[i][j] = s;
				}
			}
		}
		return tNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
		int i,j;
		int profit = 0;
		for(i=0;i<town.getLength();i++) {
			for(j=0;j<town.getWidth();j++) {
				if(town.grid[i][j].who().equals(State.CASUAL)) {
					profit += CASUAL_PROFIT;
				}
			}
		}
		return profit;
	}
	

	/**
	 *  Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should print the profit percentage
	 *  with two digits after the decimal point:  Example if profit is 35.5600004, your output
	 *  should be:
	 *
	 *	35.56%
	 *  
	 * Note that this method does not throw any exception, so you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String []args) {
		Town t = null;
		float actualProfit = 0;
		float potentialProfit = 0;
		Scanner scnr = new Scanner(System.in);
		//This loop keeps going until a user puts in a correct input for the grid type, as well as the file
		while(true) {
		System.out.println("How to populate grid (type 1 or 2): 1: from a file. 2: randomly with seed");
		int temp = scnr.nextInt();
		if(temp == 1) {
			System.out.println("Please enter file path:");
			String s = scnr.next();
			try {
				t = new Town(s);
				break;
			}
			catch(FileNotFoundException exception){
				System.out.println("File Not Found");
				continue;
			}
		}
		else if(temp == 2) {
			System.out.println("Provide rows, cols and seed integer separated by spaces:");
			t = new Town(scnr.nextInt(),scnr.nextInt());
			t.randomInit(scnr.nextInt());
			break;
		}
		}
		for(int i = 0; i < NUM_MONTHS;i++) {
			actualProfit += getProfit(t);
			potentialProfit += CASUAL_PROFIT * t.getLength() * t.getWidth();
			System.out.println(t.toString());
			t = updatePlain(t);
			
		}
		scnr.close();
		float result = actualProfit/potentialProfit*100;
		String s = String.format("%.02f", result);
		System.out.println(s + "%");
	}
}
