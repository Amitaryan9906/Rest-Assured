package Demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TrelloApi {

    //	End pouint of trello

	public static String baseUrl = "https://api.trello.com";
	public static String token = "ATTAc9523160cd9d918d3b41b8834918024e86cadca8e57f408b8b9766f17c3a21af9BC3A426";
	public static String key = "0db963d80ffc2a5f2002f14a8fbd46bf";
	public static String id;
	
	@Test
	public void CreateaBoard() {
    
		// This sets the base URI for all API requests
		RestAssured.baseURI = baseUrl;
		
		// This sets up the pre-conditions for the API request
		Response res=
		given()
		    .queryParam("name", "masai")
		    .queryParam("key", key)
		    .queryParam("token", token)
		    .header("Content-Type", "application/json")
		.when()
		    .post("/1/boards")
		.then()
		    .assertThat()
		    .statusCode(200).contentType(ContentType.JSON).extract().response();
		
		String jsonresponse=res.asString();
//		 The below code will change code to json
		JsonPath js = new JsonPath(jsonresponse);
		id=js.get("id");
		System.out.println(id);
	}
}
