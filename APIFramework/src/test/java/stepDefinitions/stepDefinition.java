package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefinition {
	RequestSpecification request;
	ResponseSpecification responseSpecification;
	Response response;

	@Given("Add Place Payload")
	public void add_place_payload() {
		AddPlace addPlace = new AddPlace();
		Location location = new Location();
		location.setLat(-38.383404);
		location.setLng(-33.427362);

		List<String> listOfTypes = new ArrayList<String>();
		listOfTypes.add("shoe park");
		listOfTypes.add("shop");

		addPlace.setAccuracy(50);
		addPlace.setAddress("address15");
		addPlace.setLanguage("Bulgarian");
		addPlace.setPhone_number("1234567810");
		addPlace.setWebsite("https://website.com");
		addPlace.setName("George");
		addPlace.setTypes(listOfTypes);
		addPlace.setLocation(location);

		RequestSpecification requestSpecification = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();

		responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();

		request = given().spec(requestSpecification).body(addPlace);
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
