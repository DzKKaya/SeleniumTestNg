package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Guru99Page {

    public Guru99Page() {

        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath ="//li[@class='block14 ui-draggable']")
    public WebElement bankButton;

    @FindBy(xpath ="(//div[@class='ui-widget-content'])[2]")
    public WebElement accountDebit;

    @FindBy(xpath = "(//a[@class='button button-orange'])[6]")
    public WebElement salesButton;

    @FindBy(xpath ="(//div[@class='ui-widget-content'])[4]")
    public WebElement accountCredit;

    @FindBy(xpath ="(//a[@class='button button-orange'])[2]")
    public WebElement firstFiveButton;

    @FindBy(xpath ="(//a[@class='button button-orange'])[4]")
    public WebElement secondFiveButton;

    @FindBy(xpath ="(//div[@class='ui-widget-content'])[3]")
    public WebElement amountDebit;

    @FindBy(xpath ="(//div[@class='ui-widget-content'])[5]")
    public WebElement amountCredit;

    @FindBy(xpath = "//div[@class='table4_result']")
    public WebElement perfect;

}
