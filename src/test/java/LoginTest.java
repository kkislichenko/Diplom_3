import api.UserRegistration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import page.object.*;

public class LoginTest {
    UserRegistration randomUser;

    @Rule
    public DriverConfiguration driverConfiguration = new DriverConfiguration();

    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Test
    public void loginFromMainPageTest() {
        ConstructorPage constructorPage = new ConstructorPage(driverConfiguration.getDriver());

        randomUser = RegisterLoginDeleteUser.userRegister();
        constructorPage.open();
        constructorPage.waitForEnterButton();
        constructorPage.clickOnEnterButton();
        RegisterLoginDeleteUser.userLogin(driverConfiguration.getDriver(), randomUser);
        RegisterLoginDeleteUser.userDelete(RegisterLoginDeleteUser.takeAccessToken(randomUser.getEmail(), randomUser.getPassword()));
    }

    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Test
    public void loginFromPersonalAccountPageTest() {
        ConstructorPage constructorPage = new ConstructorPage(driverConfiguration.getDriver());
        Header header = new Header(driverConfiguration.getDriver());

        randomUser = RegisterLoginDeleteUser.userRegister();
        constructorPage.open();
        constructorPage.waitForEnterButton();
        header.clickOnPersonalAccountButton();
        RegisterLoginDeleteUser.userLogin(driverConfiguration.getDriver(), randomUser);
        RegisterLoginDeleteUser.userDelete(RegisterLoginDeleteUser.takeAccessToken(randomUser.getEmail(), randomUser.getPassword()));
    }

    @DisplayName("Вход через кнопку в форме регистрации")
    @Test
    public void loginFromRegistrationPageTest() {
        RegistrationPage registrationPage = new RegistrationPage(driverConfiguration.getDriver());

        randomUser = RegisterLoginDeleteUser.userRegister();
        registrationPage.open();
        registrationPage.waitForRegisterButton();
        registrationPage.clickOnEnterButton();
        RegisterLoginDeleteUser.userLogin(driverConfiguration.getDriver(), randomUser);
        RegisterLoginDeleteUser.userDelete(RegisterLoginDeleteUser.takeAccessToken(randomUser.getEmail(), randomUser.getPassword()));
    }

    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Test
    public void loginFromPasswordRecoveryPageTest() {
        PasswordRecoveryPage recoveryPasswordPage = new PasswordRecoveryPage(driverConfiguration.getDriver());

        randomUser = RegisterLoginDeleteUser.userRegister();
        recoveryPasswordPage.open();
        recoveryPasswordPage.waitForEnterButton();
        recoveryPasswordPage.clickOnEnterButton();
        RegisterLoginDeleteUser.userLogin(driverConfiguration.getDriver(), randomUser);
        RegisterLoginDeleteUser.userDelete(RegisterLoginDeleteUser.takeAccessToken(randomUser.getEmail(), randomUser.getPassword()));
    }
}
