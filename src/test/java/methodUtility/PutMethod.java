package methodUtility;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PutMethod {

	@Test
	   public void post() {
		   RestAssured.baseURI="https://reqres.in/api/users/2";
		RestAssured.given().put().then().statusCode(200);
		
	}		
}
