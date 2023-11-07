import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import page.object.LoginPage;
import page.object.RegistrationPage;

public class RegistrationTest {
    private String name;
    private String email;
    private String password;

    @Rule
    public DriverConfiguration driverConfiguration = new DriverConfiguration();

    @DisplayName("Успешная регистраци")
    @Test
    public void successfulRegistrationTest() {
        email = RandomData.randomEmail();
        name = "Autotest";
        password = "Autotest";

        LoginPage loginPage = new LoginPage(driverConfiguration.getDriver());

        registrationAttempt();
        loginPage.waitForRecoverPasswordButton();
        RegisterLoginDeleteUser.userDelete(RegisterLoginDeleteUser.takeAccessToken(email, password));
    }

    @DisplayName("Попытка регистраци с паролем менее 6-ти символов")
    @Test
    public void registrationWithShortPasswordTest() {
        email = RandomData.randomEmail();
        name = "Autotest";
        password = "Auto";

        RegistrationPage registrationPage = new RegistrationPage(driverConfiguration.getDriver());

        registrationAttempt();
        registrationPage.waitForInvalidPasswordMessage();
        RegisterLoginDeleteUser.userDelete(RegisterLoginDeleteUser.takeAccessToken(email, password));
    }
    public void registrationAttempt() {
        RegistrationPage registrationPage = new RegistrationPage(driverConfiguration.getDriver());
        registrationPage.open();
        registrationPage.fillRegisterForm(name,email,password);
        registrationPage.scrollToRegisterButton();
        registrationPage.clickOnRegisterButton();
    }
}
