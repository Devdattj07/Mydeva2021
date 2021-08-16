package com.herokuapp.restfulbooker;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.herokarestTest.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class partialBookingTest extends BaseTest{
	
	//                  patchMethod
	@Test
	public void newcreateBookingTest()
	{        Response newresponseCreate=createBooking();
	      //   newresponseCreate.print();
		
		int bookingid=newresponseCreate.jsonPath().getInt("bookingid");
		
		JSONObject body=new JSONObject();
		body.put("firstname", "dd");
		
		JSONObject dates=new JSONObject();
		dates.put("checkin","2021-05-14");
		dates.put("checkout", "2021-09-07");
		
		body.put("dates", dates);
		
	
	Response responsen=RestAssured.given().auth()
			.preemptive().basic("admin", "password123")
			.contentType(ContentType.JSON)
			.body(body.toString())
			.patch("https://restful-booker.herokuapp.com/booking/" +bookingid );
	responsen.prettyPrint();
		
		
		
		
		
		
		
		
		
		
		
}}