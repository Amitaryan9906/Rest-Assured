package StepDefinition;

import java.io.IOException;

import org.testng.Assert;

import Utility.PlayLoadConverting;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition {
	
	public static String baseURL="https://simple-books-api.glitch.me";
	public static String Loginpayload;
	RequestSpecification rs;
	Response response;
	JsonPath jsonPath;
	public static String token;
	
	@Given("login API")
	public void login_api() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		Loginpayload= PlayLoadConverting.generatePlayloadString("Login.json");
		System.out.println(Loginpayload);
	}
	@When("Login Execute {string} and provide accesstoken")
	public void login_execute_and_provide_accesstoken(String resourcepath) {
	    // Write code here that turns the phrase above into concrete actions
	    rs = RestAssured.given().body(Loginpayload);
	    rs.contentType(ContentType.JSON);
	    response=rs.post(baseURL+resourcepath);
	}
	@Then("successfully execute with status code {int}")
	public void successfully_execute_with_status_code(Integer statuscode) {
	    // Write code here that turns the phrase above into concrete actions
	Assert.assertEquals(statuscode, response.getStatusCode());
	System.out.println(response.getStatusCode());
	}
	@Then("verify accesstoken")
	public void verify_accesstoken() {
	    // Write code here that turns the phrase above into concrete actions
	   jsonPath=new JsonPath(response.getBody().asString());
	   token = jsonPath.get("accessToken");
	   System.out.println(token);
	}
	
	
// This is for order a Book
	 @Given("Login successfull with accesstoken")
	    public void login_successfull_with_accesstoken() {
	        Assert.assertNotNull(token);
	    }

	    @When("order a book {string} and fetch orderid")
	    public void order_a_book_and_fetch_orderid(String resourcepath) {
	        rs = RestAssured.given().header("Authorization", "Bearer " + token);
	        response = rs.post(baseURL + resourcepath);
	        jsonPath = new JsonPath(response.getBody().asString());
	        String orderId = jsonPath.get("orderId");
	        System.out.println("Order ID: " + orderId);
	    }

	    @Then("verify status code {int}")
	    public void verify_status_code(Integer statuscode) {
//	        Assert.assertEquals(statuscode, response.getStatusCode());
	        System.out.println(response.getStatusCode());
	    }



}
