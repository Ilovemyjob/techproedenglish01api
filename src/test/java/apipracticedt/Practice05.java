package apipracticedt;

import static org.junit.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import techproedenglish01.techproedenglish01api.PojoPractice05;
import techproedenglish01.techproedenglish01api.TestBaseDt;

public class Practice05 extends TestBaseDt{
	/*
	When 
	I send a POST request to REST API URL 
	http://dummy.restapiexample.com/api/v1/create
	{
	"employee_name": "Ali Can",
	"employee_salary": "77000",
	"employee_age": "35",
	"profile_image": ""
	}  
	Then 
	HTTP Status Code should be 200
	And Response format should be "application/json"
	And "status" should be "success"
	And "message" should be "Successfully! Record has been updated."
	And "data.empty" should be false 
	​
	Note: For Base URL use spec04 and add path param "/create"
	Note: For actual data use De-Serialization
	Note: For expected data use Pojo Class
	Note: Use Hard Assertion(body()) and Soft Assertion
	*/
	
	@Test
	public void postpractice05() {
		
		spec04.pathParam("create", "create");
		//											after write click ctrl+space =>and select with parameter
		PojoPractice05 expectedData = new PojoPractice05("Ali Can", "77000", "35", null);
		//                                                                          //we used "" not null better
		expectedData.setStatus("success");
		expectedData.setMessage("Successfully! Record has been added.");

		Response response = given().
				contentType(ContentType.JSON).
				spec(spec04).
				body(expectedData).
				when().
				post("/{create}");
		
		response.prettyPrint();
		
		response.then().
		assertThat().
		statusCode(200).
		contentType(ContentType.JSON).
		body("status", Matchers.equalTo(expectedData.getStatus()),
				"data.employeeName", Matchers.equalTo(expectedData.getEmployeeName()),
				"data.employeeSalary", Matchers.equalTo(expectedData.getEmployeeSalary()),
				"data.profileImage", Matchers.equalTo(expectedData.getProfileImage()),
				"data.message", Matchers.equalTo(expectedData.getMessage()),
				"message", Matchers.equalTo(expectedData.getMessage()));
		
		
		//Hard Assertion with assertEquals(), assertTrue(), assertFalse()
		//We have 2 options to convert response body
		//1)JsonPath  2)De-Serialization ==> a)GSON  b)ObjectMapper
		JsonPath json = response.jsonPath();
		assertEquals(expectedData.getStatus(), json.getString("status"));
		assertEquals(expectedData.getEmployeeName(), json.getString("data.employeeName"));
		assertEquals(expectedData.getEmployeeSalary(), json.getString("data.employeeSalary"));
		assertEquals(expectedData.getEmployeeAge(), json.getString("data.employeeAge"));
		assertEquals(expectedData.getProfileImage(), json.getString("data.profileImage"));
		assertEquals(expectedData.getMessage(), json.getString("message"));
		
		
		
		//Soft Assertion
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(json.getString("status"), expectedData.getStatus());
		softAssert.assertEquals(json.getString("data.employeeName"), expectedData.getEmployeeName());
		softAssert.assertEquals(json.getString("data.employeeSalary"), expectedData.getEmployeeSalary());
		softAssert.assertEquals(json.getString("data.employeeAge"), expectedData.getEmployeeAge());
		softAssert.assertEquals(json.getString("data.profileImage"), expectedData.getProfileImage());
		softAssert.assertEquals(json.getString("message"), expectedData.getMessage());
		
		softAssert.assertAll();
		
		
	}
	
	
	
	
	
	
}
