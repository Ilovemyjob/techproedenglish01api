package techproedenglish01.techproedenglish01api;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

  

public class GetRequest10 extends TestBaseDt {

	/*
	 * When I send a GET request to REST API URL
	 * https://restful-booker.herokuapp.com/booking/5
	 * Then HTTP Status Code should be 200
	 * And response content type is “application/JSON”
	 * And response body should be like;
	 * {
	 *   "firstname": "Sally",
	 *   "lastname": "Ericsson",
	 *   "totalprice": 111,
	 *   "depositpaid": false,
	 *   "bookingdates": { "checkin": "2017-05-23",
	 *                     "checkout":"2019-07-02" }
	 * }
	 * 
	 * 
	 * 
	 * JSONPATH:is used to navigate in Json Data
	 */
	
	@Test
	public void get01() {
		spec02.pathParam("bookingid", 5);
	
		Response response = given().spec(spec02).when().get("/{bookingid}");
		
		response.prettyPrint();
		
		
		
     	JsonPath json = response.jsonPath();
		
		
		System.out.println(json.getString("firstname"));  // get method used for all
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(json.getString("firstname"), "Susan");
	

		
		
		System.out.println(json.getString("lastname"));
		
		softAssert.assertEquals(json.getString("lastname"), "Wilson");
		
		System.out.println(json.getInt("totalprice"));
		
		softAssert.assertEquals(json.getInt("totalprice"), 817);

		
		
		System.out.println(json.getBoolean("depositpaid"));
		
		softAssert.assertEquals(json.getBoolean("depositpaid"), true);
		
		System.out.println(json.getString("checkin"));
		
		softAssert.assertEquals(json.getBoolean("checkin"), "2018-03-01");

				
		System.out.println(json.getString("checkout"));    
		
		softAssert.assertEquals(json.getBoolean("checkout"), "2020-07-20");
			
		
		System.out.println(json.get("additionalneeds"));
		//bunu yapmadim ve surekli degisiyor
		
	
		softAssert.assertAll();
		
	}
//	@Test
//	public void get() {
//		//spec02.pathParam(parameterName, parameterValue)
//		
//		Response response = given().when().get("/5");
//		response.prettyPrint();
//		
//	}
//	
	
	
}
