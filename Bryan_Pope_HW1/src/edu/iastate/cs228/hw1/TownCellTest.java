package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class TownCellTest {
	private int row = 3;
	private int col = 3;
	@Test
	public void testCensusReseller() {
		try {
			int[] cen = new int[5];
			Town a = new Town("ISP4x4.txt");
			a.grid[0][0].census(cen);
			Assert.assertEquals(1,cen[0]);
			}
			catch(FileNotFoundException exception){
				System.out.println("File Not Found");
			}
	}
	
	@Test
	public void testCensusEmpty() {
		try {
			int[] cen = new int[5];
			Town a = new Town("ISP4x4.txt");
			a.grid[0][0].census(cen);
			Assert.assertEquals(2,cen[1]);
			}
			catch(FileNotFoundException exception){
				System.out.println("File Not Found");
			}
	}
	@Test
	public void testCensusCasual() {
		try {
			int[] cen = new int[5];
			Town a = new Town("ISP4x4.txt");
			a.grid[0][0].census(cen);
			Assert.assertEquals(0,cen[2]);
			}
			catch(FileNotFoundException exception){
				System.out.println("File Not Found");
			}
	}
	
	@Test
	public void testCensusOutage() {
		try {
			int[] cen = new int[5];
			Town a = new Town("ISP4x4.txt");
			a.grid[0][0].census(cen);
			Assert.assertEquals(0,cen[3]);
			}
			catch(FileNotFoundException exception){
				System.out.println("File Not Found");
			}
	}
	
	@Test
	public void testCensusStreamer() {
		try {
			int[] cen = new int[5];
			Town a = new Town("ISP4x4.txt");
			a.grid[0][0].census(cen);
			Assert.assertEquals(0,cen[4]);
			}
			catch(FileNotFoundException exception){
				System.out.println("File Not Found");
			}
	}
	
}

