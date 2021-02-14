package DataDrivenTesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapi.annotation.FrameworkAnnotation;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import jdk.internal.net.http.common.Log;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class createNewUser extends BaseTest{

	
	@FrameworkAnnotation(author = { "sandesh" })
	@Test
	public void createuser(Map<String, String>map) {
		RestAssured.baseURI = "https://reqres.in";
	
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", map.get("name"));
		data.put("job", map.get("job"));
		
		
	JSONObject requestprovider = new JSONObject();
	requestprovider.put("name", map.get("name"));
	requestprovider.put("job", map.get("job"));
	
 Response response = given().filter(new RequestLoggingFilter(captor)).log().all().body(data).header("Content-Type","application/Json").
		when().post("/api/users").then().log().all().extract().response();
 
 
 
 writeRequestAndResponseInReport(writer.toString(), response.prettyPrint());
 validationSuite.validateStatusCode(response, 204);
		
		
	}
	
}
