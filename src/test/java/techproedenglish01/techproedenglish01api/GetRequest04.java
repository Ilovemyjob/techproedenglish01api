package techproedenglish01.techproedenglish01api;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.response.Response;


public class GetRequest04 {

	
	/*
	1 how to get all Headers data
	2 How to get a specific Header
	3 How to assert Headers one by one
	 */
	@Test
	public void get01() {
		Response response = given().when().get("https://restful-booker.herokuapp.com/booking");
		response.prettyPrint();
		//1 how to get all Headers data
		System.out.println(response.getHeaders());
		//Assert if Headers contains "Etag"
		//assertTrue(response.getHeader("Expect-CT")); //or equals(null) it didn t work
	
		//2 How to get a specific Header
		System.out.println(response.getHeader("Expect-CT"));
		
		assertEquals(response.getHeader("Expect-CT"),null);
		
		
		System.out.println(response.getHeader("Server"));
		
		//3 Assert that Via header has the value "1.1 vegur""
		
		
		assertEquals(response.getHeader("Via"),"1.1 vegur");
		//by this method we assert first headers than value 
		

 }
}
