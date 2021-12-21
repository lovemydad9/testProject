package Test.Test;

import io.restassured.RestAssured;

public class TestAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\\
		
		RestAssured.given().headers("","").when().get().then().extract().path("", "");
		
		
	}

}
