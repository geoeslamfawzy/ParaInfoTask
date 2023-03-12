import driver.DriverActions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.SubscribePage;

public class BaseTest {
    protected BaseTest(){}

    @BeforeSuite
    protected void setup() throws Exception {
        DriverActions.initDriver();
        new SubscribePage().changePageLanguage();
    }
    @AfterSuite
    protected void tearDown(){
        DriverActions.quitDriver();
    }
}
