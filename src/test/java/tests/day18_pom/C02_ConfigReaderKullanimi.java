package tests.day18_pom;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {

    @Test
    public void test01() {
        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        // cikarsa cookies kabul edin

        // kullanici mail kutusuna rastgele bir isim yazdirin
        FacebookPage facebookPage=new FacebookPage();

        facebookPage.email.sendKeys(ConfigReader.getProperty("facebookWrongUserName"));

        // kullanici sifre kutusuna rastgele bir password yazdirin
        facebookPage.passWorld.sendKeys(ConfigReader.getProperty("facebookWrongPassWorld"));
        // login butonuna basin
        facebookPage.login.click();
        // giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.dontEnter.isDisplayed());

        Driver.closeDriver();

    }
}
