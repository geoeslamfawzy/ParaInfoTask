import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SubscribePage;
import utils.ExceUtilis;

import java.io.IOException;

public final class SubscriptionTests extends BaseTest{
    SubscribePage subscribePage = new SubscribePage();
    CSVReader csvReader;

    @Test(alwaysRun = true, dataProvider = "packagesCategories")
    public void testSubscription(String country, String lite, String classic, String premium){
        subscribePage.chooseCountry(country);
        Assert.assertEquals(lite, subscribePage.getLitePrice());
        Assert.assertEquals(classic, subscribePage.getClassicPrice());
        Assert.assertEquals(premium, subscribePage.getPremiumPrice());
    }

    @Test(dataProvider = "MobilePlanes")
    public void testFreeTrialsPrices(String country, String price, String currency) throws IOException, CsvValidationException {

            subscribePage.chooseCountry(country);
            Assert.assertTrue(subscribePage.getTrialOffer().contains(currency));
            Assert.assertEquals(price, subscribePage.getTrialPrice());
    }

    @DataProvider(name = "packagesCategories")
    public Object[][] getPackagesNames() throws IOException {
        ExceUtilis excel = new ExceUtilis();
        return excel.getExcelData();
    }

    @DataProvider(name = "MobilePlanes")
    public Object[][] getTrialCosts() throws IOException {
        return new Object[][]{
                {"UAE", "10.00", "AED"},
                {"Iraq", "900.00", "IQ"},
                {"Jordan", "0.99", "JOD"},
                {"Oman", "1.00", "OMR"},
                {"Tunisia", "1.00", "TND"},
        };
    }

}