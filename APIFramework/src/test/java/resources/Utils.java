package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	static RequestSpecification request;

	public RequestSpecification requestSpecification() throws IOException {

		if (request == null) {
			PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
			request = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return request;
		}
		return request;
	}

	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\GValchev\\git\\API-Automation-Framework\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response response, String key) {
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		
		return js.get(key);

	}
}
