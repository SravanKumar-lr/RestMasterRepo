package api.endpoints;

/*
 * From Swagger list all the users
 Create User 	POST   https://reqres.in/api/users
 Get User 		GET    https://reqres.in/api/users?page=2
 Update User 	PUT    https://reqres.in/api/users/<id>
 Delete User    DELETE https://reqres.in/api/users/<id>
 
 */

public class Routes {
	
	public static String base_url="https://reqres.in/api";
	
	// User Module (like buyer User)
	public static String post_url= base_url+"/users";
	public static String get_url=base_url+"/users/{userid}";
	public static String update_url=base_url+"/users/{userid}";
	public static String delete_url=base_url+"/users/{userid}";

	// Seller Module
}
