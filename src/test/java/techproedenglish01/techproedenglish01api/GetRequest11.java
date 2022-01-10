package techproedenglish01.techproedenglish01api;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;


public class GetRequest11 extends TestBaseDt{
	/*
	 * When I send a GET Request to URL
	 * http://dummy.restapiexample.com/api/v1/employees
	 * Then status code is 200
	 * 
	 * And the name of 5th employee is "Airi Satou"
	 * And the salary of 6th employee is "372000"
	 * And there are "24" employees
	 * And "Rhona Davidson" is one of the employees
	 * And "21","23","61" are among employee ages
	 */
	
	
	@Test//anotation from junit
	
	
	public void get() {
		
		Response response =given().spec(spec03).when().get();
		
		response.prettyPrint();
		//for specific question contain
		//other hasitems
		response.
		then().
		statusCode(200).//use everytime for statuscode hard assertion.
		//if status not true no need to check others bec. hard assertion
		body("data[4].employee_name", Matchers.equalTo("Airi Satou"),
			"data[5].employee_salary", Matchers.equalTo("372000"),
			"data.id", Matchers.hasSize(24),
			"data.employee_name",Matchers.hasItem("Rhona Davidson"),
			"data.employee_age",Matchers.hasItems("21","23","61"));//if not string dont use ""
						
		
		/*/
		 What is the difference between hard assertion and soft assertion
		 inhard assertion ,if any assertion fails next ones do not executed.
		 in soft assertion , all assertion are ececued everytime 
		 then you get report afor all assertion one by one.
		 
		 there are 3 steps for soft assertion
		 1-you have to create an obj.from SoftAssert class
		 SoftAssert softAssert = new SoftAssert();
		 2-you select assertion methods from SoftAssertion Class
		  by using softAssertion obj.
		 3-Dont forget to type assertAll() method at the end .
		 if you do not type assertAll() method at the end
		  you will get green everytiome but it is not meaningful.
		 */
		
		//Assert the same test case by using soft assertion
		
	
		
		JsonPath json = response.jsonPath();// review it
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(json.getString("data[4].employee_name"), "Airi Satou");
		// And the salary of 6th employee is "372000"
		softAssert.assertEquals(json.getString("data[5].employee_salary"), "372000");
		softAssert.assertEquals(json.getList("data.id").size(), 24);
		softAssert.assertTrue(json.getList("data.employee_name").contains("Rhona Davidson"));

		List<String> ageList = new ArrayList<>();
		ageList.add("21");
		ageList.add("23");
		ageList.add("61");

		softAssert.assertTrue(json.getList("data.employee_age").containsAll(ageList));
//collection=list qiue set
		
		softAssert.assertAll();
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
