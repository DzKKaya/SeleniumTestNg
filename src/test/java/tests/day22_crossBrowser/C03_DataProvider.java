package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {
    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();
        // amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // nutella icin arama yapalim
        amazonPage.searchBox.sendKeys("Nutella" + Keys.ENTER);
        // sonuclarin nutella icerdigini test edelim
        String expectedKelime="Nutella";
        String actualSonucYazisi=amazonPage.searchResult.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        //sayfayi kapatalim
        Driver.closeDriver();
    }
    @DataProvider
    public static Object[][] AranacakKelimeler() {
        Object[][] arananKelimeArrayi= {{"Nutella"}, {"Java"}, {"cigdem"} , {"Netherlands"}};
        return arananKelimeArrayi;
    }
    @Test(dataProvider = "AranacakKelimeler")
    // arayacagimiz kelimeleri bir liste gibi tutup
    // bana yollayacak bir veri saglayicisi olusturacagiz
    public void dataProviderTesti(String arananKelime) {
        AmazonPage amazonPage=new AmazonPage();
        // amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // Nutella, Java, cigdem ve Netherlands icin arama yapalim
        amazonPage.searchBox.sendKeys(arananKelime + Keys.ENTER);
        // sonuclarin aradigimiz kelime icerdigini test edelim
        String actualSonucYazisi=amazonPage.searchResult.getText();
        Assert.assertTrue(actualSonucYazisi.contains(arananKelime));
        // sayfayi kapatalim
        Driver.closeDriver();
    }
}
