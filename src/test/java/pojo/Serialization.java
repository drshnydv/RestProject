package pojo;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Serialization {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		Emp emp = new Emp("abc", 123, "123456789", "abc@a.com", "banglore");
		
		ObjectMapper obj = new ObjectMapper();
		
		obj.writeValue(new File("./Emp.json"), emp);
		
	}

}