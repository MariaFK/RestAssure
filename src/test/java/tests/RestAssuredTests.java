package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.*;
import org.testng.annotations.Test;


public class RestAssuredTests {

    @Test
    public void updateUserTest() {
        UpdateUserModel updateBody = PrepareUserUpdate.getValidData();

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .and()
                .body(updateBody)
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteUserTest() {
        RestAssured
                .given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204);
    }

    @Test
    public void createNewUserSuccessfullyTest() {
        RegisterUserModel createBody = PrepareRegisterUserDate.getValidData();

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .and()
                .body(createBody)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(200);
    }

    @Test
    public void createNewUserUnsuccessfullyTest() {
        RegisterUserModel createBody = RegisterUserModel
                .builder()
                .email("sydney@fife")
                .build();

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .and()
                .body(createBody)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(400);
    }

    @Test
    public void loginSuccessfullyTest() {
        LoginModel loginData = LoginModel
                .builder()
                .email("eve.holt@reqres.in")
                .password("cityslicka")
                .build();

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .and()
                .body(loginData)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200);
    }

    @Test
    public void loginUnsuccessfullyTest() {
        LoginModel loginData = LoginModel
                .builder()
                .email("peter@klaven")
                .build();

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .and()
                .body(loginData)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(400);
    }


    @Test
    public void delayedResponseTest() {
        RestAssured
                .given()
                .when()
                .get("https://reqres.in/api/users?delay=3")
                .then()
                .statusCode(200);
    }

}
