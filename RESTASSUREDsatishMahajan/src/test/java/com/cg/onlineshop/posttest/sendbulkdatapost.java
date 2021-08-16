package com.cg.onlineshop.posttest;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class sendbulkdatapost {
	
	
	@BeforeClass
	public static void setUpTestEnv() {

		RestAssured.baseURI="http://localhost:4444/onlineshop";

	}
	
//	@Test          //post bulk data
//	public void testAddProductDetailsBulkJSON() {
//		
//		
//		JSONObject jsonObject1=new JSONObject();
//		jsonObject1.put("price", 45000);
//		jsonObject1.put("starRating", 5);
//		jsonObject1.put("description", "New Product");
//		jsonObject1.put("productName", "Camera");
//		
//		JSONObject jsonObject2=new JSONObject();
//		jsonObject2.put("price", 20000);
//		jsonObject2.put("starRating", 5);
//		jsonObject2.put("description", "Good to handel");
//		jsonObject2.put("productName", "Laptop");
//		
//	    ArrayList<JSONObject> jsonObjects=new ArrayList<JSONObject>();
//	    jsonObjects.add(jsonObject1);
//	    jsonObjects.add(jsonObject2);
//	    
//	    
//	    RestAssured.given()
//	    .header("Content-Type","application/json")
//	    .body(jsonObjects.toString())
//	    .post("/addProductBulkJSON")
//	    .then().assertThat().
//	    //.statusCode(404).
//	    and().body(CoreMatchers.anything("Product details successfully added"));
//	    
//		
//	}
	
////	
	@Test                   //get all data
	public void testAllProductJSON() {
	Response response=RestAssured.get("/allProductsJSON");
	Product[] products=response.getBody().as(Product[].class);
	
	List<Product> productList=Arrays.asList(products);
	
		for(Product product:productList)
			System.out.println(product);
		
		
	}
	
//	@Test
//	 public void deleteRequest() {
//        Response response = 
//        		given()
//                .header("Content-type", "application/json")
//                .when()
//                .delete("/posts/1")
//                .then()
//                .extract().response();
//
//       Assert.assertEquals(200, response.statusCode());
//		
//		
//	}
////		@Test
//	public void delete() {
//		
//		//RestAssured.baseURI="http://localhost:4444/onlineshop";
//		
//		given().when().delete("http://localhost:4444/onlineshop/productId").getStatusCode();
//	
//		
//	}
//	
//		@Test
//		public void checkresponse() {
//			
//		
//			given()
//	 		.get("http://localhost:4444/onlineshop/productId").getStatusCode();
//	 		
//	 		      
//	 	
//		
//		
//		
//		}
//

}
