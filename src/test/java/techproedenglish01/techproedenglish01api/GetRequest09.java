package techproedenglish01.techproedenglish01api;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;  
public class GetRequest09 extends TestBaseDt {

//	Among the data there should be someone whose first name is Jim
//	 URL: https://restful-booker.herokuapp.com/booking
	/*
	 1. you can type query param inside the get () method -not recommended
	 2.You can use //spec02.queryParam("firstname", "jim");--use it for single query param
	 3. you can use spec02.queryParams("firstname", "Jim",   -use it for multiple query params
							             "totalprice", 2);
	 */
	
	@Test 
	public void get01() {
		
		
	
		//spec02.queryParam("firstname", "Mark");
		//spec02.queryParam("totalprice", 2);
		
	//	spec02.queryParams("firstname", "Mark", 
	//						"totalprice", 2);
	
	
		Response response = given().
							spec(spec02).
							when().
							get("?firstname=Mark");  //inside there was data but we write upside
		
	response.prettyPrint();
	//Assert that the data whose first name is Jim exists among the data
//	assertTrue(response.asString().contains("bookingid"));
	
	
//		spec02.queryParam("firstname", "Eric");
//		Response response1 = given().     
//				spec(spec02).
//				when().
//				get();
//     	response1.prettyPrint(); 
	
	
//     	//spec02.queryParam();
//    	Response response2 = given().     
//    			spec(spec02).
//    			when().
//    			get("?firstname=Mary");
//    	
//     	response2.prettyPrint(); 
//	
	}
	
	
	
	
	
}
