package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// This file contains methods to perform CRUD operations
public class UserEndPoints {

	public static Response createUser(User payload) {
		Response res = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
			.when()
				.post(Routes.post_url);
		return res;
	}
	
	public static Response readUser(int userid) {
		Response res = given()
				.pathParam("userid", userid)
			.when()
				.get(Routes.get_url);
		return res;
	}
	
	public static Response updateUser(User payload,int userid) {
		Response res = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("userid", userid)
				.body(payload)
			.when()
				.put(Routes.update_url);
		return res;
	}
	
	public static Response deleteUser(int userid) {
		Response res = given()
				.pathParam("userid", userid)
			.when()
				.delete(Routes.get_url);
		return res;
	}
}
