package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private WebDriver driver;
    private final By personalAccountButton = By.xpath(".//header/nav/a");
    private final By constructorButton = By.xpath(".//header/nav/ul/li/a[@href='/']");
    private final By logoButton = By.xpath(".//header/nav/div/a");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }
    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    public void clickOnLogoButton() {
        driver.findElement(logoButton).click();
    }

}
