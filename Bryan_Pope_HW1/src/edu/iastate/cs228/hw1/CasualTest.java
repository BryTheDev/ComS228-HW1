package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;
import org.junit.*;

public class CasualTest {
	private int row = 3;
	private int col = 3;
	@Test
	public void testState() {
		try {
		Town a = new Town("ISP4x4.txt");
		Casual c = new Casual(a,row,col);
		Assert.assertEquals(State.CASUAL,c.who());
		}
		catch(FileNotFoundException exception){
			System.out.println("File Not Found");
		}
	}
	
	@Test
	public void testRow() {
		try {
		Town a = new Town("ISP4x4.txt");
		Casual c = new Casual(a,a.getLength()-1,a.getWidth()-1);
		Assert.assertEquals(row,c.row);
		}
		catch(FileNotFoundException exception){
			System.out.println("File Not Found");
		}
	}
	
	@Test
	public void testCol() {
		try {
		Town a = new Town("ISP4x4.txt");
		Casual c = new Casual(a,a.getLength()-1,a.getWidth()-1);
		Assert.assertEquals(col,c.col);
		}
		catch(FileNotFoundException exception){
			System.out.println("File Not Found");
		}
	}
	@Test
	public void testTown() {
		try {
		Town a = new Town("ISP4x4.txt");
		Casual c = new Casual(a,a.getLength(),a.getWidth());
		Assert.assertEquals(a,c.plain);
		}
		catch(FileNotFoundException exception){
			System.out.println("File Not Found");
		}
	}
	@Test
	public void testResellerInNeighborhood() {
		try {
		Town a = new Town("ISP4x4.txt");
		Assert.assertEquals(State.CASUAL, a.grid[1][2].who());
		ISPBusiness n = new ISPBusiness();
		a = ISPBusiness.updatePlain(a);
		Assert.assertEquals(State.OUTAGE, a.grid[1][2].who());
		}
		catch(FileNotFoundException exception){
			System.out.println("File Not Found");
		}
	}
	
	@Test
	public void testEmptyToCasual() {
		try {
		Town a = new Town("ISP4x4.txt");
		Assert.assertEquals(State.EMPTY, a.grid[1][0].who());
		ISPBusiness n = new ISPBusiness();
		a = ISPBusiness.updatePlain(a);
		Assert.assertEquals(State.CASUAL, a.grid[1][0].who());
		}
		catch(FileNotFoundException exception){
			System.out.println("File Not Found");
		}
	}

}
