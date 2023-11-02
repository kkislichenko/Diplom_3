package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {
    private WebDriver driver;
    private static final By breadSection = By.xpath(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[1]");
    private static final By souseSection = By.xpath(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[2]");
    private static final By fillingSection = By.xpath(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[3]");
    private static final By enterButton = By.xpath(".//button[text() ='Войти в аккаунт']");
    private static final By createOrderButton = By.xpath(".//button[text() ='Оформить заказ']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnEnterButton() {
        driver.findElement(enterButton).click();
    }
    public void clickOnBreadSection() {
        driver.findElement(breadSection).click();
    }
    public void clickOnSouseSection() {
        driver.findElement(souseSection).click();
    }
    public void clickOnFillingSection() {
        driver.findElement(fillingSection).click();
    }
    public static By getCreateOrderButton() {
        return createOrderButton;
    }
    public static By getEnterButton() {
        return enterButton;
    }
    public static By getBreadSection() {
        return breadSection;
    }
    public static By getSouseSection() {
        return souseSection;
    }
    public static By getFillingSection() {
        return fillingSection;
    }

}
