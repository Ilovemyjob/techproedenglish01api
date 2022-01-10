package techproedenglish01.techproedenglish01api;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*; 
// if we use static and Matcher .* we dont need to write all times Matcher
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetRequest05 {

//	When I send a GET request to REST API URL
//	https://restful-booker.herokuapp.com/booking/1
//    And Accept type is “application/JSON”
//    Then
//    HTTP Status Code should be 200
//    And Response format should be "application/JSON"
	
//    And first name should be "Susan"
//    And lastname should be "Brown"
//    And checkin date should be "2015-02-16"
//    And checkout date should be "2017-06-20"
	@Test
	public void get01() {
		Response response=given().
			//	accept(ContentType.JSON).==>give ERROR.some of API cannot be restricted
				// it means we sending JSON types
				when().
				get("https://restful-booker.herokuapp.com/booking/1");   
		
     	response.prettyPrint();
	
		response.then().
		assertThat().
		statusCode(200).
		contentType(ContentType.JSON).
		body("firstname", equalTo("Team 1 is the best team")).
		body("lastname", equalTo("Techproed")).
		body("totalprice", equalTo(16)).
		body("depositpaid", equalTo(false)).
		body("bookingdates.checkin", equalTo("2018-06-04")).
		body("bookingdates.checkout", equalTo("2019-11-18"));
		
	}
	
	@Test
	public void get02() {
		Response response=given().
			//	accept(ContentType.JSON).==>give ERROR.some of API cannot be restricted
				// it means we sending JSON types
				when().
				get("https://restful-booker.herokuapp.com/booking/1");   
		
	response.prettyPrint();
		response.then().
		assertThat().
		statusCode(200).
		contentType(ContentType.JSON).    // short way to write without body
		body("firstname", equalTo("Team 1 is the best team"),
			"lastname", equalTo("Techproed"),
			"totalprice", equalTo(16),
			"depositpaid", equalTo(false),
			"bookingdates.checkin", equalTo("2018-06-04"),
			"bookingdates.checkout", equalTo("2019-11-18"));
	
		
	}
	
	
	
}
