package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private WebDriver driver;
    private static final By enterButton = By.xpath(".//a[@href='/login']");
    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnEnterButton() {
        driver.findElement(enterButton).click();
    }
    public static By getEnterButton() {
        return enterButton;
    }

}
