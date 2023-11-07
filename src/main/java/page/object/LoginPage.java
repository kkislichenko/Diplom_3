package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private final By EMAIL_FIELD = By.xpath(".//fieldset[1]//input");
    private final By PASSWORD_FIELD = By.xpath(".//fieldset[2]//input");
    private final By LOGIN_BUTTON = By.xpath(".//button[text() = 'Войти']");
    private static final By RECOVER_PASSWORD_BUTTON = By.xpath(".//a[@href='/forgot-password']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(EnvoirmentConfiguration.LOGIN_URI);
    }
    public void setEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }
    public void setPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }
    public void clickOnLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
    public void fillLoginForm(String email, String password) {
        setEmail(email);
        setPassword(password);
    }
    public void scrollToLoginButton() {
        WebElement element = driver.findElement(LOGIN_BUTTON);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void waitForRecoverPasswordButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvoirmentConfiguration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(RECOVER_PASSWORD_BUTTON));
    }
}

