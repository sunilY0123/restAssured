package Autorization;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken {
	@Test
	public void preemptive() {
	//	String bearer="";
		RestAssured.baseURI="https://gorest.co.in/public/v2/users";
		Response res=RestAssured.given().get();
		String str=res.asPrettyString();
//		JSONObject payload=new JSONObject();
//		payload.put("name","sunil");
//		payload.put("job", "cricketer");
//		payload.put("hobby", "cricket");
//		req.headers("",).
		System.out.println(str+res.statusCode());
}

	
	
	
	
	
	
	
	
	
}