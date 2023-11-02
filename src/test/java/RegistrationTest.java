import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.object.ConstructorPage;
import page.object.LoginPage;
import page.object.RegistrationPage;

import java.io.File;
import java.time.Duration;

public class RegistrationTest {
    private WebDriver driver;
    private String name;
    private String email;
    private String password;

    @Before
    public void setUp() {
        setUpChrome();
        //setUpYandex();
    }

    @DisplayName("Успешная регистраци")
    @Test
    public void successfulRegistrationTest() {
        name = "Autotest";
        email = RandomData.randomEmail();
        password = "Autotest";
        RegisterAndLogin.registerAttempt(driver, name, email, password, LoginPage.getRecoverPasswordButton());
    }

    @DisplayName("Попытка регистраци с паролем менее 6-ти символов")
    @Test
    public void registrationWithShortPasswordTest() {
        name = "Autotest";
        email = RandomData.randomEmail();
        password = "Auto";
        RegisterAndLogin.registerAttempt(driver, name, email, password, RegistrationPage.getInvalidPasswordMessage());
    }

    @After
    public void tearDown() {
        driver.get(Configuration.LOGIN_URI);
        RegisterAndLogin.loginAttempt(driver, email, password);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.visibilityOfElementLocated(ConstructorPage.getEnterButton()));
        } catch (TimeoutException e) {
            System.out.println("Пользователь не был создан");
        }
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
