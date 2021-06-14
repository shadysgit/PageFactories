package com.w2a.rough;

import com.w2a.actions.HomePage;
import com.w2a.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Test {

    public static void main(String[] args) throws InterruptedException {


        Page.initConfiguration();
        HomePage home = new HomePage();
        home.goToFlights();

        Actions act = new Actions(Page.driver);
        Page.driver.findElement(By.cssSelector("#location-field-leg1-origin-input + button")).click();
        Page.driver.findElement(By.cssSelector("#location-field-leg1-origin")).sendKeys("Bengaluru (BLR - Kempegowda Intl.)");
        Thread.sleep(2000);
        Page.driver.findElement(By.xpath("//strong[text() = 'Bengaluru (BLR - Kempegowda Intl.)']//ancestor::button")).click();

        act.sendKeys(Keys.ENTER);

        Page.driver.findElement(By.cssSelector("#location-field-leg1-destination-input + button")).click();
        Page.driver.findElement(By.cssSelector("#location-field-leg1-destination")).sendKeys("Sydney (SYD - Kingsford Smith Intl.)");
        Thread.sleep(2000);
        Page.driver.findElement(By.xpath("//strong[text() = 'Sydney (SYD - Kingsford Smith Intl.)']//ancestor::button")).click();
        act.sendKeys(Keys.ENTER);


        Page.driver.findElement(By.xpath("//button[text() = 'Search']")).click();

        Thread.sleep(3000);
        Page.quitBrowser();


    }

}
