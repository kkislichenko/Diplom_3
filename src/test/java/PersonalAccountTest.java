import api.UserRegistration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import page.object.Header;
import page.object.LoginPage;
import page.object.PersonalAccountPage;

public class PersonalAccountTest {
    UserRegistration randomUser;

    @Rule
    public DriverConfiguration driverConfiguration = new DriverConfiguration();

    @DisplayName("Переход в личный кабинет")
    @Test
    public void enterToPersonalAccountTest() {
        Header header = new Header(driverConfiguration.getDriver());
        LoginPage loginPage = new LoginPage(driverConfiguration.getDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driverConfiguration.getDriver());

        randomUser = RegisterLoginDeleteUser.userRegister();
        loginPage.open();
        RegisterLoginDeleteUser.userLogin(driverConfiguration.getDriver(), randomUser);
        header.clickOnPersonalAccountButton();
        personalAccountPage.waitForExitButton();
        RegisterLoginDeleteUser.userDelete(RegisterLoginDeleteUser.takeAccessToken(randomUser.getEmail(), randomUser.getPassword()));
    }

    @DisplayName("Выход из аккаунта по прямой ссылке")
    @Test
    public void exitAccountByProfileURLTest() {
        LoginPage loginPage = new LoginPage(driverConfiguration.getDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driverConfiguration.getDriver());

        randomUser = RegisterLoginDeleteUser.userRegister();
        loginPage.open();
        RegisterLoginDeleteUser.userLogin(driverConfiguration.getDriver(), randomUser);
        personalAccountPage.open();
        personalAccountPage.clickOnExitButton();
        loginPage.waitForRecoverPasswordButton();
        RegisterLoginDeleteUser.userDelete(RegisterLoginDeleteUser.takeAccessToken(randomUser.getEmail(), randomUser.getPassword()));
    }

    @DisplayName("Выход из аккаунта через переход в Личный кабинет")
    @Test
    public void exitAccountByProfileButtonInHeaderTest() {
        Header header = new Header(driverConfiguration.getDriver());
        LoginPage loginPage = new LoginPage(driverConfiguration.getDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driverConfiguration.getDriver());

        randomUser = RegisterLoginDeleteUser.userRegister();
        loginPage.open();
        RegisterLoginDeleteUser.userLogin(driverConfiguration.getDriver(), randomUser);
        header.clickOnPersonalAccountButton();
        personalAccountPage.waitForExitButton();
        personalAccountPage.clickOnExitButton();
        loginPage.waitForRecoverPasswordButton();
        RegisterLoginDeleteUser.userDelete(RegisterLoginDeleteUser.takeAccessToken(randomUser.getEmail(), randomUser.getPassword()));
    }
}
