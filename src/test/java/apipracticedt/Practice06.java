package apipracticedt;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import techproedenglish01.techproedenglish01api.TestBaseDt;

public class Practice06 extends TestBaseDt {
	/*
	1)Create base url in TestBase Class for "http://api.agromonitoring.com"
	2)Set the URL to "http://api.agromonitoring.com/agro/1.0/polygons?appid=2cb6803f295233aa579843d9e45599f2"
	by using pathParams() and queryParams() methods
	3)Request Body is: {
	"name":"Polygon Sample",
	"geo_json":{
	"type":"Feature",
	"properties":{},
	"geometry":{
	"type":"Polygon",
	"coordinates":[
	[
	[-121.1958,37.6683],
	[-121.1779,37.6687],
	[-121.1773,37.6792],
	[-121.1958,37.6792],
	[-121.1958,37.6683]
	]
	]
	}
	}
	}
	4)Create POST Request to "http://api.agromonitoring.com/agro/1.0/polygons?appid=2cb6803f295233aa579843d9e45599f2"
	Print the response body on the console
	5)Assert Status Code (201) and Response Body details by using body() method  
	6)Assert Response Body details by using Soft Assert                   
	*/
	@Test
	public void postPractice() {
		//Set endpoint
		spec06.pathParams("agro", "agro",
				          "id",1.0,
				          "polygons", "polygons").
		       queryParam("appid", "2cb6803f295233aa579843d9e45599f2");
		
		//Create Request Body
		float coordinates[][][] = { { {-121.1958f,37.6683f}, {-121.1779f,37.6687f}, {-121.1773f,37.6792f}, {-121.1958f,37.6792f}, {-121.1958f,37.6683f} } };
		
		Map<String, Object> geometry = new HashMap<>();
		geometry.put("type", "Polygon");
		geometry.put("coordinates", coordinates);
		
		Map<String, String> properties = new HashMap<>();
		
		Map<String, Object> geo_json = new HashMap<>();
		geo_json.put("type", "Feature");
		geo_json.put("properties", properties);
		geo_json.put("geometry", geometry);
		
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("name", "Polygon Sample");
		reqBody.put("geo_json", geo_json);
		
		//float center[]= {-121.1867f,37.67385f};
		
		
		//Send POST Request
		Response response = given().
				               contentType(ContentType.JSON).//it is not must but i must read documantation
				               spec(spec06).
				               body(reqBody).
				            when().
				               post("/{agro}/{id}/{polygons}");
		response.prettyPrint();
		
		//Hard Assertion with body()
		response.
		     then().
		     assertThat().
		     statusCode(201).
		     contentType(ContentType.JSON).//
		     body("geo_json.geometry.coordinates[0][0][0]", Matchers.equalTo(coordinates[0][0][0]),
		    		 "geo_json.geometry.coordinates[0][0][1]", Matchers.equalTo(coordinates[0][0][1]),
		    		 "geo_json.geometry.coordinates[0][1][0]", Matchers.equalTo(coordinates[0][1][0]),
		    		 "geo_json.geometry.coordinates[0][1][1]", Matchers.equalTo(coordinates[0][1][1]),
		    		 "geo_json.geometry.coordinates[0][2][0]", Matchers.equalTo(coordinates[0][2][0]),
		    		 "geo_json.geometry.coordinates[0][2][1]", Matchers.equalTo(coordinates[0][2][1]),
		    		 "geo_json.geometry.coordinates[0][3][0]", Matchers.equalTo(coordinates[0][3][0]),
		    		 "geo_json.geometry.coordinates[0][3][1]", Matchers.equalTo(coordinates[0][3][1]),
		    		 "geo_json.geometry.coordinates[0][4][0]", Matchers.equalTo(coordinates[0][4][0]),
		    		 "geo_json.geometry.coordinates[0][4][1]", Matchers.equalTo(coordinates[0][4][1]),
		    		 "geo_json.type",Matchers.equalTo(geo_json.get("type")),
		    		 "geo_json.properties",Matchers.equalTo(properties),
		    		 "geo_json.geometry.type",Matchers.equalTo(geometry.get("type")),
		    		 "name",Matchers.equalTo(reqBody.get("name")));
		
		JsonPath json = response.jsonPath();
		
	//	assertEquals(reqBody.get(key), json.getString("name"));
		
		
		assertEquals(coordinates[0][0][0], json.get("geo_json.geometry.coordinates[0][0][0]"));
		assertEquals(coordinates[0][0][1], json.get("geo_json.geometry.coordinates[0][0][1]"));
		
		assertEquals(geo_json.get("type"),json.get("geo_json.type"));
		assertEquals(properties,json.get("geo_json.properties"));
		assertEquals(geometry.get("type"),json.get("geo_json.geometry.type"));

		assertEquals(reqBody.get("name"),json.get("name"));

//		assertEquals(properties,json.get("geo_json.properties"));
//
//		assertEquals(properties,json.get("geo_json.properties"));

			SoftAssert softAssert = new SoftAssert();
			
			softAssert.assertEquals(json.get("geo_json.geometry.coordinates[0][0][0]"), coordinates[0][0][0]);
			softAssert.assertEquals(json.get("geo_json.geometry.coordinates[0][0][1]"), coordinates[0][0][1]);

			softAssert.assertEquals(json.get("geo_json.geometry.coordinates[0][0][0]"), coordinates[0][0][0]);

			softAssert.assertEquals(json.get("geo_json.geometry.coordinates[0][0][0]"), coordinates[0][0][0]);


			
		

			

	
	
	
	
	}
}
