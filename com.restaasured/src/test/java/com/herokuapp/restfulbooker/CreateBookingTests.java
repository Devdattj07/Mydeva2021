package com.herokuapp.restfulbooker;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokarestTest.BaseTest;

import io.restassured.response.Response;

public class CreateBookingTests extends BaseTest{
	
	
	@Test
	public void createBookingTest()
	{
		Response response = createBooking();
	     
		response.print();
	// verify response 200
			Assert.assertEquals(response.getStatusCode(), 200, "statuscode should 200 but it not");

			
			//verify all field
			SoftAssert softassert=new SoftAssert();
			
			String actualfirstname=response.jsonPath().getString("booking.firstname");
			softassert.assertEquals(actualfirstname, "deva");
			
			String actuallastname=response.jsonPath().getString("booking.lastname");
			softassert.assertEquals(actuallastname, "jadhav");
			
			int actualtotalprice=response.jsonPath().getInt("booking.totalprice");
			softassert.assertEquals(actualtotalprice, 255);
			
			boolean actualdepositpaid=response.jsonPath().getBoolean("booking.depositpaid");
			softassert.assertFalse(actualdepositpaid, "false");
			 
			String actualcheckin=response.jsonPath().getString("booking.bookingdates.checkin");
			softassert.assertEquals(actualcheckin, "2021-08-14");
			
			String actualcheckout=response.jsonPath().getString("booking.bookingdates.checkout");
			softassert.assertEquals(actualcheckout, "2021-09-07");
			
			String actualadditionalneeds=response.jsonPath().getString("booking.additionalneeds");
			softassert.assertEquals(actualadditionalneeds, "Breakfast");
			softassert.assertAll();
	

}


}