package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private final By emailField = By.xpath(".//fieldset[1]//input");
    private final By passwordField = By.xpath(".//fieldset[2]//input");
    private final By loginButton = By.xpath(".//button[text() = 'Войти']");
    private static final By recoverPasswordButton = By.xpath(".//a[@href='/forgot-password']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void fillLoginForm(String email, String password) {
        setEmail(email);
        setPassword(password);
    }
    public void scrollToLoginButton() {
        WebElement element = driver.findElement(loginButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public static By getRecoverPasswordButton() {
        return recoverPasswordButton;
    }
}

