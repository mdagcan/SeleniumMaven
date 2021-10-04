import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleHomepageTest {
    WebDriver driver;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }
    @Test
    public void titleTest() {
        String actualGoogleTitle = driver.getTitle();
        String expectedGoogleTitle = "Google";
        Assert.assertEquals(expectedGoogleTitle,actualGoogleTitle);
    }

    @Test
    public void imageTest() {
        WebElement googleImage = driver.findElement(By.xpath("//img[@id='hplogo']"));
        Assert.assertTrue(googleImage.isDisplayed());
    }

    @Test
    public void gmailLinkTest() {
        WebElement gmailLink = driver.findElement(By.xpath("//a[contains(text(),'Gmail')]"));
        Assert.assertTrue(gmailLink.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.close();
    }


}
