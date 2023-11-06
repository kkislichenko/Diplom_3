import api.UserRegistration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import page.object.ConstructorPage;
import page.object.Header;
import page.object.LoginPage;
import page.object.PersonalAccountPage;

public class ConstructorWithAuthTest {
    UserRegistration randomUser;

    @Rule
    public DriverConfiguration driverConfiguration = new DriverConfiguration();

    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    @Test
    public void goToMainPageByConstructorButtonTest() {
        Header header = new Header(driverConfiguration.getDriver());
        ConstructorPage constructorPage = new ConstructorPage(driverConfiguration.getDriver());
        LoginPage loginPage = new LoginPage(driverConfiguration.getDriver());

        randomUser = RegisterLoginDeleteUser.userRegister();
        loginPage.open();
        RegisterLoginDeleteUser.userLogin(driverConfiguration.getDriver(), randomUser);
        enterToPersonalAccount();
        header.clickOnConstructorButton();
        constructorPage.waitForCreateOrderButton();
        RegisterLoginDeleteUser.userDelete(RegisterLoginDeleteUser.takeAccessToken(randomUser.getEmail(), randomUser.getPassword()));
    }

    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    @Test
    public void goToMainPageByLogoButtonTest() {
        Header header = new Header(driverConfiguration.getDriver());
        ConstructorPage constructorPage = new ConstructorPage(driverConfiguration.getDriver());
        LoginPage loginPage = new LoginPage(driverConfiguration.getDriver());

        randomUser = RegisterLoginDeleteUser.userRegister();
        loginPage.open();
        RegisterLoginDeleteUser.userLogin(driverConfiguration.getDriver(), randomUser);
        enterToPersonalAccount();
        header.clickOnLogoButton();
        constructorPage.waitForCreateOrderButton();
        RegisterLoginDeleteUser.userDelete(RegisterLoginDeleteUser.takeAccessToken(randomUser.getEmail(), randomUser.getPassword()));
    }

    public void enterToPersonalAccount() {
        Header header = new Header(driverConfiguration.getDriver());
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driverConfiguration.getDriver());
        header.clickOnPersonalAccountButton();
        personalAccountPage.waitForExitButton();
    }
}
