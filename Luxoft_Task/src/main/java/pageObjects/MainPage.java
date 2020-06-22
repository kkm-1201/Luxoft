package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//button[@id='menulabel-7001']")
    private WebElement btnDomicile;

    @FindBy(how = How.XPATH, using = "//button[@id='menulabel-7113']")
    private WebElement selDomicileRegion;

    @FindBy(how = How.XPATH, using = "//button[@id='menulabel-7129']")
    private WebElement selDomicileCountry;

    @FindBy(how = How.XPATH, using = "//button[@id='menulabel-7204']")
    private WebElement getEurope;

    @FindBy(how = How.XPATH, using = "//a[@id='menulabel-72414']")
    private WebElement getGermany;

    @FindBy(how = How.XPATH, using = "//button[@aria-label=\"Search\"]")
    private WebElement btnSearch;

    @FindBy(how = How.CLASS_NAME, using = "searchbox")
    private WebElement textSearch;

    @FindBy(how = How.CLASS_NAME, using = "search-button")
    private WebElement iconSearch;

    @FindBy(how = How.XPATH, using = "//span[@class=\"query\" and text()='something']")
    private WebElement searchResult;

    @FindBy(how = How.CLASS_NAME, using = "header__hlTitle")
    private WebElement h1Title;

    @FindBy(how = How.XPATH, using = "//*[@id=\"metanav\"]/div[1]/ul[2]/li/a")
    private WebElement btnLanguage;

    @FindBy(how = How.CLASS_NAME, using = "catNav__label catNav__hl--contactIcon")
    private WebElement btnContact;

    @FindBy(how = How.XPATH, using = "//*[text()='Austria']")
    private WebElement contactCountry;

    public void selectContactCountry() {
        btnContact.click();
        contactCountry.click();
    }

    public void clickOnSelectLanguage(){
        btnLanguage.click();
    }

    public void performSearch(String search)  {
        btnSearch.click();
        textSearch.sendKeys(search);
        iconSearch.click();
    }

    public void selectDomicile() {
        btnDomicile.click();
        selDomicileRegion.click();
        getEurope.click();
        selDomicileCountry.click();
        getGermany.click();
    }

}

