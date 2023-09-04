package raExcelDriven;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import java.util.HashMap;

import org.testng.annotations.Test;

import Framework.ExcelDriven.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RAPractice {
	
	//**************use latest dependency for rest assured.**********************
	@Test
	public void AddBook() throws IOException
	{
		HashMap<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("name","as");//John/aldata.get(1)
		jsonAsMap.put("isbn", "sjjh");
		jsonAsMap.put("aisle", "vb");
		jsonAsMap.put("author", "dh");
		RestAssured.baseURI= "http://216.10.245.166";
		Response resp=given().header("Content-Type","application/json").
		body(jsonAsMap).
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		extract().response();
		 JsonPath js= ReusableMethods.rawToJson(resp);
		   String id=js.get("ID");
		   System.out.println(id);
	}

	

}
