package MyStepdefs;

import cucumber.api.java.After;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MainPage;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class MyStepdefs {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I have open main page")
    public void iHaveOpenMainPage() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.ubs.com/global/en.html");
        driver.manage().window().maximize();

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//span[text()='Agree to all']")).click();
        driver.switchTo().defaultContent();
    }

    @When("I search for specific phrase")
    public void iSearchForSpecificPhrase() {
        MainPage page = new MainPage(driver);
        page.performSearch("something");
    }

    @Then("Phrase results has been found")
    public void phraseResultsHasBeenFound() {
        MainPage page = new MainPage(driver);
        String expectedTitle = driver.getTitle();
        assertEquals("Search | UBS Global topics", expectedTitle);
    }

    @When("I click on DE icon")
    public void iClickOnDEENIcon() {
        MainPage page = new MainPage(driver);
        page.clickOnSelectLanguage();
    }

    @Then("Language has been changed")
    public void languageHasBeenChanged() {
        MainPage page = new MainPage(driver);
        WebElement h1Title = driver.findElement(By.className("header__hlTitle"));
        assertEquals("Globale Themen", h1Title.getText());
    }

    @When("I select my country from contact list")
    public void iSelectMyCountryFromContactList() {
        MainPage page = new MainPage(driver);
        page.selectContactCountry();
    }

    @Then("Contact page for country is open")
    public void contactPageForCountryIsOpen() {
        WebElement h1Title = driver.findElement(By.className("header__hlTitle"));
        assertEquals("Ihre Fragen an uns | UBS Österreich", h1Title.getText());
    }
    
    @When("I select my domicile")
    public void iSelectMyDomicile() throws InterruptedException {
        MainPage page = new MainPage(driver);
        page.selectDomicile();
    }

    @Then("Selected domicile is visible on page")
    public void selectedDomicileIsVisibleOnPage() {
        WebElement newDomicile = driver.findElement(By.xpath("//button[@id='menulabel-6001']"));
        assertEquals("Germany",newDomicile.getText());
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
