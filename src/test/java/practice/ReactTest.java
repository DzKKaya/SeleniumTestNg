package practice;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import practicePage.ReactPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReactTest {
    // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
    // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
    // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
    // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
    // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
    // (Her ürün 1 defadan fazla eklenemez!)
    // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
    // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
    // 7.Checkout'a tıklayın


    @Test
    public void test01() throws InterruptedException {
        ReactPage react = new ReactPage();

        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("reactUrl"));

        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )

        for (int i = 0; i < react.tumUrunListesi.size(); i++) {
            System.out.println((i + 1) + ". urun : " + react.tumUrunListesi.get(i).getText());
        }
        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        List<String> urunAdlari = new ArrayList<>();
        for (int i = 0; i < react.tumUrunListesi.size(); i++) {
            urunAdlari.add(react.tumUrunListesi.get(i).getText());
        }

        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        // (Her ürün 1 defadan fazla eklenemez!)
        Random rnd = new Random();
        Actions actions = new Actions(Driver.getDriver());
        int index = 0;
        while (react.sepettekiUrunlerListesi.size() < 6) {
            try {
                index = rnd.nextInt(16);
                if (!react.sepettekiUrunlerListesi.contains(react.tumUrunListesi.get(index))) {
                    react.addButonElementleriListesi.get(index).click();
                }

            } catch (ElementClickInterceptedException e) {
                actions.sendKeys(Keys.PAGE_DOWN);
            }
        }

        Thread.sleep(2000);
        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        DecimalFormat format = new DecimalFormat("##.##");
        double toplam = 0;

        for (WebElement each : react.sepettekiUrunFiyatListesi) {
            toplam += Double.parseDouble(each.getText().replaceAll("[^.0-9]", ""));
        }

        System.out.println("toplam = " + format.format(toplam));
        String toplamFormatli = format.format(toplam);

        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        double actulaSepetTutari = Double.parseDouble(react.sepetTutari.getText().replaceAll("[^.0-9]", ""));

        String actualToplamFormatli = format.format(actulaSepetTutari);
        System.out.println("actulaSepetTutari = " + actulaSepetTutari);

        if (actualToplamFormatli.equals(toplamFormatli)) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST Failed");
        // 7.Checkout'a tıklayın
        react.checkoutElementi.click();

        Driver.getDriver().switchTo().alert().accept();

       // Driver.closeDriver();


    }
}
