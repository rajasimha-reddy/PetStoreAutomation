package api.test;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DDTests {

	@Test(priority = 1, dataProvider = "data", dataProviderClass = DataProviders.class)
	public void testPostuser(String userId, String userName, String fname, String lname, String userEmail, String pwd, String ph)
	{
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUserName(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(userEmail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteuserByName(String userName)
	{
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
