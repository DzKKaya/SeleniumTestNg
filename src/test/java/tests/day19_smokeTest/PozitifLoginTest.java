package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {

    @Test
    public void test01() {
        BrcPage brcPage=new BrcPage();

        // Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // login butonuna bas
        brcPage.firstLoginButton.click();
        // test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        // login butonuna bas
        brcPage.secondLoginButton.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        System.out.println(brcPage.userProfileName.getText());

        String actualUserName="Jordon Stark";
        String expectedUserName=brcPage.userProfileName.getText();
        Assert.assertEquals(actualUserName, expectedUserName);


    }
}
