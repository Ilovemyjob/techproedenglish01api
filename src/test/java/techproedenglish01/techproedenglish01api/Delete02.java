package techproedenglish01.techproedenglish01api;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;


import org.junit.Test;

import io.restassured.response.Response;

public class Delete02 extends TestBaseDt {
	/*                                  WARM UP (10 minutes)
	1)Create class and name it as "Delete02"                      
	2)When 
	I send DELETE Request to http://dummy.restapiexample.com/api/v1/delete/719
	Then 
	Status code should be 200
	The value of "status" key in response body should be "success"  
	The value of "message" key in response body should be "Successfully! Record has been deleted"
	Note 1: Use hard assertion
	Note 2: After given() please use contentType(ContentType.JSON)
	*/

	@Test
	public void delete01() {
		//Add path params to the base url
		spec04.pathParams("delParam", "delete",
				          "id",719);
		
		//Create a map for the expected values
		Map<String,String> expectedMap = new HashMap<>();
		expectedMap.put("status", "success");
		expectedMap.put("message", "Successfully! Record has been deleted");
		
		//Type the script to delete the data
		Response response = given().spec(spec04).when().delete("/{delParam}/{id}");
		
		response.prettyPrint();
		
		Map<String, String> actualMap = response.as(HashMap.class);
		// to not make hart codding use always key ,not value in assert part
		//1.way for hard assertion by using body()
		response.
		     then().
		     assertThat().
		     statusCode(200).
		     body("status", Matchers.equalTo(expectedMap.get("status")),
		    	  "message", Matchers.equalTo(expectedMap.get("message")));
		
		//2.way for hard assertion by using assertEquals()

		assertEquals(expectedMap.get("status"),actualMap.get("status"));
		assertEquals(expectedMap.get("message"),actualMap.get("message"));
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
