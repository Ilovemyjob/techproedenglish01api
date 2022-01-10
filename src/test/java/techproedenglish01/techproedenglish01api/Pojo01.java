package techproedenglish01.techproedenglish01api;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Pojo01 extends TestBaseDt {
	
/*
 * POJO stands for Plains Old Java Object
 * POJO is a class 
 * json is difficult
 * we converting to java or POJO class,
 * flow=Json Data->POJO class->Object->Use it in Automation
 *POJO is a class created by usn gJson Data
 *
 *When you create a POJO Class ,it should have;
 *1-private variables
 *2-getter(),setter() methods for all variables
 *3-Construction with all parameters
 *4-Construction with all parameters
 *5-toString()
 *
 *some site converting automaticly json to pojo
 *http://www.jsonschema2pojo.org/
 *
 */
	
	/*                Warm Up (10 Minutes)
    When 
      I send POST Request to https://restful-booker.herokuapp.com/booking ==> spec02
      with the request body 
           {
               "firstname": "Ali",
               "lastname": "Can",
               "totalprice": 111,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2020-09-16",
                   "checkout": "2020-09-18"
               },
               "additionalneeds": "Wifi"
           }
    Then 
      Status code is 200
      Content Type is "application/json"
      Assert all response body details
      
    Note: Create Request Body by using Map  
   */
	
	@Test//import junit
	public void post01(){
		
		//to cerate Request body we will use POJE Classes
		
		// in PostRequest02 de we create 2 JSON now we create 2 POJO Class
		//we have already in main 
		// we have Json and Pojo class now object
		BookingDatesDt bookingDates=new BookingDatesDt("2020-09-16", "2020-09-18");
	//object for inside Pojo class 
		BookingDt booking =new BookingDt("Ali", "Can", 111, true, bookingDates, "Wifi");
		
		// object for outside Pojo class
		
		
		
		Response response = given().
				contentType(ContentType.JSON).
				spec(spec02).
				body(booking).
				when().
				post();
		
		response.prettyPrint();
		//we used POJO to get response Body
		
		
		JsonPath actualData = response.jsonPath();
		
		response.then().statusCode(200).contentType(ContentType.JSON);
		
		assertEquals(booking.getFirstname(), actualData.getString("booking.firstname"));
		assertEquals(booking.getLastname(), actualData.getString("booking.lastname"));
		assertEquals(booking.getTotalprice().toString(), actualData.getString("booking.totalprice"));
		assertEquals(booking.getDepositpaid(), actualData.getBoolean("booking.depositpaid"));

		assertEquals(bookingDates.getCheckin(), actualData.getString("booking.bookingdates.checkin"));
		assertEquals(bookingDates.getCheckout(), actualData.getString("booking.bookingdates.checkout"));
//		
		assertEquals(booking.getAdditionalneeds(), actualData.getString("booking.additionalneeds"));
//
//		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
