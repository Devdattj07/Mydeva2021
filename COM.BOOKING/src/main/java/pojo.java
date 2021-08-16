import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class pojo {
	
	protected Response createBooking() {
		//Create JSON body
				JSONObject body=new JSONObject();
				body.put("firstname", "Sally");
				body.put("lastname", "Smith");
				body.put("totalprice", 853);
				body.put("depositpaid", false);
			
				JSONObject bookingdates=new JSONObject();
				bookingdates.put("checkin", "2019-07-22");
				bookingdates.put("checkout", "2019-08-08");
				
				body.put("bookingdates", bookingdates);
				body.put("additionalneeds", "Breakfast");
				
				
				
			
			//{"firstname":"Sally",
		//	"lastname":"Smith",
		//	"totalprice":853,
		//	"depositpaid":false,
		//	"bookingdates":{"checkin":"2019-07-22",
		//	               "checkout":"2019-08-08"}}
			
			
				//Get response
				
				Response response =RestAssured.given().contentType(ContentType.JSON)
						.body(body.toString())
						
						.post("https://restful-booker.herokuapp.com/booking");
				
		return response;

}}
