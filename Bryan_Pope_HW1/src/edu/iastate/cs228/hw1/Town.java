package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;


/**
 *  @author Bryan Pope
 *
 */
public class Town {
	
	Random rand = new Random();
	private int length, width;  //Row and col (first and second indices)
	public TownCell[][] grid;
	
	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		this.length = length;
		this.width = width;
		grid = new TownCell[this.getLength()][this.getWidth()];
	}
	
	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {
		int i,j;
		
		Scanner scnr = new Scanner(new FileReader(inputFileName));
		this.length = scnr.nextInt();
		this.width = scnr.nextInt();
		grid = new TownCell[this.getLength()][this.getWidth()];
		for(i=0;i<this.length;i++) {
			for(j=0;j<this.width;j++) {
				String next = scnr.next();
				if(next.equals("C")) {
					Casual c = new Casual(this,i,j);
					grid[i][j] = c;
				}
				else if(next.equals("E")) {
					Empty e = new Empty(this,i,j);
					grid[i][j] = e;
				}
				else if(next.equals("O")) {
					Outage o = new Outage(this,i,j);
					grid[i][j] = o;
				}
				else if(next.equals("R")) {
					Reseller r = new Reseller(this,i,j);
					grid[i][j] = r;
				}
				else if(next.equals("S")) {
					Streamer s = new Streamer(this,i,j);
					grid[i][j] = s;
				}
			}
		}
	
		
		scnr.close();
		
		}
	
	/**
	 * Returns width of the grid.
	 * @return
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Returns length of the grid.
	 * @return
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		int i, j;
		for(i=0;i<this.length;i++) {
			for(j=0;j<this.width;j++) {
				int next = rand.nextInt(5);
				
				if(next == 0) {
					Reseller r = new Reseller(this,i,j);
					grid[i][j] = r;
				}
				else if(next == 1) {
					Empty e = new Empty(this,i,j);
					grid[i][j] = e;
				}
				if(next == 2) {
					Casual c = new Casual(this,i,j);
					grid[i][j] = c;
				}
				else if(next == 3) {
					Outage o = new Outage(this,i,j);
					grid[i][j] = o;
				}
				else if(next == 4) {
					Streamer s = new Streamer(this,i,j);
					grid[i][j] = s;
				}
			}
		}
	}
	
	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between 
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";
		int i,j;
		for(i=0; i < this.length; i++) {
			s += "\n";
			for(j=0;j<this.getWidth(); j++) {
				
				if(grid[i][j].who().equals(State.RESELLER)) {
					s += "R";
				}
				
				else if(grid[i][j].who().equals(State.EMPTY)) {
					s += "E";
				}
				
				else if(grid[i][j].who().equals(State.CASUAL)) {
					s += "C";
				}
				
				else if(grid[i][j].who().equals(State.OUTAGE)) {
					s += "O";
				}
				
				else if(grid[i][j].who().equals(State.STREAMER)) {
					s += "S";
				}
				
				if(j < this.length - 1) {
					s += " ";
				}
			}
		}
		return s;
	}
}
