import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public class DriverConfiguration extends ExternalResource {
    private WebDriver driver;
    Properties property = new Properties();

    @Override
    protected void before() throws Throwable {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(System.getProperty("config"));
        property.load(is);
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
                .usingDriverExecutable(new File(property.getProperty("webdriver.chrome.driver")))
                .build();
        ChromeOptions options = new ChromeOptions()
                .setBinary(property.getProperty("webdriver.chrome.binary"));

        driver = new ChromeDriver(service, options);
    }

    public void setUpYandex() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(property.getProperty("webdriver.yandex.driver")))
                .build();
        ChromeOptions options = new ChromeOptions()
                .setBinary(property.getProperty("webdriver.yandex.binary"));

        driver = new ChromeDriver(service, options);
    }

    public void setUpFirefox() {
        var service = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File(property.getProperty("webdriver.gecko.driver")))
                .build();

        var options = new FirefoxOptions()
                .setBinary(property.getProperty("webdriver.gecko.binary"));

        driver = new FirefoxDriver(service, options);
    }
}


