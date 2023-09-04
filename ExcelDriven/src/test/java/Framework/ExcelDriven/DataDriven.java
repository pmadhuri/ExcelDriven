package Framework.ExcelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	public ArrayList getData(String testcaseName) throws IOException {
		ArrayList<String> a=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("C:\\Users\\Sandeep\\Desktop\\MadhuriStudyMaterials\\Practice_sheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row>    rows= sheet.iterator();
				 Row  firstRow=rows.next();
				 Iterator<Cell> ce=firstRow.cellIterator();
				   int column=0;
				   int k=0;
				   //0,1,2,3,4 column
				   while(ce.hasNext()) {
					      Cell value=ce.next();
					 if(value.getStringCellValue().equalsIgnoreCase("testcase")) {
						 column=k;  
						   }
					   k++;
				   }
				   System.out.println(column +"    "+"sheet index");
				   //****************************row purchase get all  data****************
					 while(rows.hasNext()) {
						 Row row=rows.next(); 
						 if(row.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
							 Iterator<Cell> ce1=row.cellIterator();
							 while(ce1.hasNext()) {
								 Cell cvalue=ce1.next();
								 if(cvalue.getCellType()==CellType.STRING)
								 {
								 a.add(cvalue.getStringCellValue()); 
								 }else
								 {
									 a.add(NumberToTextConverter.toText(cvalue.getNumericCellValue()));
									  }
								  }
							 
							  }
						  }

			}//if
		}//for loop
		
		
		return a;	
	}

	public static void main(String[] args) throws IOException {
		}

}
