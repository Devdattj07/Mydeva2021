package pathparameter;

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

import static org.hamcrest.Matchers.*;//    given la underline yet hoti ya mul nahi yet
public class Pathparameter {
	
	
	String id="2";
	
	@BeforeClass
	public void pathpara()
	{
		
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="api/users";
		
	}
	 
	@Test
	public void pathparameters() {
	
		//ValidatableResponse res=
		given().pathParam("id", id)
		.when().
		get("{id}")
		.then().statusCode(200);
		
	//	System.out.println(res.body().prettyPrint());
		
	}
	
	
	
	

}
/*import org.testng.Assert;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;
	*/
	
