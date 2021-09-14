import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Google_image_upload {
   WebDriver driver;


    @Before
    public void setup()
    {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
    }

    @Test
    public void google_img_upload() throws InterruptedException {

        driver.get("https://www.google.com/");
        Actions action = new Actions(driver);
//       List<WebElement> list = driver.findElements(By.className("gb_f"));
//       list.get(1).click();
       driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"sbtc\"]/div/div[3]/div[2]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"dRSWfb\"]/div/a")).click();
        WebElement uploadElement = driver.findElement(By.id("awyMjb"));
        uploadElement.sendKeys("C:\\Users\\Hp\\Pictures\\ovi.jpg");
        Thread.sleep(3000);
        String title = driver.getTitle();
        Thread.sleep(2000);
        System.out.println(title);
        Assert.assertTrue(title.contains("Google Search"));



        Thread.sleep(2000);



    }


    @After
    public void finishTest ()
    {

        driver.close();
    }
}
