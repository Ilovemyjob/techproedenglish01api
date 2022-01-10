package techproedenglish01.techproedenglish01api;

import static org.junit.Assert.assertEquals;

import static org.hamcrest.Matchers.*;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import techproedenglish01.techproedenglish01api.TestBaseDt;


import static io.restassured.RestAssured.*;  
// every times you should by hand

public class GetRequest07 extends TestBaseDt{

	/*
	 When I send a GET request to REST API URL
	 https://jsonplaceholder.typicode.com/todos/123
     Then HTTP Status Code should be 200
     And "Server" in Headers should be "cloudflare"
     And response content type is “application/JSON”
     And "userId" should be 7,
     And "title" should be "esse et quis iste est earum aut impedit"
	 And "completed" should be false
	 */
	
	@Test
	public void get01() {
		
		spec01.pathParam("id", 123);  //123 id thats why we used id and we can easly update 123
		//123 make big data  to small data
		Response response = given().
				spec(spec01).
				when().
				get("/{id}"); //if we update it is easy to change
				//get("https://jsonplaceholder.typicode.com/todos/123");
		
		response.prettyPrint();
		
		response.
		then().
		assertThat().
		statusCode(200).
		contentType(ContentType.JSON).
		body("userId", equalTo(7),
			"title",equalTo("esse et quis iste est earum aut impedit"),
			"completed",equalTo(false));
		
		assertEquals(response.getHeader("Server"), "cloudflare");
		
		/*
		 * After the Base URL if you smth, together with "/" like "123" it is called "path param" . 
		 * Path param makes the source small
		 */
		
		
		
	}
	
	
	
	
}
