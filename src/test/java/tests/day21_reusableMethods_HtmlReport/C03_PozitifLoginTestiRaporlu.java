package tests.day21_reusableMethods_HtmlReport;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PozitifLoginTestiRaporlu extends TestBaseRapor {

    BrcPage brcPage=new BrcPage();
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve sifre ile giris yapabilmeli");
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");
        // login butonuna bas
        brcPage.firstLoginButton.click();
        extentTest.info("login butonuna tiklandi");
        // test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazildi");
        // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Gecerli password yazildi");
        // login butonuna bas
        brcPage.secondLoginButton.click();
        extentTest.info("login butonuna basildi");
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        System.out.println(brcPage.userProfileName.getText());

        String actualUserName="Jordon Stark";
        String expectedUserName=brcPage.userProfileName.getText();
        Assert.assertEquals(actualUserName, expectedUserName);
        extentTest.pass("kullanici basarili sekilde giris yapti");
        Driver.closeDriver();

    }
}
