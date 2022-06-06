package practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import practicePage.TutorialsninjaPage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

public class TutorialsninjaTest {
    @Test
    public void test01() {
        TutorialsninjaPage tutorialsninjaPage=new TutorialsninjaPage();

        // Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        Driver.getDriver().get(ConfigReader.getProperty("tutorialsninjaUrl"));
        // click on Phones & PDAs
        tutorialsninjaPage.phone.click();
        // get the brandName of phoness
        String expectedPhoneName="";
        tutorialsninjaPage.brandName.stream().map(t->t.getText()+expectedPhoneName).forEach(System.out::println);
        // click on add to button for all elements
        tutorialsninjaPage.addToCart.forEach(WebElement::click);
        // click on black total added cart button
        tutorialsninjaPage.cartButton.click();
        // get the names of list from the cart
        String actualPhoneName="";
        tutorialsninjaPage.phoneNameList.stream().map(t->t.getText()+actualPhoneName).forEach(System.out::println);
        // compare the names from displaying list and cart list
        Assert.assertEquals(actualPhoneName,expectedPhoneName);
        Driver.closeDriver();
    }

    /*







*/
}
