package Utilities;


import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	 /**
	    *   its used to read the data from Excel-Workbook based on below 
	    * @param sheetName
	    * @param rowNum
	    * @param celNum
	    * @return String data
	   * @throws Throwable
    */
	
		public String getExcelData(String sheetName, int row, int col) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./Data/DataDriven.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		String s = wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		
		return s;
		
		}

}