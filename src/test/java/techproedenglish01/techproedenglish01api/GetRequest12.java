package techproedenglish01.techproedenglish01api;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetRequest12 extends TestBaseDt {

 /*
     * When I send GET Request to URL
     * http://dummy.restapiexample.com/api/v1/employees
     * Then
     * Status code is 200
     *  1)Print all ids greater than 10 on the console
     *  Assert that there are 14 ids greater than 10
     *  2)Print all ages less than 30 on the console
     *  Assert that maximum age is 23
     *  3)Print all employee names whose salaries are greater than 350000 
     *  Assert that Charde Marshall is one of the employees whose salary is greater than 350,000
    	4)Print all employee salaries whose ids less than 11
    	Assert that maximum salary is 43306
     */

	@Test
	
	public void get() {
		
		Response response = given().
				spec(spec03).
				when().
				get();
		
		response.prettyPrint();
		
		response.
		then().
		assertThat().
		statusCode(200);
		
		JsonPath json = response.jsonPath(); //send json //burda birseyler soyledi
		SoftAssert softAssert = new SoftAssert();
		
	   //  *  1)Print all ids greater than 10 on the console

		//class which in get id which in 
		//this.id look at the data which in response body=all response body
		//this.id java language ,it.id grovvy language
		
		//integer.value() change string to int
		List<String> idList2 = json.getList("data.id");
		List<String> idList = json.getList("data.findAll{Integer.valueOf(it.id)>10}.id"); 
		
	
		
		System.out.println(idList);
		
		
		//it” means the data in response body.“it.id” means ALL IDS FROM RESPONSE BODY
		//Ids are String in response body, i have to convert them to int.
		//Integer.valueOf()method convert Strings to int.
	//=========================================================	
	 //    *  Assert that there are 14 ids greater than 10
		
		softAssert.assertEquals(idList.size(), 14);

		
	  //   *  2)Print all ages less than 30 on the console

		List<String> ageList =json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
		// saece employee_age icin sonuna kullaniyoruz 
		
		System.out.println(ageList);
		//======================
		//*  Assert that maximum age is 23
		//first convert everyting int. then sort and find last element which is max
		
		List<Integer> ageListInt = new ArrayList<>();
		
		for (String w : ageList) {
			ageListInt.add(Integer.valueOf(w));
		}
		
		System.out.println(ageListInt);
		
		Collections.sort(ageListInt);
		System.out.println(ageListInt);
		
		softAssert.assertTrue(ageListInt.get(ageListInt.size()-1)==23);
		
	  //   *  3)Print all employee names whose salaries are greater than 350000 

		List<String> namesList = json.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000 }.employee_name"); 
     	System.out.println(namesList);
     	
     	//========================
     	//     *  Assert that Charde Marshall is one of the employees whose salary is greater than 350,000

     	
     	softAssert.assertTrue(namesList.contains("Charde Marshall"));
     	
     	//4)Print all employee salaries whose ids less than 11

     	
     	List<String> salariesList = json.getList("data.findAll{Integer.valueOf(it.id)<11 }.employee_salary");
     	System.out.println(salariesList);
     	
     	
        //	Assert that maximum salary is 43306
     	List<Integer> salariesListint = new ArrayList<>();
     	
     	for (String w : salariesList) {
     		salariesListint.add(Integer.valueOf(w));
		}
     	
     	System.out.println(salariesListint);
     	
     	Collections.sort(salariesListint);
     	System.out.println(salariesListint);
     	
     	softAssert .assertTrue(salariesListint.get(salariesListint.size()-1)==433060);
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
		softAssert.assertAll();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 
}
