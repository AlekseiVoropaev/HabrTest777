package com.example.habrtest777;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void HabrTest() {

        WebElement filterchanges = driver.findElement(By.xpath("//*[contains(@class,'tm-svg-img icon_dropdown-arrow')]"));
        filterchanges.click();

        WebElement applybutton = driver.findElement(By.xpath("//*[contains(text(),'Применить')]"));

        assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Применить')]")).isDisplayed(),"все сломалось");
        applybutton.click();









    }


}
