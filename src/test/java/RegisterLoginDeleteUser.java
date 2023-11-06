import api.UserLogin;
import api.UserRegistration;
import api.UserResponses;
import org.openqa.selenium.WebDriver;
import page.object.ConstructorPage;
import page.object.LoginPage;

public class RegisterLoginDeleteUser {

    public static UserRegistration userRegister() {
        UserRegistration user = RandomData.randomUserRegistration();
        UserResponses userResponses = new UserResponses();
        userResponses.register(user);
        return user;
    }

    public static void userLogin(WebDriver driver, UserRegistration user) {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.waitForRecoverPasswordButton();
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        loginPage.clickOnLoginButton();
        constructorPage.waitForCreateOrderButton();
    }

    protected static String takeAccessToken(String email, String password) {
        UserResponses userResponses = new UserResponses();
        UserLogin userLogin = new UserLogin(email, password);
        String accessToken = userResponses.login(userLogin);
        return accessToken;
    }

    public static void userDelete(String accessToken) {
        UserResponses delete = new UserResponses();
        if (accessToken != null && !accessToken.isEmpty()) {
            delete.delete(accessToken);
        }
    }
}
