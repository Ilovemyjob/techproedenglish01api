package techproedenglish01.techproedenglish01api;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class ObjectMapperTestWithMap02 extends TestBaseDt {
	
	/*
	When 
	I send a GET request to REST API URL
	https://restful-booker.herokuapp.com/booking/5 
	Then 
	HTTP Status Code should be 200
	And response content type is “application/JSON” 
	And response body should be like; 
	{ "firstname": "Sally", 
	"lastname": "Ericsson", 
	"totalprice": 111,
	"depositpaid": false, 
	"bookingdates": { "checkin": "2017-05-23", 
	"checkout":"2019-07-02" }
	}
	*/
	
	
	@Test
	public void jsonFromApiToJava() {
		//1.Set the URL
		spec02.pathParam("id", 5);
		//2.Put the expected values into Java Object(Map)

		Map<String, Object> expectedMap = new HashMap<>();

		expectedMap.put("firstname", "ihsan Bugra");
		expectedMap.put("lastname", "MFY");

		expectedMap.put("totalprice", 317);

		expectedMap.put("depositpaid", true);

		expectedMap.put("checkin", "2016-09-16");

		expectedMap.put("checkout", "2019-04-23");
		
		//3.Get the actual data as a Map

		Response response = given().spec(spec02).when().get("/{id}");
		response.prettyPrint();
		/*
		 {
    "firstname": "ihsan Bugra",
    "lastname": "MFY",
    "totalprice": 317,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2016-09-16",
        "checkout": "2019-04-23"
    }
}
		 */

		Map<String, Object> actualMap =JsonUtil.convertJsonToJava(response.asString(), HashMap.class);
		
		System.out.println(actualMap);
//{firstname=ihsan Bugra, bookingdates={checkin=2016-09-16, checkout=2019-04-23}, totalprice=317, depositpaid=true, lastname=MFY}

		
		
		//4.Start Assetion (Hard Assertion)
		
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
		
		assertEquals(expectedMap.get("firstname"), actualMap.get("firstname"));
		assertEquals(expectedMap.get("lastname"), actualMap.get("lastname"));

		assertEquals(expectedMap.get("totalprice"), actualMap.get("totalprice"));

		assertEquals(expectedMap.get("depositpaid"), actualMap.get("depositpaid"));

		assertTrue(actualMap.get("bookingdates").toString().contains(expectedMap.get("checkin").toString()));
		assertTrue(actualMap.get("bookingdates").toString().contains(expectedMap.get("checkout").toString()));


		//why we create string bec. to use contains() Method
		
		
		//5.Start Assertion (Sort Assertion)
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(actualMap.get("firstname"),expectedMap.get("firstname"));
		softAssert.assertEquals(actualMap.get("lastname"),expectedMap.get("lastname"));

		softAssert.assertEquals(actualMap.get("totalprice"),expectedMap.get("totalprice"));

		softAssert.assertEquals(actualMap.get("depositpaid"),expectedMap.get("depositpaid"));

		softAssert.assertTrue(actualMap.get("bookingdates").toString().contains(expectedMap.get("checkin").toString()));

		softAssert.assertTrue(actualMap.get("bookingdates").toString().contains(expectedMap.get("checkout").toString()));

		softAssert.assertAll();

		
		
		/*
		1) ObjectMapper Class is used for Serialization(Java -> Json) and De-Serialization(Json -> Java)
		2) ObjectMapper does the same with GSON.
		3) I created a class in "utilities" package, its name is JsonUtil then I created 2 methods in the class.
		First one is for serialization and scond one is for de-serialization.
		In the first method, to convert Java Object to Json I used writeValueAsString() method. 
		In the scond method, to convert Json data to Java object I used readValue() method.
		I made the second method "generic" because I want my method to return different Java Objects.
		I made the methods static, so I am able to access them just by using class name which is JsonUtil.
		*/
		
		
		
		
		
		
	}

}
