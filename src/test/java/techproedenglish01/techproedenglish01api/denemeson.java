package techproedenglish01.techproedenglish01api;


import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.junit.Test;


public class denemeson {
	
	@Test
	public void Get() {
		Response response= given().when().get("https://restful-booker.herokuapp.com/booking");

		response.prettyPrint();
	}
	

}
