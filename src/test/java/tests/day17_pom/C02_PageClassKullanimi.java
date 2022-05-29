package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {

    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();
        Driver.getDriver().get("https://www.amazon.com");
        amazonPage.searchBox.sendKeys("Nutella", Keys.ENTER);

        String actualResult=amazonPage.searchResult.getText();
        String expectedResult="Nutella";

        Assert.assertTrue(actualResult.contains(expectedResult));

        Driver.closeDriver();
    }
}
