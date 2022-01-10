package techproedenglish01.techproedenglish01api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.tools.ant.util.JavaEnvUtils;
import org.hamcrest.Matchers;



import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import groovyjarjarpicocli.CommandLine.Spec;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.AssertionSupport;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.JsonUtil;

public class Deneme extends TestBaseDt {


    	
	@Test
	public void get() {
		
		spec02.pathParam("id", 1);
		
		Map<String, String> expectedData = new HashMap<>();
		expectedData.put("Server", "Cowboy");
		expectedData.put("Content-Type", "text/plain; charset=utf-8");
		expectedData.put("Via", "1.1 vegur");
		expectedData.put("trueBodyText", "Not Found");
		expectedData.put("wrongBodyText", "JavaApi");

			Response response =given().spec(spec02).when().get("/{id}");
		
		response.then().assertThat().statusCode(404).headers("Server",expectedData.get("Server"));
		
		assertTrue(response.asString().contains(expectedData.get("trueBodyText")));
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(response.getHeader("server"), expectedData.get("server"));
		
		
		
		softAssert.assertAll();
		
		
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
	
		
		
		
	
		
		
				

 
 	
	
	}
		
	
}
