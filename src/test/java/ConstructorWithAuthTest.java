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
import page.object.ConstructorPage;
import page.object.Header;
import page.object.LoginPage;
import page.object.PersonalAccountPage;

import java.io.File;
import java.time.Duration;

public class ConstructorWithAuthTest {
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
        driver.get(Configuration.LOGIN_URI);
        RegisterAndLogin.checkLoginAttempt(driver, email, password);
    }

    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    @Test
    public void goToMainPageByConstructorButtonTest() {
        Header header = new Header(driver);
        header.clickOnPersonalAccountButton();
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(PersonalAccountPage.getExitButton()));
        header.clickOnConstructorButton();
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(ConstructorPage.getCreateOrderButton()));
    }

    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    @Test
    public void goToMainPageByLogoButtonTest() {
        Header header = new Header(driver);
        header.clickOnPersonalAccountButton();
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(PersonalAccountPage.getExitButton()));
        header.clickOnLogoButton();
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(ConstructorPage.getCreateOrderButton()));
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
