package practice4;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.TestBase;

public class Q6_DropDown_FakerClass extends TestBase {
    @Test
    public void test01() {
        driver.get("https://twitter.com");
       // driver.findElement(By.xpath("//span[text()='Kaydol']")).click();
        driver.findElement(By.xpath("//span[text()='Telefon numarası veya e-posta adresiyle kaydol']")).click();
        Faker faker=new Faker();
        //select[@id='SELECTOR_1']
        WebElement name=driver.findElement(By.xpath("(//input[@autocapitalize='sentences'])[1]"));
        name.sendKeys(faker.name().name());

        Select select1=new Select(driver.findElement(By.xpath("//select[@id='SELECTOR_1']")));
        select1.selectByIndex(faker.number().numberBetween(1,13));
        Select select2=new Select(driver.findElement(By.xpath("//select[@id='SELECTOR_2']")));
        select2.selectByIndex(faker.number().numberBetween(1,32));
        Select select3=new Select(driver.findElement(By.xpath("//select[@id='SELECTOR_3']")));
        select3.selectByIndex(faker.number().numberBetween(select3.getOptions().size()-(select3.getOptions().size()-1),select3.getOptions().size()));
        WebElement telNumber=driver.findElement(By.xpath("(//input[@autocapitalize='sentences'])[2]"));

        WebElement ileri=driver.findElement(By.xpath("//span[text()='İleri']"));
        do{telNumber.sendKeys(faker.phoneNumber().cellPhone());
        }while (ileri.isEnabled());
        ileri.click();
        WebElement ileri2= driver.findElement(By.xpath("(//div[@role='button'])[2]"));
        ileri2.click();
        WebElement kaydol= driver.findElement(By.xpath("(//div[@role='button'])[3]"));
        kaydol.click();

    }

    //twitter a faker class kullanarak mail ile kayit olmaya calisiniz

    //actions class kullanmayin twitteri deneyen instagram i denesin

}
