package techproedenglish01.techproedenglish01api;

import org.junit.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Delete extends TestBaseDt{

	/*
	 for DELETE Request we need just Endpoint like GET Request ,we dont need Request Body
	 */
	
	@Test
	public void put01() {
		//Get the data before deleting
		//request no need we drectly write response
		Response responseGet =given().spec(spec01).when().get("/199");
		responseGet.prettyPrint();
		
		//Get the data after deleting
		Response response = given().spec(spec01).when().delete("/199");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
