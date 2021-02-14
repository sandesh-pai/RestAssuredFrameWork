package DataDrivenTesting;

import com.aventstack.extentreports.Status;
import com.restapi.extent.ExtentManager;

import io.restassured.response.Response;
import junit.framework.Assert;

public class validationSuite {
	
	
	
	public static void validateStatusCode(Response response, int expectedstatuscode)
	{
		ExtentManager.getExtentTest().info("valiadating status code");
		String actualStatuscode = String.valueOf(response.getStatusCode());
	     ExtentManager.getExtentTest().log(Status.INFO, " Actual status code is " + actualStatuscode);
	       Assert.assertEquals(response.getStatusCode(), expectedstatuscode);	
	}
	
   // public static void validate
	
	
	

}
