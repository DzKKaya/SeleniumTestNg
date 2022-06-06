package practicePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TutorialsninjaPage {

    public TutorialsninjaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Phones & PDAs']")
    public WebElement phone;

    @FindBy(xpath = "//div/h4")
    public List<WebElement> brandName;

    @FindBy (xpath = "//span[text()='Add to Cart']")
    public List<WebElement> addToCart;

    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    public WebElement cartButton;

    @FindBy (xpath = "//td[@class='text-left']")
    public List<WebElement> phoneNameList;



}
