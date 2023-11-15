package org.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class WebDriverDemo {

    @Test
    public void testingPositives(){
        WebDriver driver = new FirefoxDriver();
        //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch website
        driver.navigate().to("http://www.calculator.net/");

        //Maximize the browser
        driver.manage().window().maximize();

        // Click on Math Calculators
        driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[3]/div[2]/a")).click();

        // Click on Percent Calculators
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/table[2]/tbody/tr/td/div[3]/a")).click();

        // Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("10");

        // Enter value 50 in the second number of the percent Calculator
        driver.findElement(By.id("cpar2")).sendKeys("50");

        // Click Calculate Button
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/form[1]/table/tbody/tr[2]/td/input[2]")).click();


        // Get the Result Text based on its xpath
        String result =
                driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();


        // Print a Log In message to the screen
        assertEquals(result,"5");

        //Close the Browser.
        driver.close();
    }

    @Test
    public void testingNegatives(){
        WebDriver driver = new FirefoxDriver();
        //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch website
        driver.navigate().to("http://www.calculator.net/");

        //Maximize the browser
        driver.manage().window().maximize();

        // Click on Math Calculators
        driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[3]/div[2]/a")).click();

        // Click on Percent Calculators
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/table[2]/tbody/tr/td/div[3]/a")).click();

        // Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("20");

        // Enter value 50 in the second number of the percent Calculator
        driver.findElement(By.id("cpar2")).sendKeys("-140");

        // Click Calculate Button
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/form[1]/table/tbody/tr[2]/td/input[2]")).click();


        // Get the Result Text based on its xpath
        String result =
                driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();


        // Print a Log In message to the screen
        assertEquals(result,"-28");

        //Close the Browser.
        driver.close();
    }
    @Test
    public void testingInvalidInput(){
        WebDriver driver = new FirefoxDriver();
        //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch website
        driver.navigate().to("http://www.calculator.net/");

        //Maximize the browser
        driver.manage().window().maximize();

        // Click on Math Calculators
        driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[3]/div[2]/a")).click();

        // Click on Percent Calculators
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/table[2]/tbody/tr/td/div[3]/a")).click();

        // Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("a");

        // Enter value 50 in the second number of the percent Calculator
        driver.findElement(By.id("cpar2")).sendKeys("3");

        // Click Calculate Button
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/form[1]/table/tbody/tr[2]/td/input[2]")).click();


        // Get the Result Text based on its xpath
        String result =
                driver.findElement(By.xpath("/html/body/div[3]/div[1]/p[2]/font")).getText();


        // Print a Log In message to the screen
        assertEquals(result,"Please provide two numeric values in any fields below.");

        //Close the Browser.
        driver.close();
    }
}