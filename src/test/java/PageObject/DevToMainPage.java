package PageObject;

import org.openqa.selenium.WebDriver;

public class DevToMainPage {

    WebDriver driverInDevToMainPage;
    String url = "https://dev.to/";

    public DevToMainPage(WebDriver driverFromPageObjectTests) {
        this.driverInDevToMainPage = driverFromPageObjectTests;
        // przypisanie zależnosci przeglądarki klasy PageObjectTests do przeglądarki uzywanej w klasie DevToMainPage
        driverInDevToMainPage.get(url); //otwieramy stronę w przeglądarce

    }
}
