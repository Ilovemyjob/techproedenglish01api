package techproedenglish01.techproedenglish01api;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import utilities.JsonUtil;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class ObjectMapperTestWithMap extends TestBaseDt{



	//1-Serialization : Convert Java to Json

	@Test
	public void javaToJson() {
		Map<Integer, String> map = new HashMap<>();
		map.put(101, "Mark");
		map.put(102, "Angie");
		map.put(103, "Alexandre");

		map.put(104, "Ted");
		System.out.println(map);
		//{101=Mark, 102=Angie, 103=Alexandre, 104=Ted}    ==Map
		
		String jsonFromMap = JsonUtil.convertJavaToJson(map);
		
		System.out.println(jsonFromMap);
		
	//	{"101":"Mark","102":"Angie","103":"Alexandre","104":"Ted"}  == Json
		
		
		
		
		//2.De-Serialization: Let's convert jsonFromMap to Java Object(Map) again

		
		
		Map<Integer, String> mapFromJson = JsonUtil.convertJsonToJava(jsonFromMap, Map.class);


		System.out.println(mapFromJson);
		//{101=Mark, 102=Angie, 103=Alexandre, 104=Ted} ==Map

	}
	
		@Test
		public void jsonFromApiToJava() {
			/*
			 * 1-Use get method with spec01
			 * 2-Add path param "1" to spec01
			 * 3-After getting Json Response Body convert it to a Map
			 *4)Assert status code, response body details, use hard assertion

			 */
			
			
			spec01.pathParam("id", 1);
			
			Response response = given().spec(spec01).when().get("/{id}");
			
			response.prettyPrint();
			
			/*
			 {
    "userId": 1,
    "id": 1,
    "title": "delectus aut autem",
    "completed": false
				}
			 */
			
			
			//we use Object Mapper to convert
//we can convert by using Gson ==HashMap<String,Object> hMap = response.as(HashMap.class);
			Map<String,Object> mapFromJsonApi = JsonUtil.convertJsonToJava(response.asString(), HashMap.class);
			
			System.out.println(mapFromJsonApi);
			//{id=1, completed=false, title=delectus aut autem, userId=1}
			
			
			Map<String, Object> mapForExpectedValues = new HashMap<>();
			mapForExpectedValues.put("userId", 1);
			mapForExpectedValues.put("id", 1);

			mapForExpectedValues.put("title", "delectus aut autem");

			mapForExpectedValues.put("completed", false);

			
			
			
			
			
			//Hard Assertion
			
			response.then().assertThat().statusCode(200);
			
			assertEquals(mapForExpectedValues.get("userId"), mapFromJsonApi.get("userId"));
			assertEquals(mapForExpectedValues.get("id"), mapFromJsonApi.get("id"));
			assertEquals(mapForExpectedValues.get("title"), mapFromJsonApi.get("title"));
			assertEquals(mapForExpectedValues.get("completed"), mapFromJsonApi.get("completed"));

			
			
			
			
			
			
		}
	






















}