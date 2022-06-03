package tests.day21_reusableMethods_HtmlReport;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C02_ScreenshotReusableMethods {
    @Test
    public void test01() throws IOException {

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.getScreenshot("amazon");

    }
}
