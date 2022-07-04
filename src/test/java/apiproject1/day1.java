package apiproject1;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
	
	
public class day1 {
		@Test(enabled = true,dependsOnMethods={"putRAJESH"})
		public void getRAJESH()
		{
			RestAssured.baseURI="https://petstore.swagger.io/v2/";
			
			given()
			.get("user/Rajesh")
	        .then()
			.statusCode(200).log().all();	
		}
		@SuppressWarnings("unchecked")
		@Test(enabled=true,dataProvider="postData")
		public void postRAJESH(String data)
		{
			RestAssured.baseURI="https://petstore.swagger.io/v2/";
			
		
			given()
			.contentType(ContentType.JSON)
	        .body(data)
			.when()
			.post("user")
			.then()
			.statusCode(200).log().all();
			
		}
		
		@SuppressWarnings("unchecked")
		@DataProvider(name="postData")
	    public Object[][] providerPOST(){
			JSONObject j1 = new JSONObject();
	        j1.put("username", "Rajesh");
	        j1.put("firstName", "chevuru");
	        j1.put("lastName","Rajesh");
	        j1.put("email", "aa@.com");
	        j1.put("password", "Password@123");
	        j1.put("phone","9876543210");
	        j1.put("userStatus","0");
	        Object[][] postData = {
	            {j1.toString()}
	        };
	        return postData;
	    }
		@Test(enabled=true,dataProvider="putData",dependsOnMethods={"postRAJESH"})
		public void putRAJESH(String data)
		{
			RestAssured.baseURI="https://petstore.swagger.io/v2/";
			
		
			given()
			.contentType(ContentType.JSON)
	        .body(data)
			.when()
			.put("user/agnamanum")
			.then()
			.statusCode(200).log().all();
			
		}
		
		@SuppressWarnings("unchecked")
		@DataProvider(name="putData")
	    public Object[][] providerPUT(){
			JSONObject j1 = new JSONObject();
	        j1.put("username", "Rajesh");
	        j1.put("firstName", "chevuru");
	        j1.put("lastName","Rajesh");
	        j1.put("email", "sai@.com");
	        j1.put("password", "password@123");
	        j1.put("phone","9876543210");
	        j1.put("userStatus","0");
	        Object[][] putData = {
	            {j1.toString()}
	        };
	        return putData;
		}
		@Test(enabled=true,dataProvider="deleteData",dependsOnMethods={"putRAJESH"})
		public void deleteRAJESH(String data)
		{
			RestAssured.baseURI="https://petstore.swagger.io/v2/";
			
		
			given()
			.delete("user/"+data)
			.then()
			.statusCode(200).log().all();
			
		}
		@DataProvider(name="deleteData")
	    public Object[][] providerDELETE(){
	        Object[][] deleteData = {{"Rajesh"}};
	        return deleteData;
	    }
		@Test(enabled=true,dataProvider="loginData",dependsOnMethods={"postRAJESH"})
		public void loginRAJESH(String username, String password)
		{
			RestAssured.baseURI="https://petstore.swagger.io/v2/";
			
		
			given()
			.queryParam("username", username)
	        .queryParam("password", password)
			.get("user/login")
			.then()
			.statusCode(200).log().all();
		}
	    @DataProvider(name="loginData")
	    public Object[][] providerLogin(){
	        Object[][] loginData = {{"Rajesh", "password@123"}};
	        return loginData;
	    }

}
