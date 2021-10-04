import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class CheckBox {
    WebDriver driver;
    @Before
    public void setUp () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(3000);
    }

    @Test
    public void checkBoxControl () throws InterruptedException {
        WebElement checkBox_1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkBox_2 = driver.findElement(By.xpath("//input[2]"));
        if (checkBox_1.isSelected()) {
            System.out.println("CheckBox_1 is selected");; Thread.sleep(3000);
        }else {
            System.out.println("CheckBox_1 is not selected");; Thread.sleep(3000);
        }
        if (checkBox_2.isSelected()) {
            System.out.println("CheckBox_2 is selected");; Thread.sleep(3000);
        } else {
            System.out.println("CheckBox_2 is not selected");; Thread.sleep(3000);
        }
    }

    @Test
    public void checkBoxMethod () throws InterruptedException {
        WebElement checkBox_1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkBox_2 = driver.findElement(By.xpath("//input[2]"));
        if (!checkBox_1.isSelected()) {
            checkBox_1.click(); Thread.sleep(3000);
        }
        if (!checkBox_2.isSelected()) {
            checkBox_2.click(); Thread.sleep(3000);
        }
    }
    @After
    public void tearDown () throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
