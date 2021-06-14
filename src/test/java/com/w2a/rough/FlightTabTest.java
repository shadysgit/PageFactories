package com.w2a.rough;

import com.w2a.actions.HomePage;
import com.w2a.base.Page;

public class FlightTabTest {
    public static void main(String[] args) throws InterruptedException {

        Page.initConfiguration();
        HomePage home = new HomePage();
        home.goToFlights().bookReturnFlight("BLR","DEL",
                "2021-06-20","2021-06-25");
        Thread.sleep(3000);
        Page.quitBrowser();

    }


}
