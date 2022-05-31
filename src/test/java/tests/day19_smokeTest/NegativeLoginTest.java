package tests.day19_smokeTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class NegativeLoginTest {

    @Test
    public void wrongPassword() {
        BrcPage brcPage=new BrcPage();

        // Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // login butonuna bas
        brcPage.firstLoginButton.click();
        // test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        // login butonuna bas
        brcPage.secondLoginButton.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(brcPage.invalid));
        Assert.assertTrue(brcPage.invalid.isDisplayed());


    }
    // bu class'da 2 test methodu daha oilusturun
    // biri yanlisKullanici

    @Test(dependsOnMethods = "wrongEmailAndPassword")
    public void wrongEmail() {
        BrcPage brcPage=new BrcPage();
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // login butonuna bas
        brcPage.firstLoginButton.click();
        // test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        // login butonuna bas
        brcPage.secondLoginButton.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(brcPage.invalid));
        Assert.assertTrue(brcPage.invalid.isDisplayed());
    }
// digeri de yanlis sifre ve kullanici adi


    @Test (dependsOnMethods = "wrongPassword")
    public void wrongEmailAndPassword() {

        BrcPage brcPage=new BrcPage();
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // login butonuna bas
        brcPage.firstLoginButton.click();
        // test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        // login butonuna bas
        brcPage.secondLoginButton.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(brcPage.invalid));
        Assert.assertTrue(brcPage.invalid.isDisplayed());
        Driver.closeDriver();
    }
}
