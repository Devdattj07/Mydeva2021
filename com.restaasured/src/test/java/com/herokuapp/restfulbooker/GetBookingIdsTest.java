package com.herokuapp.restfulbooker;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingIdsTest {

	@Test
	public void getBookingIdWithoutFilterTest() {

		// Get response with booking Ids
		Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
		response.print();

		// verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "statuscode should 200 but it not");

		// verify at least 1 booking id in response;

		List<Integer> bookingIds = response.jsonPath().getList("bookingid");

		Assert.assertFalse(bookingIds.isEmpty(), "LIst of booking is empty,but it not");

	}

}
