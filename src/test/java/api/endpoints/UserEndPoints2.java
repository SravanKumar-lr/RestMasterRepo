package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// This file contains methods to perform CRUD operations
public class UserEndPoints2 {

	// method to load the properties file
	public static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}

	public static Response createUser(User payload) {
		String postURL = getURL().getString("post_url");
		Response res = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(payload).when()
				.post(postURL);
		return res;
	}

	public static Response readUser(int userid) {
		String getURL = getURL().getString("get_url");
		Response res = given().pathParam("userid", userid).when().get(getURL);
		return res;
	}

	public static Response updateUser(User payload, int userid) {
		String putURL = getURL().getString("update_url");
		Response res = given().accept(ContentType.JSON).contentType(ContentType.JSON).pathParam("userid", userid)
				.body(payload).when().put(putURL);
		return res;
	}

	public static Response deleteUser(int userid) {
		String deleteURL = getURL().getString("delete_url");
		Response res = given().pathParam("userid", userid).when().delete(deleteURL);
		return res;
	}
}
