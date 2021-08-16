package com.herokuapp.restfulbooker;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokarestTest.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class deleteBooking extends BaseTest{
	
	//                  patchMethod
	@Test
	public void newcreateBookingTest()
	{        Response newresponseCreate=createBooking();
	      //   newresponseCreate.print();
		
		int bookingid=newresponseCreate.jsonPath().getInt("bookingid");
		
		// delete 
	Response responsendelete=RestAssured.given().auth()
			.preemptive().basic("admin", "password123")
		    .delete("https://restful-booker.herokuapp.com/booking/" +bookingid );
	
	responsendelete.getStatusCode();
	responsendelete.prettyPrint();
		
//	Assert.assertEquals(responsendelete, 200);
//	
//	Response responseget=RestAssured.get("https://restful-booker.herokuapp.com/booking/" +bookingid );
//	responseget.print();
//	
//	
//	Assert.assertEquals(responsendelete.getBody().asString(), "not found,body should be not found");
//		
		
		
		
		
		
		
		
		
}}