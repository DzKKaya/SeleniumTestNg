package slaytPractice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Guru99Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class CH01_guru99Test {
    @Test
    public void test01() {

        Guru99Page guru99Page=new Guru99Page();

        // http://demo.guru99.com/test/drag_drop.html url e git
        Driver.getDriver().get(ConfigReader.getProperty("guru99Url"));
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
        actions.dragAndDrop(guru99Page.bankButton,guru99Page.accountDebit).perform();

        // CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        wait.until(ExpectedConditions.elementToBeClickable(guru99Page.accountCredit));
        actions.dragAndDrop(guru99Page.salesButton,guru99Page.accountCredit).perform();

        // DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
        wait.until(ExpectedConditions.elementToBeClickable(guru99Page.amountDebit));
        actions.dragAndDrop(guru99Page.firstFiveButton,guru99Page.amountDebit).perform();

        // CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
        wait.until(ExpectedConditions.elementToBeClickable(guru99Page.amountCredit));
        actions.dragAndDrop(guru99Page.secondFiveButton,guru99Page.amountCredit).perform();

        // Perfect butonun goruntulendigini dogrulayin
        Assert.assertTrue(guru99Page.perfect.isDisplayed());

        //Driver'i kapatin
        Driver.closeDriver();

    }

}
