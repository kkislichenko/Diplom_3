package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private final By NAME_FIELD = By.xpath(".//fieldset[1]//input");
    private final By EMAIL_FIELD = By.xpath(".//fieldset[2]//input");
    private final By PASSWORD_FIELD = By.xpath(".//fieldset[3]//input");
    private static final By REGISTER_BUTTON = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private final By ENTER_BUTTON = By.xpath(".//a[@href='/login']");
    private final By HEADING = By.xpath(".//h2[text() = 'Регистрация']");
    private static final By INVALID_PASSWORD_MESSAGE = By.xpath(".//p[text() ='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(EnvoirmentConfiguration.REGISTER_URI);
    }
    public void setName(String name) {
        driver.findElement(NAME_FIELD).sendKeys(name);
    }
    public void setEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }
    public void setPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }
    public void clickOnRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }
    public void clickOnEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
    }
    public void clickSpaceOutOfFieldsArea() {
        driver.findElement(HEADING).click();
    }

    public void fillRegisterForm(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickSpaceOutOfFieldsArea();
    }
    public void scrollToRegisterButton() {
        WebElement element = driver.findElement(REGISTER_BUTTON);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void waitForRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvoirmentConfiguration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(REGISTER_BUTTON));
    }
    public void waitForInvalidPasswordMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvoirmentConfiguration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(INVALID_PASSWORD_MESSAGE));
    }
}
