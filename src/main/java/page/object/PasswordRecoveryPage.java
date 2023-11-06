package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordRecoveryPage {
    private WebDriver driver;
    private static final By ENTER_BUTTON = By.xpath(".//a[@href='/login']");
    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(EnvoirmentConfiguration.RECOVER_PASSWORD_URI);
    }
    public void clickOnEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
    }
    public void waitForEnterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvoirmentConfiguration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(ENTER_BUTTON));
    }
}
