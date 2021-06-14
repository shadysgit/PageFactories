package com.w2a.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageLocators {

    @FindBy(xpath = "//span[text() = 'Flights']//parent::a")
    public WebElement flightTab;


    //Book Return Flight
    @FindBy(xpath = "//span[text() = 'Return']//parent::a")
    public WebElement returnBtn;

    @FindBy(css = "#location-field-leg1-origin-input + button")
    public WebElement leavingFromBtn; //Bengaluru (BLR - Kempegowda Intl.)

    @FindBy(css = "#location-field-leg1-origin")
    public WebElement leavingFromBtn_input; //Bengaluru (BLR - Kempegowda Intl.)

    @FindBy(xpath = "//li[@class = 'uitk-typeahead-result-item has-subtext']//div//strong")
    public List<WebElement> airportList;

    @FindBy(css = "#location-field-leg1-destination-input + button ")
    public WebElement goingToBtn; //Sydney (SYD - Kingsford Smith Intl.)

    @FindBy(css = "#location-field-leg1-destination")
    public WebElement goingToBtn_input; //Bengaluru (BLR - Kempegowda Intl.)

    @FindBy(css = "#d1")
    public WebElement departingDateBtn; //2021-06-20

    @FindBy(css = "#d2")
    public WebElement returningDateBtn;




// Search Button
    @FindBy(xpath = "//button[text() = 'Search']")
    public WebElement searchBtn;


}
