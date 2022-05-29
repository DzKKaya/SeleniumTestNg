package tests.day18_pom;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Properties;

public class C01_ConfigReader {

    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        Driver.closeDriver();

    }
}
