package com.pdf.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class PDFTest {

    private WebDriver driver;
    private static final String target_url = "https://www.orimi.com/pdf-test.pdf";

    public void setup_browser(Boolean status) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(status); //set headless mode true or false
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @Test
    public void test1() throws InterruptedException {
        System.out.println("Starting test #1");
        setup_browser(false);
        driver.navigate().to(target_url);
        Thread.sleep(5000);

        System.out.println("Current URL : " + driver.getCurrentUrl());
        Assert.assertEquals(target_url, driver.getCurrentUrl());
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println("Starting test #2");
        setup_browser(true);
        driver.navigate().to(target_url);
        Thread.sleep(5000);

        System.out.println("Current URL : " + driver.getCurrentUrl());
        Assert.assertEquals(target_url, driver.getCurrentUrl());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
