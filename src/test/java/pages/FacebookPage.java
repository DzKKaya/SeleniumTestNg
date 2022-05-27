package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath="//input[@data-testid='royal_email']")
    public WebElement email;

    @FindBy(xpath="//input[@type='password']")
    public WebElement passWorld;

    @FindBy(xpath="//button[@data-testid='royal_login_button']")
    public WebElement login;

    @FindBy(className="login_form_container")
    public WebElement dontEnter;

    @FindBy(xpath="//div[text()='Bu senin hesabın mı?']")
    public WebElement dontEnterAreYou;





}
