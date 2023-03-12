package pages;

import base.UIActions;
import constants.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public final class SubscribePage{
    UIActions ui = new UIActions();
    private String dynamicCountryName = "//span[contains(text(), '%replace%')]//parent::a[@class='country ']";
    private final By langBTN = By.id("translation-btn");
    private By packagesTypes = By.xpath("//strong[contains(@id , 'name-')]");
    private By countryChangeBtn = By.xpath("//a[contains(@id, 'country-')]");
    private By litePrice = By.xpath("//div[contains(@id , 'currency-lite') or contains(@id , 'currency-لايت')]/b");
    private By classicPrice = By.xpath("//div[contains(@id , 'currency-classic') or contains(@id , 'currency-الأساسية')]/b");
    private By premiumPrice = By.xpath("//div[contains(@id , 'currency-premium') or contains(@id , 'currency-بريميوم')]/b");
    private By trialOffer = By.xpath("//div[@class = 'trial-cost']");
    private By trialPrice = By.xpath("//div[@class = 'trial-cost']/b");



    public SubscribePage changePageLanguage(){
        ui.clickOn(langBTN, WaitStrategy.CLICKABLE);

        return this;
    }

    public List<String> getPackagesTypes(){
        List<WebElement> packages = ui.findElements(packagesTypes);
        List<String> packagesNames = new ArrayList<String>();
        for (WebElement pkg : packages){
            packagesNames.add(pkg.getText());
            System.out.println(pkg.getText());
        }
        return packagesNames;
    }

    public SubscribePage chooseCountry(String countryName){
        ui.clickOn(countryChangeBtn, WaitStrategy.CLICKABLE);
        By countryLocator = By.xpath(dynamicCountryName.replace("%replace%", countryName));
        ui.clickOn(countryLocator, WaitStrategy.CLICKABLE);
        return this;
    }
    public String getLitePrice(){
        return ui.find(litePrice).getText();
    }
    public String getClassicPrice(){
        return ui.find(classicPrice).getText();
    }
    public String getPremiumPrice(){
        return ui.find(premiumPrice).getText();
    }
    public String getTrialOffer(){
        return ui.find(trialOffer).getText();
    }
    public String getTrialPrice(){
        return ui.find(trialPrice).getText();
    }
}
