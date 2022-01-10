package techproedenglish01.techproedenglish01api;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;



public class PostRequest01 extends TestBaseDt {
	
	/*
	 For post request , you need;
	 1)Endpoint ==>Mandatory
	 2)Request==>Mandatory
	 3)Authorization==>it depends on API
	 4)Headers==> it depends on API
	 
	 note: create REquest Body in 3 different way
	 */

	/*
    When 
      I send POST Request to http://dummy.restapiexample.com/api/v1/create
    Then 
      Status code is 200
      Content Type is "application/json"
      "status" key has value "success"
      "message" key has value "Successfully! Record has been added."
      
    Note: Create Request Body in 3 different ways  
    */
	
	@Test
	public void post01() {
		
		spec04.pathParam("create","create");
		//we added  birsey base url
		//1.way to create request body ==> Not Recommended
	//	String reqBody ="{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";

		//2.way to create Request Body by using JSONObject Class==>Better than 1. way
//		JSONObject reqBody = new JSONObject();
//		reqBody.put("name", "Emrah");
//		reqBody.put("salary", "4444");
//		reqBody.put("age", "33");

		//3.way to create Request Body by using Map==>the best way to use
		
		Map<String,String> reqBody = new HashMap<>();
		reqBody.put("name", "Emrah");
		reqBody.put("salary", "4444");
		reqBody.put("age", "33");

		
		//For basic authorization use=>auth().basic("admin", "password123").
		//For Bearer Token authorization use =>auth().oauth2("there is a long password)
		Response response = given().
				spec(spec04).
				body(reqBody).
				when().
				post("/{create}");
		
		response.prettyPrint();
	
		response.then().
		assertThat().
		statusCode(200).
		contentType(ContentType.JSON).
		body("status", Matchers.equalTo("success"),
			"message",Matchers.equalTo("Successfully! Record has been added."));
		
		
		HashMap<String,Object> map = response.as(HashMap.class);
		System.out.println(map);
		
		SoftAssert softAssert = new SoftAssert();
		
		
		
		softAssert.assertEquals(map.get("message"), "Successfully! Record has been added.");
		softAssert.assertEquals(map.get("status"), "success");
		
		softAssert.assertAll();
		
	}
	
	
	
}
