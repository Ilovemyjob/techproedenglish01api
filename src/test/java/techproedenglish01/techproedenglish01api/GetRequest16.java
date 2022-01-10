package techproedenglish01.techproedenglish01api;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetRequest16 extends TestBaseDt {
	
	/*
	 When
        I send GET Request to https://restful-booker.herokuapp.com/booking/3
     Then
            Status code is 200
        And Content type is "application/json"
        And Status line is "HTTP/1.1 200 OK"
        
        soft Assert
        And First name is Jim
        And Total price is 623
        And Deposit paid is true
        And Checkin date is 2020-03-18
        
  Use De-Serialization to convert Json response body to a Map. 
  Then by using the map and soft-assertion make assertions. 
	 */

	@Test//calismadi calistir 
	public void warmUp() {
		spec02.pathParam("bookingid", 3);

		
		Response response = given().spec(spec02).get("/{bookingid}");
		
		response.prettyPrint();
		
		HashMap<String,Object> map = response.as(HashMap.class);
		// Object cover all of data type
		//use as method to convert
		System.out.println(map);
		
		response.then().
		assertThat().
		statusCode(200).
		contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
	
		//desterilazition dont use json use map enough 
		//json is 2. option
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertTrue(map.get("firstname").equals("Eric"));
		
		softAssert.assertEquals(map.get("firstname"), "Eric");
		softAssert.assertEquals(map.get("totalprice"), 119);
		softAssert.assertEquals(map.get("depositpaid"), true);
		softAssert.assertTrue(map.get("bookingdates").toString().contains("checkin=2019-12-03"));

		
		softAssert.assertAll();
		
	}

}
