package api.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProvidor;
import io.restassured.response.Response;

public class DataDrivenTest {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProvidor.class)
	void createUserWithDataProvidor(String firstName, String lastName) {
		User userPayload = new User();
		
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		//userPayload.setEmail(email);
		
		Response response = UserEndPoints.createUser(userPayload);
		System.out.println(response.asPrettyString());
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 201);
	}
}
