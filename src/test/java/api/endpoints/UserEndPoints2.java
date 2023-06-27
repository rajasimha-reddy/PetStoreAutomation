package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//Created to perform Create, Read, Update, Delete Operations

public class UserEndPoints2 {
	
	//additional method for getting URL's from properties file
	public static ResourceBundle getUrl() 
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes"); //Load Properties File
		return routes;
	}
	
	
	public static Response createUser(User payload)
	{
		String post_Url = getUrl().getString("post_url");
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_Url);
		return res;
	}
	
	
	public static Response readUser(String userName)
	{
		String get_Url = getUrl().getString("get_url");
		Response res = given()
				.pathParam("username", userName)
			.when()
				.get(get_Url);
		return res;
	}
	
	public static Response updateUser(User payload, String userName)
	{
		String update_Url = getUrl().getString("update_url");
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(update_Url);
		return res;
	}
	
	public static Response deleteUser(String userName)
	{
		String delete_Url = getUrl().getString("delete_url");
		Response res = given()
			.pathParam("username", userName)
		.when()
			.delete(delete_Url);
		return res;
	}
}
