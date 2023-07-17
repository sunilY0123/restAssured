package methodUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

public class PatchMethod {

	@Test
	   public void postWithString() {
		String str="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		  RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().body(str).post().then().statusCode(201);
	}
	@Test
	   public void readFromFile() throws FileNotFoundException {
		File fil=new File("application\\jsonBody.json");
		FileInputStream fis=new FileInputStream(fil);
		 
		RestAssured.baseURI="https://reqres.in/api/users";
		
		  RequestSpecification req=RestAssured.given();
		 String res=req .body(fis).post().asPrettyString();
		req.then().statusCode(201);
		System.out.println(res);
	}
}







