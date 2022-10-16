package Utilities;

import java.util.Random;

public class JavaUtility {
	
	/**
	 * its used to generate the random number with in the range of 1000
	 * @return integer
	 */
	
	public int RandomNumber() {
		
		Random ran = new Random();
		int random = ran.nextInt(1000);
		
		return random;
		
	}

}
