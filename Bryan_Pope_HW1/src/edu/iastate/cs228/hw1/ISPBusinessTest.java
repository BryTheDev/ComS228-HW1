package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;
import org.junit.*;
public class ISPBusinessTest {
	@Test
	public void testUpdatePlane() {
		try {
			Town a = new Town("ISP4x4.txt");
			Town b = new Town("ISP4x4One.txt");
			a = ISPBusiness.updatePlain(a);
			Assert.assertEquals(b.toString(), a.toString());
		}
		catch(FileNotFoundException exception){
			System.out.println("File Not Found");
		}
	}
	@Test
	public void testProfit() {
		try {
			Town a = new Town("ISP4x4.txt");
			Assert.assertEquals(1, ISPBusiness.getProfit(a));
			a = ISPBusiness.updatePlain(a);
			Assert.assertEquals(4, ISPBusiness.getProfit(a));
		}
		catch(FileNotFoundException exception){
			System.out.println("File Not Found");
		}
	}
}
