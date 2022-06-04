package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ReactPage {

    public ReactPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//p[@class='sc-124al1g-4 eeXMBo']")
    public List<WebElement> tumUrunListesi;

    @FindBy(xpath = "//button[@tabindex='-1']")
    public  List<WebElement> addButonElementleriListesi;


    @FindBy(xpath = "//div[@class='sc-11uohgb-0 hDmOrM']")
    public  List<WebElement> sepettekiUrunlerListesi;

        @FindBy(xpath = "//div[@class='sc-11uohgb-4 bnZqjD']")
    public  List<WebElement> sepettekiUrunFiyatListesi;

        @FindBy(xpath = "//p[@class='sc-1h98xa9-9 jzywDV']")
    public WebElement sepetTutari;

        @FindBy(xpath = "//button[@class='sc-1h98xa9-11 gnXVNU']")
    public  WebElement checkoutElementi;
}
