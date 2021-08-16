package com.herokuapp.rest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingIdtest {

	
	@Test
	public void getBookingIdFilterTest()
	{
	
	//Get response with booking ids
	Response response=RestAssured.get("https://restful-booker.herokuapp.com/booking");
	response.print();
	
	//verify respoonse 200
	Assert.assertEquals(response.getStatusCode(), 200,"status code should be 200 but it not");
	
	//verify at least 1 booking id
	
	List <Integer>bookingIds=response.jsonPath().getList("bookingid");
	
	Assert.assertFalse(bookingIds.isEmpty(),"List of bookingid is empty but it should be");
	
	
	
	
	
	
}
}