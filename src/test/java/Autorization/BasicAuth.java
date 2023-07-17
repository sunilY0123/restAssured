package Autorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicAuth {

	@ Test
	public void preemptive() {
	RestAssured.baseURI="http://postman-echo.com/basic-auth";
	Response res=RestAssured.given().auth().preemptive().basic("postman","password").get();
	
	System.out.println(res.statusCode());
	}
	@Test
	public void nonPreemptive() {// by default basic auth
		RestAssured.baseURI="http://postman-echo.com/basic-auth";
		Response res=RestAssured.given().auth().basic("postman","password").get();
		
		System.out.println(res.statusCode());	
		
		
		
	}
	
	
	
	
	
}
