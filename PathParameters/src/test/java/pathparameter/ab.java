package pathparameter;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



import io.restassured.response.Response.*;
import io.restassured.response.ValidatableResponse;

import static  io.restassured.RestAssured.*; 
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.given;


import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;
import io.restassured.response.ValidatableResponse;

public class ab{
	
	
	String url="https://api.aylien.com/api/v1/language";
	ValidatableResponse res;
	
	@Test
	public void ResponseTimeValidation() {
		
		
		given().param("text","Hello rest assured")
		.post(url)
		.then()
		.log()
		.all();
		
		
		
	}
	
	
	
	
 
} 