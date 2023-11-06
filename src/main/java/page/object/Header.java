package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private WebDriver driver;
    private final By PERSONAL_ACCOUNT_BUTTON = By.xpath(".//header/nav/a");
    private final By CONSTRUCTOR_BUTTON = By.xpath(".//header/nav/ul/li/a[@href='/']");
    private final By LOGO_BUTTON = By.xpath(".//header/nav/div/a");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnPersonalAccountButton() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }
    public void clickOnConstructorButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }
    public void clickOnLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
    }

}
