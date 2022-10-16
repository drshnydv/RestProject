package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	Driver driver;
	Connection connection;
	ResultSet result;
	int result1;
	
	/**
	 * This method will perform the mysql database connection
	 * @throws SQLException 
	 */
	
	public void connectDb() throws SQLException {
		
		
		try {
			
			driver = new Driver();
			
			DriverManager.registerDriver(driver);
			
			connection = DriverManager.getConnection(IConstants.JDBC_URL_String,IConstants.JDBC_USERNAME,IConstants.JDBC_PASSWORD);
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * This method will close the mysql database
	 * @throws SQLException
	 */
	
	public void closeDb() throws SQLException {
		
		try {
			
			connection.close();
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * This method will execute the query
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	
	public ResultSet executeQuery(String query) throws Throwable {
		
		result = connection.createStatement().executeQuery(query);
		
		return result;
	}
	
	public int updateQuery(String query) throws Throwable {
		
		result1 = connection.createStatement().executeUpdate(query);
		
		return result1;
	}
	
	/**
	 * This method will execute querry based on querry and it will verify the data. 
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	
	public void executeQueryAndValidate(String query, int columnIndex, String expectedData) throws Throwable {
		
		result = connection.createStatement().executeQuery(query);
		
		boolean flag = false;
		
		while(result.next()) {
			
			if(result.getString(columnIndex).equals(expectedData)) {
				
				flag = true;
				break;
				
			}
			
		}
		
		if(flag) {
			
			System.out.println(expectedData + " => Data Present in DataBase");
			
		}
		
		else {
			
			System.out.println(expectedData + " => Data NotPresent in DataBase");
			
		}
		
	}

}