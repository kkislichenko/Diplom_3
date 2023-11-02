import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class DeleteUser {
    static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    public void deleteUser(String accessToken) {
        given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .auth().oauth2(accessToken)
                .delete("/api/auth/user");
    }
}
