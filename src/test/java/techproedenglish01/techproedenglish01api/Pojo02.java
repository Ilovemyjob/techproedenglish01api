package techproedenglish01.techproedenglish01api;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Pojo02 extends TestBaseDt{
	/*
	1)Add path parameter which is "/create" to the base url
	2)By using POJO, create a Request Body which has the following data
	{
	"name": "Test Data",
	"salary": "8888",
	"age": "33"
	}
	3)When 
	I send POST Request to http://dummy.restapiexample.com/api/v1/create
	Then 
	Status code is 200
	Content Type is "application/json"
	"status" key has value "success"
	"message" key has value "Successfully! Record has been added."  
	4)Make assertions by using hard assertion     
	*/
	@Test
	public void post01() {
		// pojo save the data and we send and get from there 
		TestPojoDt expectedData = new TestPojoDt("Test Data","8888","33");
		
		expectedData.setStatus("success");// we added after because they are not in pojo class
		expectedData.setMessage("Successfully! Record has been added.");

		
		spec04.pathParam("createParam", "create");
		
		
		
		Response response = given().spec(spec04).body(expectedData).when().post("/{createParam}");
		
		response.prettyPrint();
		
		Map<String,String> actualData =response.as(HashMap.class);
		
		
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
		//we did not find get status and we add in pojotest class private and setter getter for Status ans Message 
	    //we create in pojo class
		//private String status;
		//private string message;
		//and setter getter ...
		
	
		assertEquals(expectedData.getStatus(), actualData.get("status"));
		assertEquals(expectedData.getMessage(), actualData.get("message"));

		
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualData.get("status"), expectedData.getStatus());
		softAssert.assertEquals(actualData.get("message"), expectedData.getMessage());

	
	
		softAssert.assertAll();
	
	
	
	}
	
	
	
	
	
}
