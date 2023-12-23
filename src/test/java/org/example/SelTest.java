package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SelTest {
  WebDriver driver = new ChromeDriver();

  @BeforeMethod
  public void setup(){
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

    // Navigate to a website
    driver.get("https://www.google.com");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

    @Test
      public void openUrl(){

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(actualTitle,expectedTitle);

        }
    @Test
    public void checkValue(){
     boolean flag =  driver.findElement(By.xpath("//textarea[@id='APjFqb']")).isEnabled();
     Assert.assertTrue(flag);
    }

    @AfterTest
    public void tearDown(){
      // Close the browser
      driver.quit();

    }

}
