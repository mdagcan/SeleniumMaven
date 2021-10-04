import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButton {
    WebDriver driver;
    @Before
    public void setUp () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://tr-tr.facebook.com/");
        Thread.sleep(3000);
    }

    @Test
    public void test1CreateNewAccount () throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Yeni Hesap Oluştur')]")).click();
        Thread.sleep(1000);
    }

    @Test
    public void test2SelectRadioButton () throws InterruptedException {
        driver.findElement(By.xpath("//input[contains(@id,'u_2_2')]")).click(); Thread.sleep(3000);
        driver.findElement(By.xpath("//input[contains(@id,'u_2_3')]")).click(); Thread.sleep(3000);
    }
    @After
    public void tearDown () {
        driver.close();
    }
}
