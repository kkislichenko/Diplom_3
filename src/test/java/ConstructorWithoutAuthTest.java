import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.object.ConstructorPage;

import java.io.File;
import java.time.Duration;

public class ConstructorWithoutAuthTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        setUpChrome();
        //setUpYandex();
        driver.get(Configuration.URL);
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(ConstructorPage.getEnterButton()));
    }

    @DisplayName("Переход к разделу «Булки»")
    @Test
    public void goToBreadSectionTest() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickOnSouseSection();
        constructorPage.clickOnBreadSection();
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(ConstructorPage.getBreadSection(), "class", "current"));
    }

    @DisplayName("Переход к разделу «Соусы»")
    @Test
    public void goToSauceSectionTest() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickOnSouseSection();
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(ConstructorPage.getSouseSection(), "class", "current"));
    }

    @DisplayName("Переход к разделу «Начинки»")
    @Test
    public void goToFillingSectionTest() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickOnSouseSection();
        constructorPage.clickOnFillingSection();
        new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(ConstructorPage.getFillingSection(), "class", "current"));
    }
    @After
    public void tearDown() {
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
