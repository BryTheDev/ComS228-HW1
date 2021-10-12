package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;
import org.junit.*;
public class TownTest {
	private String file = "./Bryan_Pope_HW1/ISP4x4.txt";
	
	@Test
	public void testFileLengthInput() {
		try {
		Town A = new Town("ISP4x4.txt");
		Assert.assertEquals(A.getLength(), 4);
		}
		catch(FileNotFoundException exception){
			System.out.println("File Not Found");
		}
	}
	@Test
	public void testFileWidthInput() {
		try {
		Town A = new Town("ISP4x4.txt");
		Assert.assertEquals(A.getWidth(), 4);
		}
		catch(FileNotFoundException exception){
			System.out.println("File Not Found");
		}
	}
	@Test
	public void testState() {
		try {
		Town A = new Town("ISP4x4.txt");
		Assert.assertEquals(A.grid[0][0].who(),State.OUTAGE);
		Assert.assertEquals(A.grid[3][3].who(),State.RESELLER);
		}
		catch(FileNotFoundException exception){
			System.out.println("File Not Found");
		}
	}
	@Test
	public void testToString() {
	try {
		Town A = new Town("ISP4x4.txt");
		System.out.print(A.toString());
		}
		catch(FileNotFoundException exception){
			System.out.println("File Not Found");
		}
	}
}
