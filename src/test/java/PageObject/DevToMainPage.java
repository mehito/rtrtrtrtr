package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevToMainPage {

    WebDriver driverInDevToMainPage;
    String url = "https://dev.to/";

    @FindBy(xpath = "//a[@href='/pod']")
    WebElement podcastsBtn;
    // definujemy elementy których będziemy uzywac w obrębie tej klasy



    public DevToMainPage(WebDriver driverFromPageObjectTests) {
        this.driverInDevToMainPage = driverFromPageObjectTests;
        // przypisanie zależnosci przeglądarki klasy PageObjectTests do przeglądarki uzywanej w klasie DevToMainPage
        driverInDevToMainPage.get(url); //otwieramy stronę w przeglądarce
        PageFactory.initElements(driverInDevToMainPage,this);
    }
    public DevToPodcatsPage selectPodcasts(){
        podcastsBtn.click();
        return new DevToPodcatsPage(driverInDevToMainPage);
    }
}
