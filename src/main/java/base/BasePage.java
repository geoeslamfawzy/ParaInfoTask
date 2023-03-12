package base;

import constants.enums.WaitStrategy;
import factories.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected void clickOn(By locator){
        WaitFactory.performExplicitWait(WaitStrategy.CLICKABLE, locator).click();
    }
    protected void sendKeys(By locator, String text){
        WebElement element = WaitFactory.performExplicitWait(WaitStrategy.PRESENCE, locator);
        element.sendKeys(text);
    }


}
