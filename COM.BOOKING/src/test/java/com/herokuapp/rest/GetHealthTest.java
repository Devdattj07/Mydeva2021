package com.herokuapp.rest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetHealthTest {
	

	
	@Test
	public void healthGetMethod() {
		
		given()
		.when()
		      .get("https://restful-booker.herokuapp.com/ping")
		.then()
		       .assertThat().statusCode(201);
	
	}

}
