import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import page.object.ConstructorPage;

public class ConstructorWithoutAuthTest {

    @Rule
    public DriverConfiguration driverConfiguration = new DriverConfiguration();

    @DisplayName("Переход к разделу «Булки»")
    @Test
    public void goToBreadSectionTest() {
        ConstructorPage constructorPage = new ConstructorPage(driverConfiguration.getDriver());

        constructorPage.open();
        constructorPage.waitForEnterButton();
        constructorPage.clickOnSouseSection();
        constructorPage.clickOnBreadSection();
        constructorPage.waitForBreadSectionBecomeCurrent();
    }

    @DisplayName("Переход к разделу «Соусы»")
    @Test
    public void goToSauceSectionTest() {
        ConstructorPage constructorPage = new ConstructorPage(driverConfiguration.getDriver());

        constructorPage.open();
        constructorPage.waitForEnterButton();
        constructorPage.clickOnSouseSection();
        constructorPage.waitForSouseSectionBecomeCurrent();
    }

    @DisplayName("Переход к разделу «Начинки»")
    @Test
    public void goToFillingSectionTest() {
        ConstructorPage constructorPage = new ConstructorPage(driverConfiguration.getDriver());

        constructorPage.open();
        constructorPage.waitForEnterButton();
        constructorPage.clickOnSouseSection();
        constructorPage.clickOnFillingSection();
        constructorPage.waitForFillingSectionBecomeCurrent();
    }
}
