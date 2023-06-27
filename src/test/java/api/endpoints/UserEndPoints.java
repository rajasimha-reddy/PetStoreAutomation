package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//Created to perform Create, Read, Update, Delete Operations

public class UserEndPoints {

	public static Response createUser(User payload)
	{
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_Url);
		return res;
	}
	
	
	public static Response readUser(String userName)
	{
		Response res = given()
				.pathParam("username", userName)
			.when()
				.get(Routes.get_Url);
		return res;
	}
	
	public static Response updateUser(User payload, String userName)
	{
		
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(Routes.update_Url);
		return res;
	}
	
	public static Response deleteUser(String userName)
	{
		Response res = given()
			.pathParam("username", userName)
		.when()
			.delete(Routes.delete_Url);
		return res;
	}
}
