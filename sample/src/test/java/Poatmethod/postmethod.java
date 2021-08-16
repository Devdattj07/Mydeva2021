package Poatmethod;
import org.testng.Assert;
import org.testng.annotations.Test;        // 
import static io.restassured.RestAssured.*;//
import static org.hamcrest.Matcher.*;  
import org.testng.annotations.Test;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 
import Testclass.postutils;
import io.restassured.RestAssured;
import org.testng.Assert;
public class postmethod {

	
	public static HashMap map=new HashMap();
	
	
	@BeforeClass
	public void post() {
		
		
		map.put("name",postutils.getname());
		
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/unknown";
		
	}
	
	@Test
	public void testpost() {
		
		given().contentType("application/json")
		.body(map)

		.when().post()
		.then().statusCode(201);
		
	}
	
	
	
	
	
	
}
