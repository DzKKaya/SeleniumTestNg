package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_PageClassKullanimi {
    @Test
    public void test01() {

        FacebookPage facebookPage=new FacebookPage();
// facebook anasayfaya gidin

        Driver.getDriver().get("https://www.facebook.com");

// cikarsa cookies kabul edin
// kullanici mail kutusuna rastgele bir isim yazdirin
        Faker faker=new Faker();
       // Actions actions=new Actions(Driver.getDriver());
        facebookPage.email.sendKeys(faker.internet().emailAddress());
      //  actions.sendKeys(Keys.TAB, faker.internet().password(),Keys.TAB,Keys.TAB,Keys.ENTER ).perform();
// kullanici sifre kutusuna rastgele bir password yazdirin

        facebookPage.passWorld.sendKeys(faker.internet().password());
// login butonuna basin

        facebookPage.login.click();
// giris yapilamadigini test edin

        Assert.assertTrue(facebookPage.dontEnter.isDisplayed());

    }
}
