package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SahibindenPage {

    public SahibindenPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//button[@aria-label='Kapat'])[1]")
    public WebElement cookiesButtonElement;

    @FindBy(xpath = "//*[@id='searchText']")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@title='Otomobil']")
    public WebElement automobil;

    @FindBy (xpath ="(//div[@class='jspPane'])[1]//li")
    public List<WebElement> carCategory;

    @FindBy(xpath = "//div[@class='uiInlineBoxContent category-list']")
    public WebElement categryPage;

    @FindBy(xpath = "(//div[@class='jspContainer'])[1]//li/a[@title='Honda']")
    public WebElement honda;

}
