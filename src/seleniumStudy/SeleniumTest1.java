/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumStudy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author asun
 */

public class SeleniumTest1 {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.ie.driver","D:\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();  
        Timeouts timeout = driver.manage().timeouts();
        
        Navigation navigation = driver.navigate();
        navigation.to("http://pond.morningstar.com/index.php?c=China&cn=China");
//        timeout.pageLoadTimeout(30, java.util.concurrent.TimeUnit.SECONDS);
//        timeout.pageLoadTimeout(30, java.util.concurrent.TimeUnit.SECONDS);
        
        WebDriverWait wait = new WebDriverWait(driver,20);
        
        WebElement sign = driver.findElement(By.linkText("Sign In"));
        sign.click();
        WebElement username = driver.findElement(By.name("log")); 
        username.sendKeys("asun");
        WebElement pwd = driver.findElement(By.name("pwd")); 
        pwd.sendKeys("Kwan_9888");
        WebElement login = driver.findElement(By.id("go_submit"));
        login.click();
        wait.until(new ExpectedCondition<WebElement>(){  
            @Override
            public WebElement apply(WebDriver d) {  
                return d.findElement(By.name("input"));  
            }}).sendKeys("adrian sun");
        
        WebElement go = driver.findElement(By.id("go"));
        go.click();
        
        Runtime runTime = Runtime.getRuntime();
        runTime.exec("tskill iexplore");
        runTime.exec("tskill IEDriverServer");
//        driver.close();
    }
}
