package apipracticedt;
import static io.restassured.RestAssured.*;
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

public class Practice03 extends TestBaseDt{
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
	public void get() {
		
		spec04.pathParams("employee","employee",
            	"id",3);
		
	//Data data = new Data(3,"Ashton Cox",86000,66,"", null);
	
	//PojoPractice03 employee = new PojoPractice03("success",data,"Successfully! Record has been fetched.", null);
	
	JSONObject jsonExpected = new JSONObject();
	jsonExpected.put("data.id", 3);
	jsonExpected.put("data.employee_name", "Ashton Cox");
	jsonExpected.put("data.employee_salary", 86000);
	jsonExpected.put("data.employee_age", 66);
	jsonExpected.put("data.profile_image", "");
	jsonExpected.put("status", "success");
	jsonExpected.put("message", "Successfully! Record has been fetched.");


	
	
	
	
	Response response = given().spec(spec04).when().get("/{employee}/{id}");
	
	response.prettyPrint();

	
	response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
	body("data.employee_name", Matchers.equalTo(jsonExpected.get("data.employee_name")),
			"data.employee_salary", Matchers.equalTo(jsonExpected.get("data.employee_salary")),
					"data.employee_age", Matchers.equalTo(jsonExpected.get("data.employee_age")));

	//Hard
	JsonPath jsonActual = response.jsonPath();
	
	assertEquals(jsonExpected.get("data.employee_name"), jsonActual.getString("data.employee_name"));
	assertEquals(jsonExpected.get("data.employee_salary"), jsonActual.getInt("data.employee_salary"));
	assertEquals(jsonExpected.get("data.employee_age"), jsonActual.getInt("data.employee_age"));

	
	SoftAssert softAssert = new SoftAssert();
	
	//soft
	
	softAssert.assertEquals(jsonActual.get("data.employee_name"), jsonExpected.get("data.employee_name"));
	softAssert.assertEquals(jsonActual.getInt("data.employee_salary"), jsonExpected.get("data.employee_salary"));
	softAssert.assertEquals(jsonActual.getInt("data.employee_age"), jsonExpected.get("data.employee_age"));

	softAssert.assertAll();

	
	}
}
