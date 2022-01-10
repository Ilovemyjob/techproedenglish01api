package techproedenglish01.techproedenglish01api;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;

public class GetRequest13 {
	
	//How to work with local Json Data
  //C:\Users\Administrator\Desktop\Employee.json

	


	@Test 
	public void get01() {
		// no need to use given get () bec in my local
		//we use JsonPath to navigate inside data
		
		JsonPath json = new JsonPath(new File("C:\\Users\\Administrator\\Desktop\\Employee.json"));
		SoftAssert softassert = new SoftAssert();
		
		//Get all employee namees whose salaries are greather than 150,000
		
		List<String> nameList = json.getList("data.findAll{Integer.valueOf(it.employee_salary)>150000}.employee_name");
		System.out.println(nameList);
		
		//Assert that 17 employees are earning greather than 150,000
		
		softassert.assertTrue(nameList.size()==17);
		
		//Assert that maximum salary for all employees is 725000 
		
		List<String> salaryList = json.getList("data.employee_salary");
		List<Integer> salaryListInt = new ArrayList<>();
		
		for (String w : salaryList) {
			salaryListInt.add(Integer.valueOf(w));
		}
		
		Collections.sort(salaryListInt);
		
		System.out.println(salaryListInt);
		
		softassert.assertTrue(salaryListInt.get(salaryListInt.size()-1)==725000);
		
		
		
		
		
		
		
		softassert.assertAll();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}












}
