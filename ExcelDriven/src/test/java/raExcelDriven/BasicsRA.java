package raExcelDriven;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import Framework.ExcelDriven.DataDriven;
import Framework.ExcelDriven.ReusableMethods;

import io.restassured.path.json.JsonPath;


public class BasicsRA {
	
	
	
	@Test
	public void AddBook() throws IOException
	{
		  DataDriven data=new DataDriven();
		  ArrayList al =data.getData("rest assured");
		  //	ArrayList data=d.getData("RestAddbook","RestAssured"); testcaseName and  sheetname 
		
		HashMap<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("name", al.get(1));
		jsonAsMap.put("isbn", al.get(2));
		jsonAsMap.put("aisle", al.get(3));
		jsonAsMap.put("author", al.get(4));
		RestAssured.baseURI= "http://216.10.245.166";
			Response resp=given().header("Content-Type","application/json").body(jsonAsMap).
			when().post("/Library/Addbook.php").
			then().assertThat().statusCode(200).extract().response();
			 JsonPath js= ReusableMethods.rawToJson(resp);
			 String id=js.get("ID");
			 System.out.println(id);
		   
		   
		
}
}
