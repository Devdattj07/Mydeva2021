package com.herokuapp.restfulbooker;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokarestTest.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateBookingTests extends BaseTest{
	
	
	@Test
	public void UpdatebookingTest()
	{                                               //  put method  &  autherisation username and password
		
		//create booking
		
		Response responsecreate = createBooking();  
		responsecreate.print();
		//get bookingid of booking
		int bookingid=responsecreate.jsonPath().getInt("bookingid");
		
		//update 
		//
		
		JSONObject body=new JSONObject();
		body.put("firstname", "Devaaa");
		body.put("lastname", "Dadhavjadhav");
		body.put("totalprice", 125);
		body.put("depositpaid", false);

  
		JSONObject bookingdates=new JSONObject();
		bookingdates.put("checkin", "2021-08-16");
		bookingdates.put("checkout", "2021-09-17");
		
		body.put("bookingdates", bookingdates);
		body.put("additionalneeds", "Breakfast");
		
		// update booking     //username and password add

		Response responseUpdate=RestAssured.given().auth().preemptive().basic("admin", "password123").contentType(ContentType.JSON)
				.body(body.toString()).put("https://restful-booker.herokuapp.com/booking/"+ bookingid);
		
		responseUpdate.print();
		responseUpdate.getStatusCode();
		
		
		
	// verify response 200
		Assert.assertEquals(responseUpdate.getStatusCode(), 200);
//			//verify all field
//			SoftAssert softassert=new SoftAssert();
//			
//			String actualfirstname=response.jsonPath().getString("firstname");
//			softassert.assertEquals(actualfirstname, "deva");
//			
//			String actuallastname=response.jsonPath().getString("lastname");
//			softassert.assertEquals(actuallastname, "jadhav");
//			
//			int actualtotalprice=response.jsonPath().getInt("totalprice");
//			softassert.assertEquals(actualtotalprice, 255);
//			
//			boolean actualdepositpaid=response.jsonPath().getBoolean("depositpaid");
//			softassert.assertFalse(actualdepositpaid, "false");
//			 
//			String actualcheckin=response.jsonPath().getString("bookingdates.checkin");
//			softassert.assertEquals(actualcheckin, "2021-08-14");
//			
//			String actualcheckout=response.jsonPath().getString("bookingdates.checkout");
//			softassert.assertEquals(actualcheckout, "2021-09-07");
//			
//			String actualadditionalneeds=response.jsonPath().getString("additionalneeds");
//			softassert.assertEquals(actualadditionalneeds, "c");
//			softassert.assertAll();
//	

}


}