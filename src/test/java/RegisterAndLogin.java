import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.object.ConstructorPage;
import page.object.LoginPage;
import page.object.RegistrationPage;

import java.time.Duration;

public class RegisterAndLogin {

    public static void registerAttempt(WebDriver driver, String name, String email, String password, By waitFor){
        driver.get(Configuration.REGISTER_URI);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegisterForm(name,email,password);
        registrationPage.scrollToRegisterButton();
        registrationPage.clickOnRegisterButton();
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(waitFor));
    }
    public static void loginAttempt(WebDriver driver, String email, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(email, password);
        loginPage.scrollToLoginButton();
        loginPage.clickOnLoginButton();
    }
    public static void checkLoginAttempt(WebDriver driver, String email, String password){
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(LoginPage.getRecoverPasswordButton()));
        loginAttempt(driver, email, password);
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(ConstructorPage.getCreateOrderButton()));
    }
    public static String getAccessToken(WebDriver driver){
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        return accessToken;
    }
}
