/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/**
 *
 * @author ASUS
 */
public class AUTest1 {
    
    public AUTest1() {
    }
    WebDriver driver = null;

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void login(){
        driver.get("http://pluto18.epizy.com");
//            driver.wait(5000);
//
//        driver.findElement(By.id("buttoncheck")).click();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
        String expectedResult = "Home Page";
        String actualResult = driver.findElement(By.xpath("/html/body/div/h2")).getText();
        Assert.assertEquals(actualResult, expectedResult);
        if(expectedResult == actualResult){
            System.out.println("Login Success");
        }
    }
    
    @Test
    public void faillogin(){
        driver.get("http://pluto18.epizy.com");
//        
//        driver.findElement(By.id("buttoncheck")).click();
        
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin12");
        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
        String expectedResult = "Wrong username or password!";
        String actualResult = driver.findElement(By.xpath("/html/body/div/div")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
    
    @Test
    public void klikhome(){
        driver.get("http://pluto18.epizy.com");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
        driver.findElement(By.xpath("/html/body/nav/div/a[1]")).click();
        String expectedResult = "Home Page";
        String actualResult = driver.findElement(By.xpath("/html/body/div/h2")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
    
    @Test
    public void klikprofile(){
        driver.get("http://pluto18.epizy.com");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
        
        driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
        String expectedResult = "Profile Page";
        String actualResult = driver.findElement(By.xpath("/html/body/div/h2")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
    
    @Test
    public void kliklogout(){
        driver.get("http://pluto18.epizy.com");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
        
        driver.findElement(By.xpath("/html/body/nav/div/a[3]")).click();
        String expectedResult = "Login";
        String actualResult = driver.findElement(By.xpath("/html/body/div/h1")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
