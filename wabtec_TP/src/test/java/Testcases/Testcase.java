package Testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;



public class Testcase {

	
     @Test(priority=1)
	public void getmethod1() {
		
		Response response=get("http://reqres.in/api/users?page=2");
		
		System.out.println(	"Status code :"+response.getStatusCode());
		System.out.println(	response.getBody().asString());
		System.out.println(	response.asString());
		
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
			
	}
     
 	@Test(priority=2)
 	public void getmethod2() {
 		given()
 		.get("http://reqres.in/api/users?page=1")
 		.then()
 		       .statusCode(200).log().all();
 				
 	}
 	   
 	@Test(priority=3)
 	public void getmethod3() {
 		given()
 		.get("http://reqres.in/api/users?page=2")
 		.then()
 		       .statusCode(200).log().all();
 	
 	
 	}
 	@Test(priority=4)
 	
 	public void getmethod4() {
 		
 		given().get("http://reqres.in/api/users?page=2")
 		
 		.then().statusCode(200)
 		.body("data.id[0]", equalTo(7))
 		.body("data.first_name[0]", equalTo("Michael"));
 		
 	}
 	
 	////////////////////////////////////////////////////////////////////////
 	
 	// POST METHOD
 	
 	@Test(priority=5)
 	public void getmethod5() {
 		given()
 		
 		.when().get("http://reqres.in/api/users?page=2")
 		.then().assertThat()
 		.statusCode(200).
 		and()
 		.body("data.first_name",hasSize(6));
 		//.and().
	
 	}
 	
 
 
}
