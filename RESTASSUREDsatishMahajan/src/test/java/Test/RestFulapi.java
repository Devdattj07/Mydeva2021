package Test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RestFulapi {
	
	
	@BeforeClass
	public static void beforemethod1()
	{
		System.out.println("@BeforeClass setUpTestEnv()");
	}
	
	@Before
	public void after()
	{
		System.out.println("@Before setUpTestMockDataEnv");
	}
	
	@Test
	public void testmethod1()
	{
		System.out.println("test1");
	}
	
	@Test
	public void testmethod2()
	{
		System.out.println("test2");
	}
	@After
	public void aftermethod()
	{
		System.out.println("2after TearDownMockdataEnv()");
	}
	@AfterClass
	public static void tearDownTestEnv()
	{
		System.out.println("@afterClasstearDownTestEnv()");
		
	}

}
