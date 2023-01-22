package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition {
	@Given("User is on NetBanking landing page")
	public void user_is_on_net_banking_landing_page() {
	    System.out.println("given");
	}
	@When("User login into application with username and password")
	public void user_login_into_application_with_username_and_password() {
		System.out.println("when");
	}
	@Then("Cards are displayed")
	public void cards_are_displayed() {
		System.out.println("then");
	}
}
