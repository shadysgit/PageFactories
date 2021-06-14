package com.w2a.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Page {


    public static WebDriver driver;
    public static Logger log = Logger.getLogger(Page.class);
    public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"/src/test/resources/excel/TestData.xlsx");
    public static WebDriverWait wait;
    public ExtentReports rep = ExtentManager.getInstance();
    public static ExtentTest test ;



    public static void initConfiguration(){

        if (driver == null){

            Map<String,Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service",false);
            prefs.put("profile.password_manager_enabled",false);
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("excludeSwitches", new String[]{"enable-automation"});

            if (Constants.BROWSER.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--disable-extensions");
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                log.debug("Chrome driver loaded");
            }
            else if (Constants.BROWSER.equals("ie")) {
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/src/test/resources/executables/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                log.debug("IE driver loaded");

            }

            else if (Constants.BROWSER.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/executables/geckodriver.exe");
                driver = new FirefoxDriver();
                log.debug("gecko driver loaded");

            }

            driver.get(Constants.TESTSITEUTL);
            log.debug("launching testURL");
            driver.manage().timeouts().implicitlyWait(Constants.IMPLICITWAIT, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver,5);
            log.debug("Timeout has been set");



        }



    }


    public static WebElement ajaxSelect(List<WebElement> elements, String airport){

        for (WebElement element : elements){
            if (element.getText().contains(airport)){
                return element;
            }
        }
        return null;
    }

    public static void quitBrowser(){
        driver.quit();
    }


}
