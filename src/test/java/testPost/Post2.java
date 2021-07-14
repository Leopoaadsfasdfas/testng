package testPost;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;



public class Post2  {
    Map<String,Object>map=new HashMap<String,Object>();
    @Test(invocationCount=100)

	public void testPostUser() {

		  RestAssured.baseURI="https://reqres.in/api";
 
	       map.put("name", "Alejandra");
	       map.put("job", "Costumer Succes");
	       
	             given()
	    	    .log().all()
	    		.body(map.toString())
	      		.when()
	      		.post("/users")
	      		.then()
	      		.log().all()
	      		.statusCode(201);
	      	
	    
	}
	}

