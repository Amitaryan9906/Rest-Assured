package Demo;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

public class UnitTestJ {
     
	@Before
	public void bt() {
		String Expected="Sunil";
     String Actual ="Sunil";
     
     Assert.assertEquals(Expected, Actual);
     System.out.println("This is before test");
	}
	
	@Test
	public void tc1() {
    System.out.println("I an training on API Testing");
	}
	
	public void at() {
    System.out.println("I am very good");
	}
}
