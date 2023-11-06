package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {
    private WebDriver driver;
    private static final By BREAD_SECTION = By.xpath(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[1]");
    private static final By SOUSE_SECTION = By.xpath(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[2]");
    private static final By FILLING_SECTION = By.xpath(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[3]");
    private static final By ENTER_BUTTON = By.xpath(".//button[text() ='Войти в аккаунт']");
    private static final By CREATE_ORDER_BUTTON = By.xpath(".//button[text() ='Оформить заказ']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(EnvoirmentConfiguration.URL);
    }
    public void clickOnEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
    }
    public void clickOnBreadSection() {
        driver.findElement(BREAD_SECTION).click();
    }
    public void clickOnSouseSection() {
        driver.findElement(SOUSE_SECTION).click();
    }
    public void clickOnFillingSection() {
        driver.findElement(FILLING_SECTION).click();
    }
    public void waitForCreateOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvoirmentConfiguration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_ORDER_BUTTON));
    }
    public void waitForEnterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvoirmentConfiguration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(ENTER_BUTTON));
    }
    public void waitForBreadSectionBecomeCurrent() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvoirmentConfiguration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(BREAD_SECTION, "class", "current"));
    }
    public void waitForSouseSectionBecomeCurrent() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvoirmentConfiguration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(SOUSE_SECTION, "class", "current"));
    }
    public void waitForFillingSectionBecomeCurrent() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvoirmentConfiguration.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(FILLING_SECTION, "class", "current"));
    }
}
