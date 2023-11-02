import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.object.*;

import java.io.File;
import java.time.Duration;

public class LoginTest {
    private String name;
    private String email;
    private String password;
    private WebDriver driver;

    @Before
    public void setUp() {
        name = "Autotest";
        email = RandomData.randomEmail();
        password = "Autotest";
        setUpChrome();
        //setUpYandex();
        RegisterAndLogin.registerAttempt(driver, name, email, password, LoginPage.getRecoverPasswordButton());
    }

    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Test
    public void loginFromMainPageTest() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        driver.get(Configuration.URL);
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(ConstructorPage.getEnterButton()));
        constructorPage.clickOnEnterButton();
        RegisterAndLogin.checkLoginAttempt(driver, email, password);
    }

    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Test
    public void loginFromPersonalAccountPageTest() {
        Header header = new Header(driver);
        driver.get(Configuration.URL);
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(ConstructorPage.getEnterButton()));
        header.clickOnPersonalAccountButton();
        RegisterAndLogin.checkLoginAttempt(driver, email, password);
    }

    @DisplayName("Вход через кнопку в форме регистрации")
    @Test
    public void loginFromRegistrationPageTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        driver.get(Configuration.REGISTER_URI);
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(RegistrationPage.getRegisterButton()));
        registrationPage.clickOnEnterButton();
        RegisterAndLogin.checkLoginAttempt(driver, email, password);
    }

    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Test
    public void loginFromPasswordRecoveryPageTest() {
        PasswordRecoveryPage recoveryPasswordPage = new PasswordRecoveryPage(driver);
        driver.get(Configuration.RECOVER_PASSWORD_URI);
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(PasswordRecoveryPage.getEnterButton()));
        recoveryPasswordPage.clickOnEnterButton();
        RegisterAndLogin.checkLoginAttempt(driver, email, password);
    }

    @After
    public void tearDown() {
        String accessToken = RegisterAndLogin.getAccessToken(driver);
        DeleteUser delete = new DeleteUser();
        if(accessToken != null && !accessToken.isEmpty()){
            delete.deleteUser(accessToken);
        }
        driver.quit();
    }

    private void setUpChrome() {
        System.setProperty("webdriver.chrome.driver", Configuration.CHROME_DRIVER);
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(Configuration.CHROME_DRIVER))
                .build();
        ChromeOptions options = new ChromeOptions()
                .setBinary(Configuration.CHROME_BINARY);

        driver = new ChromeDriver(service, options);
    }

    private void setUpYandex() {
        System.setProperty("webdriver.yandex.driver", Configuration.YANDEX_DRIVER);
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(Configuration.YANDEX_DRIVER))
                .build();
        ChromeOptions options = new ChromeOptions()
                .setBinary(Configuration.YANDEX_BINARY);

        driver = new ChromeDriver(service, options);
    }
}
