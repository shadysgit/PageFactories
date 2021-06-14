package com.w2a.actions;

import com.w2a.base.Page;
import com.w2a.locators.HomePageLocators;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends Page {


    public HomePageLocators home ;

    public HomePage(){
        home = new HomePageLocators();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this.home);
    }

    public HomePage goToFlights(){
        home.flightTab.click();

        return this;

    }


    public void bookReturnFlight(String leavingFrom , String goingTo , String departingDate , String arrivingDate) throws InterruptedException {

        home.returnBtn.click();
        home.leavingFromBtn.click();
        home.leavingFromBtn_input.sendKeys(leavingFrom);
        Page.ajaxSelect(home.airportList,leavingFrom).click();

        home.goingToBtn.click();
        home.goingToBtn_input.sendKeys(goingTo);
        Thread.sleep(3000);
        Page.ajaxSelect(home.airportList,goingTo).click();

        //home.departingDateBtn.sendKeys(departingDate);
        //home.returningDateBtn.sendKeys(arrivingDate);
        home.searchBtn.click();

    }

}
