package api;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserResponses {
    static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    static final String AUTH_PATH = "/api/auth";

    public void delete(String accessToken) {
        given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .auth().oauth2(accessToken)
                .delete("/api/auth/user");
    }
    public String register(UserRegistration user) {
        ValidatableResponse response =  given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(user)
                .post(AUTH_PATH + "/register")
                .then().log().all();
        return response.extract().path("accessToken");
    }
    public String login(UserLogin user) {
        ValidatableResponse response = given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(user)
                .post(AUTH_PATH + "/login")
                .then().log().all();
        return response.extract().path("accessToken");
    }
}
