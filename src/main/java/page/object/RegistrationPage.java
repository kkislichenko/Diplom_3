package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;
    private final By nameField = By.xpath(".//fieldset[1]//input");
    private final By emailField = By.xpath(".//fieldset[2]//input");
    private final By passwordField = By.xpath(".//fieldset[3]//input");
    private static final By registerButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private final By enterButton = By.xpath(".//a[@href='/login']");
    private final By heading = By.xpath(".//h2[text() = 'Регистрация']");
    private static final By invalidPasswordMessage = By.xpath(".//p[text() ='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }
    public void clickOnEnterButton() {
        driver.findElement(enterButton).click();
    }
    public void clickSpaceOutOfFieldsArea() {
        driver.findElement(heading).click();
    }

    public void fillRegisterForm(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickSpaceOutOfFieldsArea();
    }
    public void scrollToRegisterButton() {
        WebElement element = driver.findElement(registerButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public static By getInvalidPasswordMessage() {
        return invalidPasswordMessage;
    }
    public static By getRegisterButton() {
        return registerButton;
    }
}
