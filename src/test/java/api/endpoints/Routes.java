package api.endpoints;

/*
Swagger URI --> https://petstore.swagger.io

Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/{userName}
Update user (Put): https://petstore.swagger.io/v2/user/{userName}
Delete user (Delete): https://petstore.swagger.io/v2/user/{userName}
	
*/


public class Routes {

	public static String base_Url = "https://petstore.swagger.io/v2";
	
	//User module
	public static String post_Url = base_Url + "/user";
	public static String get_Url = base_Url + "/user/{username}";
	public static String update_Url = base_Url + "/user/{username}";
	public static String delete_Url = base_Url + "/user/{username}";
	
	//Store module
	
		//Here you will create store module URL's
	
	//Pet module
	
		//Here you will create pet module URL's
}
