package techproedenglish01.techproedenglish01api;



	

import org.junit.Test;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.restassured.response.Response;
public class GetRequest15 extends TestBaseDt {
	@Test
	public void get01() {
		
		//we created  JSON to List of map 
		Response response =given().spec(spec02).when().get();
	
	    response.prettyPrint();
	    
// convert to map store in a List
	    // structure create List but element are Map
	List<Map<String,String>> listOfMaps = response.as(ArrayList.class); 
	System.out.println(listOfMaps);
	
}
}