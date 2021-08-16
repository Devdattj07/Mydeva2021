package com.herokarestTest;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseTest {
	protected Response createBooking() {
		//create JSONbody                 post method send data  and verify that data come from response(response cha data verify kela)
		
		JSONObject body=new JSONObject();
		
		body.put("firstname", "deva");
		body.put("lastname", "jadhav");
		body.put("totalprice", 255);
		body.put("depositpaid", false);
		
		JSONObject bookingdates=new JSONObject();
		
		bookingdates.put("checkin", "2021-08-14");
		bookingdates.put("checkout", "2021-09-07");
		
		body.put("bookingdates", bookingdates);
		body.put("additionalneeds", "Breakfast");
		
		
//		        "firstname":"Susan"
//		     	,"lastname":"Wilson"
//				,"totalprice":255
//				,"depositpaid":false,
//				"bookingdates":{"checkin":"2021-02-24",
//			                    "checkout":"2021-05-07"},
//				"additionalneeds":"Breakfast"}
		
		//Get response   // post
		Response response=RestAssured.given().contentType(ContentType.JSON)
				.body(body.toString()).post("https://restful-booker.herokuapp.com/booking");
		return response;
	}

}
