package com.herokuapp.rest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class put extends pojo{
	
	
	
	
	@Test
	public void putmethod() {
		
		Response response=createBooking();
		response.print();
		
		
		 System.out.println("deva");
		
		
	}


	}
	
	
	
	

}
