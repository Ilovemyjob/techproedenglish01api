package techproedenglish01.techproedenglish01api;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class PostRequest02 extends TestBaseDt{
	
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
	@Test
	
	
	public void post() {
		
		Map<String,Object> reqBody =new HashMap<>();
		reqBody.put("firstname", "Team1");
		reqBody.put("lastname", "Can");

		reqBody.put("totalprice", 111);

		reqBody.put("depositpaid", true);
	

// we have to create for every Json create Map
	//	reqBody.put("firstname", "{\"checkin\": \"2020-09-16,\"checkout\": \"2020-09-18\"}");

		Map<String,Object> datesMap =new HashMap<>();// it is called test data
		datesMap.put("checkin", "2020-09-16");
		datesMap.put("checkout", "2020-09-18");
		// after we insert another Map
		reqBody.put("bookingdates", datesMap);

		reqBody.put("additionalneeds", "Wifi");


//		String reqBody = "{\n" + 
//                "\"firstname\": \"Ali\",\n" + 
//                "\"lastname\": \"Can\",\n" + 
//                "\"totalprice\": 111,\n" + 
//                "\"depositpaid\": true,\n" + 
//                "\"bookingdates\": {\n" + 
//                "\"checkin\": \"2020-09-16\",\n" + 
//                "\"checkout\": \"2020-09-18\"\n" + 
//                "},\n" + 
//                "\"additionalneeds\": \"Wifi\"\n" + 
//                "}";

		Response response = given().
				contentType(ContentType.JSON).// in sweager dok. we can see what we need here we need HEADER
				auth().
				basic("admin", "password123"). // click Autorization select basic
				spec(spec02).
				body(reqBody).
				when().
				post();
		
		response.prettyPrint();// it is creating new data and give new id and booking: {"fistname"=.....
		
		response.
		then().
		assertThat().
		statusCode(200).
		contentType(ContentType.JSON).
		body("booking.firstname", equalTo(reqBody.get("firstname")),
				// in this question we didnot use "Ali" it is not accepting in test area
				"booking.lastname", equalTo(reqBody.get("lastname")),
				"booking.totalprice", equalTo(reqBody.get("totalprice")),
				"booking.depositpaid", equalTo(reqBody.get("depositpaid")),
				"booking.bookingdates", equalTo(reqBody.get("bookingdates")),
				//if you want to assert one by one 
				"booking.bookingdates.checkin", equalTo(datesMap.get("checkin")),
				"booking.bookingdates.checkout", equalTo(datesMap.get("checkout")),
				"booking.additionalneeds", equalTo(reqBody.get("additionalneeds")));

		Map<String,Object> actualData	= response.as(HashMap.class);
		//actualdata is map data coming from api
		//as convert response ,rsponse convert hascmap
		System.out.println(actualData);
		// for deserialization use gson dependency
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertTrue(actualData.get("booking").toString().contains(reqBody.get("firstname").toString()));
		softAssert.assertTrue(actualData.get("booking").toString().contains(reqBody.get("lastname").toString()));
		softAssert.assertTrue(actualData.get("booking").toString().contains(reqBody.get("totalprice").toString()));
		softAssert.assertTrue(actualData.get("booking").toString().contains(reqBody.get("depositpaid").toString()));
		softAssert.assertTrue(actualData.get("booking").toString().contains(reqBody.get("bookingdates").toString()));
		softAssert.assertTrue(actualData.get("booking").toString().contains(reqBody.get("additionalneeds").toString()));

		
		
		softAssert.assertAll();
		
		
		
		
		
		
		
		
	}
	

}
