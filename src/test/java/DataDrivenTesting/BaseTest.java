package DataDrivenTesting;

import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.restapi.extent.ExtentManager;
import com.restapi.extent.ExtentReport;

public class BaseTest {
	
	protected StringWriter writer;
	protected PrintStream captor;
	
	
	@BeforeSuite
	public void beforesuite()
	{
		ExtentReport.initextentreport();
	}

	@BeforeMethod
	public void setup()
	{
		writer = new StringWriter();
		captor = new PrintStream(new WriterOutputStream(writer), true);
	}
	
	public String generateStringFromResource(String path) throws IOException {
		String temp="";
		try {
			temp= new String(Files.readAllBytes(Paths.get(path)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return temp;

	}
	
	public void writeRequestAndResponseInReport(String request,String response) {

		ExtentManager.getExtentTest().info("---- Request ---");
		formatAPIAndLogInReport(request);
		ExtentManager.getExtentTest().info("---- Response ---");
		formatAPIAndLogInReport(response);
	}
	
	
	protected void formatAPIAndLogInReport(String content) {

		String prettyPrint = content.replace("\n", "<br>");
		ExtentManager.getExtentTest().info("<pre>" + prettyPrint + "</pre>");

	}

	
	
	
	@AfterSuite
	public void aftersuite()
	{
		ExtentReport.flushReporter();
	}
}
