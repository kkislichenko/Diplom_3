package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    private final WebDriver driver;
    private static final By EXIT_BUTTON = By.xpath(".//button[text() = 'Выход']");
    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(EnvoirmentConfiguration.PERSONAL_ACCOUNT_URI);
    }
    public void clickOnExitButton() {
        driver.findElement(EXIT_BUTTON).click();
    }
    public void waitForExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvoirmentConfiguration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(EXIT_BUTTON));
    }
}
