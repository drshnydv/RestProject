package pojo;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Serialization2 {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		int[] a = {123,456};
		
		spouse spou = new spouse("ace", "123456789", "ace@a.com", "banglore");
		
		EmpWithSpouse emp = new EmpWithSpouse("abc", a, spou, "banglore");
		
		ObjectMapper obj = new ObjectMapper();
		
		obj.writeValue(new File("./spouse.json"), emp);
		
	}

}