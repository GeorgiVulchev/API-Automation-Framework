package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefinition extends Utils{
	RequestSpecification request;
	ResponseSpecification responseSpecification;
	Response response;
	TestDataBuild data = new TestDataBuild();

	@Given("Add Place Payload")
	public void add_place_payload() {

		responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();

		request = given().spec(requestSpecification()).body(data.addPlacePayload());
	}

	@When("user calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) {
		response = request.when().post("/maps/api/place/add/json").then().spec(responseSpecification).extract()
				.response();
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("the {string} in the response body is {string}")
	public void the_in_the_response_body_is(String keyValue, String expectedValue) {
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		assertEquals(js.get(keyValue).toString(), expectedValue);
	}
}
