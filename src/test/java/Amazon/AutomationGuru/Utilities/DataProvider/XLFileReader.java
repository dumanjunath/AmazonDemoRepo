package Amazon.AutomationGuru.Utilities.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLFileReader {

	
	public static void main(String []args) throws IOException  {

Object a[][] =  getData();
// int i = a.length;
// int j= a[0].length;
 
// int j= a[i].length;
  //System.out.println(i);
// System.out.println(j);
 
 for (int i=0;i<a.length;i++) {
	 for(int j=0;j<a[0].length;j++) {
		// System.out.println("Hello");
		 System.out.println(a[i][j]);
	 }
 }
	} 

  public static Object[][] getData() throws IOException {
	  
		File file = new File(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook xssf = new XSSFWorkbook(fis);
	XSSFSheet sheet=	xssf.getSheet("UserCredentials");
	int rowCount = sheet.getLastRowNum();
	int colCount = sheet.getRow(0).getLastCellNum();
	Object[][] a = new Object[rowCount][colCount];
	System.out.println(rowCount);
	System.out.println(colCount);
//	String Username = sheet.getRow(1).getCell(0).getStringCellValue();
//	String Password = sheet.getRow(1).getCell(1).getStringCellValue();
	//List <String>username  = sheet.get
	System.out.println(sheet.getLastRowNum() );
	for(int i=1;i<=sheet.getLastRowNum();i++) {
		for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
			a[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			System.out.println(a[i-1][j]);
		}
	}
	
	return a;
  }
  
}