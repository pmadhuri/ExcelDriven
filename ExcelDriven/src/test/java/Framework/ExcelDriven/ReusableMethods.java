package Framework.ExcelDriven;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
public class ReusableMethods {
	

	public static JsonPath rawToJson(Response res) {
		String respon=res.asString();
		JsonPath x=new JsonPath(respon);
		System.out.println(respon);
		return x;
	}

}
