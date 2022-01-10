package techproedenglish01.techproedenglish01api;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Patch01 extends TestBaseDt {

	/*
	 For PATCH Request(Partial Update) you need;
	 1)Endpoint ==> Mandatory
	 2)Request Body ==> Mandatory
	 3)Authorization ==> It depends on the API
	 4)Header ==> It depends on the API
*/

	/*
	 {
    "userId": 10,
    "id": 198,
    "title": "quis eius est sint explicabo",
    "completed": true
}
put send all data
patch send specific part of data

Hashmap ilk yaziliyor 
data ekleniliyor
body ile response da degistiriliyor

	 */

	
	@Test
	public void patch01() {
		spec01.pathParam("id", 50);
		
		Map<String,String> reqBody = new HashMap<>();
		reqBody.put("title", "Emrah");
		//Normally after running the code I should see Suleyman as title on the console.
				//But that API does not let us to update data. Because of that I just asserted 
				//status code and content type.
		
		Response response = given().spec(spec01).body(reqBody).when().patch("/{id}");
		
		response.prettyPrint();
		response.then().statusCode(200).contentType(ContentType.JSON);
		
		
		
	}
}
