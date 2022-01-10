package utilities;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
//ObjectMapper is a class, it is used to serialization ar de-serialization like GSON

public class JsonUtil {
	// after adding dependcy to pomm file then you should save and update
	private static ObjectMapper mapper;
	//static =common,to reach class name
	
	static {
		mapper =new ObjectMapper();
	}
	//1.Method is for "serilization" (Convert Java Object yo Json)

	public static String convertJavaToJson(Object obj) {
	//ObjectMapper is a class ,it is used to serialization or de-serialization like GSON
  		//non primitive we use as obj and variable '>String s = "A";
		String jsonResult = "";
		
		try {
			jsonResult = mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {//
			System.out.println("Object could not be converted to Json");
		} catch (JsonMappingException e) {//
			System.out.println("Object could not be converted to Json");

		} catch (IOException e) {
			System.out.println("Object could not be converted to Json");

		}
		return jsonResult;
	}







	//2.Method is for "de-serilization" (Convert Json to Java Object )
	//Generic Method:You will decide return type when you use the method

	public static <T> T convertJsonToJava(String json, Class<T> cls) {
		T javaResult = null;
		
	
		try {
			javaResult = mapper.readValue(json, cls);
		} catch (JsonParseException e) {//converting exeption
			System.out.println("Could not convert Json to Java Object" + e.getMessage());
		} catch (JsonMappingException e) {//if no Json to convert
			System.out.println("Could not convert Json to Java Object" + e.getMessage());

		} catch (IOException e) {
			System.out.println("Could not convert Json to Java Object" + e.getMessage());

		}

		return javaResult;
		
		
		
	}
//		
//	}



	}







