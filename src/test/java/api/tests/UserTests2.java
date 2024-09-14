package api.tests;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserTests2 {

	Faker faker;
	User userPayload;
	static int userid;
	public Logger logger;
	
	@BeforeClass
	public void setupData() {

		faker = new Faker();
		userPayload = new User();
		

		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		
		// for logging
		logger = LogManager.getLogger(this.getClass());
	}

	@Test(priority = 1)
	public void createUserTest() {
		
		logger.info("***** User Creation *****");

		Response response = UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 201);
		userid = response.jsonPath().getInt("id");
		System.out.println("New userId is: " + userid);
		
		logger.info("***** User Creation activity is completed *****");

	}

	@Test(priority = 2)
	public void getUserDetailsTest() {
		System.out.println("userId is: " + userid);
		Response response = UserEndPoints2.readUser(userid);
		response.then().log().all();
		/*
		 * Assert.assertEquals(response.statusCode(), 200);
		 * Assert.assertEquals(response.jsonPath().getInt("id"), userid);
		 */
	}

	@Test(priority = 3)
	public void updateUserTest() {
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());

		Response response = UserEndPoints2.updateUser(userPayload, userid);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("userId is: " + userid);
	}

	@Test(priority = 4)
	public void deleteUserTest() {
		System.out.println("userId is: " + userid);
		Response response = UserEndPoints2.deleteUser(userid);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 204);

	}
}
