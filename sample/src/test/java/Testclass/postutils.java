package Testclass;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class postutils {

//	@Test
//	public static void getmethod() {
//		
//	Response response=RestAssured.get("https://reqres.in/api/unknown");
//		System.out.println(response.asString());
//		System.out.println(response.getBody().asString());
//		
//		
//	}

	
	public static String getname() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
			return ("cerulean"+generatedString);	
				
	}
	
	
	
	
	
	
	
	
	
	
}
