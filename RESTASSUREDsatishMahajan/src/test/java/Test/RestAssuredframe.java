package Test;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class RestAssuredframe {

	
	
	
	@BeforeClass
	public static void setUpTestEnv() {
		
		RestAssured.baseURI="http://localhost:4444/onlineshop";
		
	}
	
//    @Test
//    public void testSayHello() {
//    	
//    	// 1> way
//    	Response response=RestAssured.get("/sayHello");
//    	System.out.println(response.getStatusCode());
//    	System.out.println(response.getStatusLine());
//    	System.out.println(response.getBody().asString());
//    	
//    	String expectedResponse="Hello world from RestFulService";
//    	String actualresponse=response.getBody().asString();
//    Assert.assertEquals(expectedResponse, actualresponse);
	
	//2> way
		
		
		
//		Response response=RestAssured.get("/sayHello");
//		ValidatableResponse validatableResponse=response.then();
//		
//		validatableResponse=validatableResponse.assertThat();
//		validatableResponse=validatableResponse.statusCode(200);
//		validatableResponse=validatableResponse.and();
//		validatableResponse=validatableResponse.body(CoreMatchers.equalTo("Hello World From RestFulService"));
//		
		
		//3> way
//		RestAssured.get("/sayHello").
//		 then().
//		 assertThat().
//		 statusCode(200).
//		 and().
//		 body(CoreMatchers.equalTo("Hello World From RestFulWebService"));
//				
	
//	}
	
	@Test
	public void testProductDetailsForInvalidProductId() {
		
		RestAssured.given().when().queryParam("productId", 31231)
		.get("/productDetails")
		.then()
		.assertThat()
		.statusCode(404)
		.and()
		.body(CoreMatchers.containsString("Product details for productId  31231  not found"));
	}
	
	
//	@Test
//	public void testAddProductDetails()
//	{
//		
//		
//		
//		
//	}
//	
	@Test
	public void testAddProductDetails() {
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
    }
	
	
	
	
	
	
	

