package com.cg.onlineshop.posttest;


import java.util.HashMap;

import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;

import groovyjarjarantlr4.v4.runtime.atn.SemanticContext.AND;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;


public class OnlineshopTest {




	@BeforeClass
	public static void setUpTestEnv() {

		RestAssured.baseURI="http://localhost:4444/onlineshop";

	}


	@Test
	public void testaddProductDetails() {
		RestAssuredConfig newConfig=RestAssuredConfig.newConfig();
		newConfig=newConfig.encoderConfig(newConfig.getEncoderConfig().defaultContentCharset("UTF-8"));
		newConfig=newConfig.encoderConfig(newConfig.getEncoderConfig().defaultCharsetForContentType("UTF-8",ContentType.URLENC));


		RestAssured.config=newConfig;

		HashMap<String, String>	formParams=new HashMap<String, String>();
		formParams.put("price","15000");
		formParams.put("starRating","5");
		formParams.put("description","15Good Product To Have it");	
		formParams.put("productName","Whey protein");	

		RestAssured.given()
		.formParams(formParams)
		.post("/addProduct")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body(CoreMatchers.containsString("Product details successfully added productId :- 1")).log().all();
		


	}









}
