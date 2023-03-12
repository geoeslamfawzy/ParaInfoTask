package factories;

import constants.FrameworkConstants;
import driver.DriverAdministration;
import constants.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitFactory {
    static WebElement element = null;
    public static WebElement performExplicitWait(WaitStrategy waitStrategy , By locator){

       if(waitStrategy == WaitStrategy.CLICKABLE){
           element =new WebDriverWait(DriverAdministration.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                   .until(ExpectedConditions.elementToBeClickable(locator));
       } else if (waitStrategy == WaitStrategy.PRESENCE) {
           element = new WebDriverWait(DriverAdministration.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                   .until(ExpectedConditions.presenceOfElementLocated(locator));
       } else if (waitStrategy == WaitStrategy.VISIBLE) {
           element = new WebDriverWait(DriverAdministration.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                   .until(ExpectedConditions.visibilityOfElementLocated(locator));
       } else if (waitStrategy == WaitStrategy.NONE) {
           DriverAdministration.getDriver().findElement(locator);
       }
       return element;
    }

    public static WebElement PerformFluentWait(By locator)
    {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(DriverAdministration.getDriver()).
                withTimeout(Duration.ofSeconds(FrameworkConstants.getFluentWait())).
                pollingEvery(Duration.ofSeconds(1)).
                ignoring(Exception.class);
        try{
            element = fluentWait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return DriverAdministration.getDriver().findElement(locator);
                }
            });
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return element;
    }

    public static void PerformImplicitWait()
    {
        DriverAdministration.getDriver().manage().timeouts().implicitlyWait(FrameworkConstants.getImplicitWait(), SECONDS);
    }
}
