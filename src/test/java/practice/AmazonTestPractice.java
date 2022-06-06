package practice;

import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class AmazonTestPractice {


    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();
        Driver.getDriver().get("https://amazon.in");
        amazonPage.searchBox.sendKeys("Kol Saatleri");

    }
}
