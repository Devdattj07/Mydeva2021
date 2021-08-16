package com.herokuapp.rest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.JSONObject;
public class GetBookingIdtest2postonedata {

	
	@Test
	public void CreateBookingTestpost()
	{
		//post following data
		
		//{"firstname":"Sally",
//		"lastname":"Smith",
//		"totalprice":853,
//		"depositpaid":false,
//		"bookingdates":{"checkin":"2019-07-22",
//		               "checkout":"2019-08-08"}}
		
		
//Create JSON body
		JSONObject body=new JSONObject();
		body.put("firstname", "Sally");
		body.put("lastname", "Smith");
		body.put("totalprice", 853);
		body.put("depositpaid", false);
	
		JSONObject bookingdates=new JSONObject();
		bookingdates.put("checkin", "2019-07-22");
		bookingdates.put("checkout", "2019-08-08");
		
		body.put("bookingdates", bookingdates);
		body.put("additionalneeds", "Breakfast");
		
		
		
	
	//{"firstname":"Sally",
//	"lastname":"Smith",
//	"totalprice":853,
//	"depositpaid":false,
//	"bookingdates":{"checkin":"2019-07-22",
//	               "checkout":"2019-08-08"}}
	
	
		//Get response
		
		Response response =RestAssured.given().contentType(ContentType.JSON)
				.body(body.toString())
				
				.post("https://restful-booker.herokuapp.com/booking");
		
	         	response.print();

	        	//verify respoonse 200
	        	Assert.assertEquals(response.getStatusCode(),200,"status code should be 200 but it not");
	        	
	        	
	        	//verify all fields
	        	
	        	SoftAssert softAssert=new SoftAssert();
	        	
	        	String actualFirstname=response.jsonPath().getString("booking.firstname");
	        	softAssert.assertEquals(actualFirstname, "Sally");

	        	String actualLastname=response.jsonPath().getString("booking.lastname");
	        	softAssert.assertEquals(actualLastname, "Smith");
	        	

	        	int TotalPrice=response.jsonPath().getInt("booking.totalprice");
	        	softAssert.assertEquals(TotalPrice, 853);
	        	
	        	boolean Depositpaid=response.jsonPath().getBoolean("booking.depositpaid");
	        	softAssert.assertFalse(Depositpaid,"depositpaid in response is not expected");
	        	
	        	String Actualcheckin=response.jsonPath().getString("booking.bookingdates.checkin");
	        	softAssert.assertEquals(Actualcheckin, "2019-07-22","checkin in response is not expected");
	        	
	        	String Actualcheckout=response.jsonPath().getString("booking.bookingdates.checkout");
	        	softAssert.assertEquals(Actualcheckout, "2020-09-26","checkout in response is not expected");
	        	
//	        	String Actualadditionalneeds=response.jsonPath().getString("booking.additionalneeds");
//	        	softAssert.assertEquals(Actualadditionalneeds, "Breakfast");


	        	softAssert.assertAll();
	        	
	        	
	        	
	        	
	        	
	
	
	
}
}