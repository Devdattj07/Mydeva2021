package com.herokuapp.restfulbooker;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingTests {

	@Test
	public void getBookingIdTest() {

		// Get response with booking
		Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/5");
		response.print();

		// verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "statuscode should 200 but it not");

		
		//verify all field
		SoftAssert softassert=new SoftAssert();
		
		String actualfirstname=response.jsonPath().getString("firstname");
		softassert.assertEquals(actualfirstname, "Mary");
		
		String actuallastname=response.jsonPath().getString("lastname");
		softassert.assertEquals(actuallastname, "Jackson");
		
		int actualtotalprice=response.jsonPath().getInt("totalprice");
		softassert.assertEquals(actualtotalprice, 979);
		
		boolean actualdepositpaid=response.jsonPath().getBoolean("depositpaid");
		softassert.assertTrue(actualdepositpaid, "true");
		 
		String actualcheckin=response.jsonPath().getString("bookingdates.checkin");
		softassert.assertEquals(actualcheckin, "2015-10-05");
		
		String actualcheckout=response.jsonPath().getString("bookingdates.checkout");
		softassert.assertEquals(actualcheckout, "2019-01-10");
		
		String actualadditionalneeds=response.jsonPath().getString("additionalneeds");
		softassert.assertEquals(actualadditionalneeds, "Breakfast");
		softassert.assertAll();
		
	  //"firstname":"Susan",
//		"lastname":"Wilson",
//		"totalprice":255,
//		"depositpaid":false,
//		"bookingdates":{"checkin":"2021-02-24",
//			           "checkout":"2021-05-07"},
//		"additionalneeds":"Breakfast"}
	

		
		

	}

}
