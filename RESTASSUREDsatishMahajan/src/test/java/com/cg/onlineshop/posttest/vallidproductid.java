package com.cg.onlineshop.posttest;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;


public class vallidproductid {




	@BeforeClass
	public static void setUpTestEnv() {

		RestAssured.baseURI="http://localhost:4444/onlineshop";

	}

	@Test
	public void testaddProductDetails() {
				
//1>way
		
//		Response response=RestAssured.given().when().queryParam("productId",1).get("/productDetails");
//		System.out.println(response.jsonPath().prettify());
////		

//2> way
//		RestAssured.given()
//		.when()
//		.queryParam("productId", 1)
//        .get("/productDetails")
//        .then()
//        .assertThat()
//        .statusCode(200)
//        .body("productId", CoreMatchers.equalTo(1))
//        .body("price",CoreMatchers.equalTo(15000))
//        .body("description",CoreMatchers.equalTo("15Good Product To Have it"))
//        .body("productName", CoreMatchers.equalTo("Whey protein"));
//		
		
		
//3> way
	Product expectedProduct=new Product(1,15000,5,"15Good Product To Have it","Whey protein");
	ValidatableResponse validatableResponse=RestAssured.given().when().queryParam("productId", 1).get("/productDetails").then();
		Product actualProduct=validatableResponse.extract().as(Product.class);
		Assert.assertEquals(expectedProduct, actualProduct);
		
		
		RestAssured.given()
		.when().queryParam("productId", 1).get("/productDeatails").then();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
