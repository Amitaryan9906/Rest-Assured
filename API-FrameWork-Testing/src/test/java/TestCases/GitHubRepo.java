package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Utility.Authentication;
import com.Utility.CommonResFunction;
import com.Utility.CreateUrl;
import com.Utility.playLoadconverting;
import com.restApiBase.BaseClass;

import io.restassured.response.Response;

public class GitHubRepo {

	static String endpoint= CreateUrl.getBaseUrl("/user/repos");
	static String bearerToken=Authentication.getBearerToken();
	static Response response;
	@Test(priority=0)
	public static void createRepository() throws IOException {
		// The firstthing should be able to get the body
		
		String requestPayload = playLoadconverting.generatePlayloadString("createRepo.json");
		response=BaseClass.PostRequest(endpoint, requestPayload,bearerToken );
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
		
		Assert.assertEquals(CommonResFunction.getResponseBody(requestPayload,"name"),CommonResFunction.getResponseBody(responsebody, "name"));
		Assert.assertEquals(CommonResFunction.getStatusCode(response), 201);
	}
}
