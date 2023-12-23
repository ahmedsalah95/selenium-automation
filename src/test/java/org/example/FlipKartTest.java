package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FlipKartTest {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        // Navigate to a website
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testSearchForIphone(){

    WebElement searchInput = driver.findElement(By.name("q"));

    searchInput.sendKeys("iphone");

    searchInput.submit();

    String resultText = driver.findElement(By.xpath("//span[normalize-space()='iphone']")).getText();

    String expectedResult = "iphone";

    Assert.assertEquals(resultText,expectedResult);

    }

//    @Test
//    public void testFilter(){
//     WebElement filterFourStars =    driver.findElement(By.cssSelector("div[title='4★ & above'] div:nth-child(2)"));
//     filterFourStars.click();
//
//    }


    @AfterTest
    public void tearDown(){
        // Close the browser
        driver.quit();

    }

}
