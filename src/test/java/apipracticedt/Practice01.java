package apipracticedt;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import techproedenglish01.techproedenglish01api.TestBaseDt;
import utilities.JsonUtil;

import java.util.HashMap;
import java.util.Map;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Practice01 extends TestBaseDt{
	
	/*
	 When 
	    I send a GET request to REST API URL 
	    https://restful-booker.herokuapp.com/booking/1001   
    Then 
       HTTP Status Code should be 404
       And response body contains "Not Found"
       And response body does not contain "JavaApi" 
       And header " should be "Cowboy"
       And header "Content-Type" should be "text/plain; charset=utf-8"
       And header "Via" should be "1.1 vegur"

       Note: For Base URL use spec02
       Note: Use Map for expected values
       Note: Use Hard Assertion and Soft Assertion
*/
@Test
public void getPractice() {
//1.Set the URL
spec02.pathParam("id", 1001);

//2.Set the expected data= testdata
Map<String, String> expectedData = new HashMap<>();
expectedData.put("Server", "Cowboy");
expectedData.put("Content-Type", "text/plain; charset=utf-8");
expectedData.put("Via", "1.1 vegur");
expectedData.put("trueBodyText", "Not Found");
expectedData.put("wrongBodyText", "JavaApi");

//3.Send Request=Set Actual data
Response response = given().spec(spec02).when().get("/{id}");
response.prettyPrint();//Before pushing remove printing codes

//4.Assert status code and headers (Hard Assertion)
response.
then().
assertThat().
statusCode(404).
headers("Server", expectedData.get("Server"),
"Content-Type", expectedData.get("Content-Type"),
"Via", expectedData.get("Via"));


//5.Assert response body (Hard Assertion)
assertTrue(response.asString().contains(expectedData.get("trueBodyText")));//Remove hard coding -> it is done
assertFalse(response.asString().contains(expectedData.get("wrongBodyText")));//Remove hard coding -> it is done
assertEquals(expectedData.get("Server"), response.getHeader("Server") );
assertEquals(expectedData.get("Content-Type"), response.getHeader("Content-Type"));
assertEquals(expectedData.get("Via"), response.getHeader("Via"));

//6.Assert response body (Soft Assertion)
SoftAssert softAssert = new SoftAssert();

softAssert.assertEquals(response.getHeader("Server"), expectedData.get("Server"));
softAssert.assertEquals(response.getHeader("Content-Type"), expectedData.get("Content-Type"));
softAssert.assertEquals(response.getHeader("Via"), expectedData.get("Via"));

softAssert.assertTrue(response.asString().contains(expectedData.get("trueText")));
softAssert.assertFalse(response.asString().contains(expectedData.get("wrongText")));

softAssert.assertAll();





		
		
		
	}
}
