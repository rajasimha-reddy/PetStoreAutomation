package api.test;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import org.apache.logging.log4j.LogManager;
import io.restassured.response.Response;

public class UserTests {
	
	
	User userPayload;
	Faker faker;
	public Logger logger;
	
	@BeforeClass
	public void setupData() 
	{
		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUserName(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger = LogManager.getLogger(this.getClass());
		
		System.out.println(userPayload.getId());
		System.out.println(userPayload.getUserName());
		System.out.println(userPayload.getFirstName());
		System.out.println(userPayload.getLastName());
		System.out.println(userPayload.getEmail());
		System.out.println(userPayload.getPassword());
		System.out.println(userPayload.getPhone());
	}
	
	@Test(priority = 1)
	public void testPostUser()
	{
		logger.info("*****Creating user*****");
		Response res = UserEndPoints.createUser(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("*****User Created*****");
	}
	
	//@Test(priority = 2)
	public void testGetUserByName()
	{
		logger.info("*****Reading User Info*******");
		System.out.println(userPayload.getUserName());
		Response res = UserEndPoints.readUser(this.userPayload.getUserName());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("*****User Info Displayed*****");
	}
	
	@Test(priority = 3)
	public void testUpdateUserByName()
	{
		logger.info("*****Updating user*****");
		
		userPayload.setFirstName(faker.name().username());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		
		Response res = UserEndPoints.updateUser(userPayload, this.userPayload.getUserName());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("*****User is Updated*****");
		
		System.out.println(userPayload.getId());
		System.out.println(userPayload.getUserName());
		System.out.println(userPayload.getFirstName());
		System.out.println(userPayload.getLastName());
		System.out.println(userPayload.getEmail());
		System.out.println(userPayload.getPassword());
		System.out.println(userPayload.getPhone());
	}
	
	@Test(priority = 4)
	public void testDeleteUserByName()
	{
		logger.info("*****Deleting User*****");
		Response res = UserEndPoints.deleteUser(this.userPayload.getUserName());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("*****User Deleted*****");
	}
	
	
}
