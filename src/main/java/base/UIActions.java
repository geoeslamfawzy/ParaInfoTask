package base;
import constants.FrameworkConstants;
import constants.enums.WaitStrategy;
import driver.DriverAdministration;
import factories.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static constants.enums.WaitStrategy.PRESENCE;

public class UIActions {
    public WebElement find(By locator) {
        return WaitFactory.performExplicitWait(PRESENCE, locator);
    }
    public  List<WebElement> findElements(By locator) {
        WaitFactory.PerformFluentWait(locator);
        return DriverAdministration.getDriver().findElements(locator);
    }
    public void clickOn(By locator, WaitStrategy waitStrategy) {
        WaitFactory.performExplicitWait(waitStrategy, locator).click();
    }
    public void writeIn(By locator, String text,  WaitStrategy waitStrategy) {
        WaitFactory.performExplicitWait(waitStrategy, locator).sendKeys(text);
    }
}
