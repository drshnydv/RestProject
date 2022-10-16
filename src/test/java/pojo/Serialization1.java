package pojo;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Serialization1 {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		String[] a= {"123","456"};
		
		EmpWithArray emp = new EmpWithArray("cdf", 456, a, "cdf@b.com", "benglore");
		
		ObjectMapper obj = new ObjectMapper();
		
		obj.writeValue(new File("./emp1.json"), emp);
		
	}

}
