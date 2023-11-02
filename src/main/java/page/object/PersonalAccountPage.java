package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    private WebDriver driver;
    private static final By exitButton = By.xpath(".//button[text() = 'Выход']");
    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnExitButton() {
        driver.findElement(exitButton).click();
    }
    public static By getExitButton() {
        return exitButton;
    }
}
