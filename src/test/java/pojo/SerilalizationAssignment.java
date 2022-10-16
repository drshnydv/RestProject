package pojo;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SerilalizationAssignment {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		long[] a = {123,456};
		long[] b = {456,789};
		
		Relation re = new Relation("abc", "def", a, "banglore");
		
		Contacts con = new Contacts("Darshan", "Yadav", "TYSS", b, "TYSS.com", "abc@a.com", "banglore", "25-10-96", "abc", re);
		
		ObjectMapper obj = new ObjectMapper();
		
		obj.writeValue(new File("./SerilalizationAssignment.json"), con);
		
	}

}
