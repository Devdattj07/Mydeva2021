package com.herokuapp.rest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingIdtest3getverifydata {

	
	@Test
	public void getBookingIdFilterTest()
	{
//      {"firstname":"Sally",
//		"lastname":"Smith",
//		"totalprice":853,
//		"depositpaid":false,
//		"bookingdates":{"checkin":"2019-07-22",
//		               "checkout":"2019-08-08"}}
		
	
	//Get response with booking ids
	Response response=RestAssured.get("https://restful-booker.herokuapp.com/booking/5");
	response.print();
	
	//verify respoonse 200
	Assert.assertEquals(response.getStatusCode(), 200,"status code should be 200 but it not");
	
	
	//verify all fields
	
	SoftAssert softAssert=new SoftAssert();
	
	String actualFirstname=response.jsonPath().getString("firstname");
	softAssert.assertEquals(actualFirstname, "Sally");

	String actualLastname=response.jsonPath().getString("lastname");
	softAssert.assertEquals(actualLastname, "Smith");
	

	int TotalPrice=response.jsonPath().getInt("totalprice");
	softAssert.assertEquals(TotalPrice, 461);
	
	boolean Depositpaid=response.jsonPath().getBoolean("depositpaid");
	softAssert.assertTrue(Depositpaid,"depositpaid in response is not expected");
	
	String Actualcheckin=response.jsonPath().getString("bookingdates.checkin");
	softAssert.assertEquals(Actualcheckin, "2020-07-22","checkin in response is not expected");
	
	String Actualcheckout=response.jsonPath().getString("bookingdates.checkout");
	softAssert.assertEquals(Actualcheckout, "2020-09-26","checkout in response is not expected");
	
//	String Actualadditionalneeds=response.jsonPath().getString("booking.additionalneeds");
//	softAssert.assertEquals(Actualadditionalneeds, "Breakfast");


	softAssert.assertAll();
	
	
	
	
	
	
	
	
}
}