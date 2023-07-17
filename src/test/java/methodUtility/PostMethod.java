package methodUtility;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostMethod {
	
	@Test
   public void updateData() {
	   RestAssured.baseURI="https://reqres.in/api/users";
	RestAssured.given().post().then().statusCode(200);
	
	}	
	@Test
	public void updateDataFromJsonObject() {
		JSONObject data=new JSONObject();
		data.put("name","sunil");
		data.put("job","teacher");
		data.put("hobby","cricket");
		   RestAssured.baseURI="https://reqres.in/api/users";

	Response res=RestAssured.given().header("content-type","application/json").body(data.toJSONString())
	.post();
	System.out.println(res.asPrettyString());
	Assert.assertEquals(res.statusCode(), 201);
	
}
	
}