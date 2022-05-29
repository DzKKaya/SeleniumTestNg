package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SahibindenTest {

        @Test
        public void test01() throws InterruptedException {
            SahibindenPage sahibindenPage = new SahibindenPage();
            Driver.getDriver().get("https://www.sahibinden.com");
            Thread.sleep(2000);
            sahibindenPage.cookiesButtonElement.click();
            Thread.sleep(2000);
            sahibindenPage.automobil.click();
            Thread.sleep(4000);

            List<String> carCategories =new ArrayList<>();

        /*
        @FindBy (xpath ="//ul[@class='categoryList jspScrollable']//h2")
        public List<WebElement> carCategory;
         */

            System.out.println(sahibindenPage.categryPage.getText());
            JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();



            // for (WebElement each: sahibindenPage.carCategory
           // ) {
           //     JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
           //     jse.executeScript("arguments[0].scrollIntoView(true);",each);
           //     System.out.println(each.getText());
           //     carCategories.add(each.getText());
           // }
            sahibindenPage.honda.click();

            String expectedWord = "Honda";


            Driver.closeDriver();

        }
    }

