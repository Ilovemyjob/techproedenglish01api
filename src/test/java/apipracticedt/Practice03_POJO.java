package apipracticedt;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import techproedenglish01.techproedenglish01api.Data;
import techproedenglish01.techproedenglish01api.PojoPractice03;
import techproedenglish01.techproedenglish01api.TestBaseDt;

public class Practice03_POJO extends TestBaseDt{
	/*
	When 
	I send a GET request to REST API URL 
	http://dummy.restapiexample.com/api/v1/employee/3  
	
	Then 
	HTTP Status Code should be 200
	And Response format should be "application/json"
	And "employee_name" should be "Ashton Cox"
	And "employee_salary" should be 86000
	And "employee_age" should be 66
	And "status"should be "success"
	And "message" should be "Successfully! Record has been fetched."
	
	Note: For Base URL use spec04
	Note: For actual data use JsonPath
	Note: For expected data use JSONObject
	Note: Use Hard Assertion and Soft Assertion
	*/

	/*
	 * "status": "success",
    "data": {
        "id": 3,
        "employee_name": "Ashton Cox",
        "employee_salary": 86000,
        "employee_age": 66,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
	 */
	@Test
	public void getPractice() {
		//1.Step: Set Endpoint by using pathParam() or queryParam()
		spec04.pathParams("employee", "employee",
				          "id", 3);
		
		//2.Step: Store expected data by using Pojo
		Data data = new Data(3, "Ashton Cox", 86000, 66, "");
		PojoPractice03 expectedData = new PojoPractice03("success", data, "Successfully! Record has been fetched.");
		
		//3.Step: Send GET Request to the Endpoint
		Response response = given().contentType(ContentType.JSON).spec(spec04).when().get("/{employee}/{id}");
		response.prettyPrint();

		//4.Step Hard Assertion by using body()
				response.
				    then().
				    assertThat().
				    statusCode(200).
				    contentType(ContentType.JSON).//Body is best and easy method 	
				    //we did not uselike others get("data.employee_name")//use getter and setter like JAVA for POJO  
				    body("data.employee_name", Matchers.equalTo(data.getEmployeeName()),
				    	 "data.employee_salary", Matchers.equalTo(data.getEmployeeSalary()),
				    	 "data.employee_age", Matchers.equalTo(data.getEmployeeAge()),
				    	 "data.profile_image", Matchers.equalTo(data.getProfileImage()),
				    	 "status", Matchers.equalTo(expectedData.getStatus()),
				    	 "message", Matchers.equalTo(expectedData.getMessage()));

				  //5.Step Hard Assertion by using assertEquals(), assertTrue(), assertFalse()
					JsonPath json = response.jsonPath();
					assertEquals(data.getEmployeeName(), json.getString("data.employee_name"));
					assertEquals(data.getEmployeeSalary(),json.get("data.employee_salary"));
					assertEquals(data.getEmployeeAge(), json.get("data.employee_age"));
					assertEquals(data.getProfileImage(), json.getString("data.profile_image"));
					assertEquals(expectedData.getStatus(), json.getString("status"));
					assertEquals(expectedData.getMessage(), json.getString("message"));
					
					//6. Step: Soft Assertion
					SoftAssert softAssert = new SoftAssert();
					
					softAssert.assertEquals(json.getString("data.employee_name"), data.getEmployeeName());
					softAssert.assertEquals(json.get("data.employee_salary"), data.getEmployeeSalary());
					softAssert.assertEquals(json.get("data.employee_age"),data.getEmployeeAge());
					softAssert.assertEquals(json.getString("data.profile_image"),data.getProfileImage());
					softAssert.assertEquals(json.getString("status"),expectedData.getStatus());
					softAssert.assertEquals(json.getString("message"),expectedData.getMessage());
				
					softAssert.assertAll();

//
//	
//	}
}

}
