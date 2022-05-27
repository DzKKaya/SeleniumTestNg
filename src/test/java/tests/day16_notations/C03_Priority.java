package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {


    @Test (priority = -5)
    public void amazonTesti() {
        driver.get("https://www.amazon.com");
    }
    @Test (priority = -2)
    public void test02() {
        driver.get("https://www.bestbuy.com");
    }
    @Test
    public void techproedTesti() {
        driver.get("https://www.techproeducation.com");
    }
}
