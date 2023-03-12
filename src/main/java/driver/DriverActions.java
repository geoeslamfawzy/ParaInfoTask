package driver;

import constants.enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertyUtilis;

import java.util.Objects;


public final class DriverActions {
    private DriverActions(){}
    public static void initDriver() throws Exception {
        if(Objects.isNull(DriverAdministration.getDriver())){
            WebDriverManager.chromedriver().setup();
            DriverAdministration.setDriver(new ChromeDriver());
            DriverAdministration.getDriver().get(PropertyUtilis.get(ConfigProperties.URL));
            DriverAdministration.getDriver().manage().window().maximize();
        }
    }
    public static void quitDriver(){
        if(Objects.isNull(DriverAdministration.getDriver())){
            DriverAdministration.getDriver().quit();
            DriverAdministration.unload();
        }
    }
}
