package methodUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.apache.groovy.json.internal.BaseJsonParser;
import org.apache.groovy.json.internal.JsonParserLax;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.json.JsonParser;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetMethod {
	private static final String JSONArray = null;
	FileInputStream fis=null;
	RequestSpecification req;

	@Test
	public void get1() {
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		RestAssured.given().get().then().statusCode(200);


	}

	@Test
	public void get2() {
		req=RestAssured.given();
		req.baseUri("https://reqres.in");
		req.basePath("/api/users?page=2");

		Response res=req.get();
		System.out.println(res.asPrettyString());
	}

	@Test
	public void getData() throws FileNotFoundException {
		File fil=new File("application\\get.json");
		fis=new FileInputStream(fil);
		req=RestAssured.given();
		req.baseUri("https://reqres.in");
		req.basePath("/api/users?page=2");
		Response res=req.get();
		String str=res.getBody().asPrettyString();
		Assert.assertEquals(str.contains("Tracey"),true,"failed============");

	}
	@Test
	public void getDataFromJsonPath() throws FileNotFoundException {
		File fil=new File("application\\get.json");
		fis=new FileInputStream(fil);
		req=RestAssured.given();
		req.baseUri("https://reqres.in");
		req.basePath("/api/users?page=2");
		Response res=req.get();

		JsonPath js= res.jsonPath();
		String str=js.get("data[5].first_name");

		Assert.assertEquals(str,"Tracey" );
	}
	@Test
	public void readDataByJsonObject() throws IOException {
		String file="application\\jsonBody.json";
		Path ph=Paths.get(file);

		byte[] bt=Files.readAllBytes(ph);
		String 	str=new String(bt);	
		JSONObject jsObj=new JSONObject(str);
		String name=jsObj.getString("name");
		String hob=jsObj.getString("hobby");
		System.out.println(name+"======"+hob);
     JSONArray jarr=jsObj.getJSONArray("properties");
     for (int i = 0; i < jarr.length(); i++) {
		JSONObject str1=jarr.getJSONObject(i);
		System.out.println(str1.getString("type"));
		System.out.println(str1.getString("name"));
		System.out.println(str1.getString("value"));
	}
	}
	
	
	@Test
	public void readData() throws IOException, ParseException {
	//	String file="application\\Agile.postman_collection.json";

//		JSONObject jObj1=new JSONObject();
//		jObj1.put("_postman_id", "75f8d642-b0dc-4536-9a21-372516882ae7");
//		JSONObject jObj2=new JSONObject();
//		jObj2.put("info",jObj1);
//		System.out.println(jObj2);
//		JSONObject jObj=new JSONObject();
//		JSONArray jsonarr=jObj.getJSONArray();
//			String js=jsonarr.get("item");
//			System.out.println(js);
		
		JSONParser jpa= new JSONParser();
		FileReader file=new FileReader("application//Agile.postman_collection.json");
		Object obj = jpa.parse(file);
        JSONObject jsonObject = (JSONObject)obj;
        JSONArray ja =(JSONArray)jsonObject.get("item");
	for (int i = 0; i < ja.length(); i++) {
		JSONObject jo=(JSONObject)ja.get(i);
		String str=(String)jo.get("name");
		System.out.println(str);
	}
		
		
		
		
		
		
		
		
	}
	@Test
	public void validateHeader() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		Response res=RestAssured.given().get();
		String str= res.getHeader("Connection");

		Assert.assertEquals(str,"keep-alive");


	}

	@Test
	public void getQueryParam() {

		RestAssured.baseURI="https://reqres.in/api/users";

		Response res=RestAssured.given().queryParam("page",2).get();
		String resbody=res.getBody().asPrettyString();
		System.out.println(resbody);
		String str=res.jsonPath().get("data[1].avatar");
		Assert.assertEquals(str, "https://reqres.in/img/faces/8-image.jpg");

	}







}