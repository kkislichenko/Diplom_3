import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import page.object.EnvoirmentConfiguration;

import java.io.File;

public class DriverConfiguration extends ExternalResource {
    private WebDriver driver;
    @Override
    protected void before() throws Throwable {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        if ("firefox".equals(System.getProperty("browser"))) {
            setUpFirefox();
        } else if ("yandex".equals(System.getProperty("browser"))) {
            setUpYandex();
        } else {
            setUpChrome();
        }
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setUpChrome() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(EnvoirmentConfiguration.CHROME_DRIVER))
                .build();
        ChromeOptions options = new ChromeOptions()
                .setBinary(EnvoirmentConfiguration.CHROME_BINARY);

        driver = new ChromeDriver(service, options);
    }

    public void setUpYandex() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(EnvoirmentConfiguration.YANDEX_DRIVER))
                .build();
        ChromeOptions options = new ChromeOptions()
                .setBinary(EnvoirmentConfiguration.YANDEX_BINARY);

        driver = new ChromeDriver(service, options);
    }

    public void setUpFirefox() {
        var service = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File(EnvoirmentConfiguration.FIREFOX_DRIVER))
                .build();

        var options = new FirefoxOptions()
                .setBinary(EnvoirmentConfiguration.FIREFOX_BINARY);

        driver = new FirefoxDriver(service, options);
    }
}


