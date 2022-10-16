package pojo;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Deserilation1 {
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper obj = new ObjectMapper();
		
		Contacts a = obj.readValue(new File("./Assignment.json"), Contacts.class);
		
		System.out.println(a.getDob());
		System.out.println(a.relation);
		
	}

}