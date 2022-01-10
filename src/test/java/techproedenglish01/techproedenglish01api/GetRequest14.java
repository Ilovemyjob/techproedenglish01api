package techproedenglish01.techproedenglish01api;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest14 extends TestBaseDt {

	
	//GSON is a converter
  //	"    is used  to convert Json Format Data to Java Objects==>De-Serialization(We will use it)
  //	"     is used to convert Java Objects to Json Data Format ==>Serialization

// most of time we use not list we use Map(key=value)
	// obj mapper at the end
	
	//import static io.restassured.RestAssured.*; it is used to get from remote

	@Test
	public void get01() {
		
		
			Response response =given().spec(spec01).when().get("/2");
		
		    response.prettyPrint();
		
		//convert Json Data to HashMap
		    
		    HashMap<String,Object> hMap = response.as(HashMap.class);//burada aciladi bunu izlesek iyi olur
		    System.out.println(hMap);
		    //print all keys from json on the console
		    
		    System.out.println(hMap.keySet());
		   //print all values from json on the console

		    
		    System.out.println(hMap.values());
		    
		    //Hard Assertion
		    //Assert that "completed " is false		    
		    assertEquals(false,hMap.get("completed")); 
		    //Assert that "title" is "quis ut nam facilis et officia qui"		    
		    assertEquals("quis ut nam facilis et officia qui", hMap.get("title"));		
		//Assert that "userId"is 1		    
		    assertEquals(1, hMap.get("userId"));
		
		    //soft assertion
		    SoftAssert softAssert = new SoftAssert();
		    
		   softAssert.assertEquals(false,hMap.get("completed"));
		   softAssert.assertTrue(hMap.get("completed").equals(false));// aynisi usttekiyle
		   
		   softAssert.assertTrue(hMap.get("title").equals("quis ut nam facilis et officia qui"));
		 
		   softAssert.assertTrue(hMap.get("userId").equals(1));

		   
		    
		    
		    
		    softAssert.assertAll();
		
	}
}
